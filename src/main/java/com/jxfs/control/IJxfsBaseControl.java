package com.jxfs.control;
/*
Base interface for all the device controls. Contains methods common to all the device controls.
All methods in the IJxfsBaseControl are synchronous, unless it is explicitly stated otherwise.
There is no general timeout control available for asynchronous methods. Unless a method specifically makes it possible for the user to specify a timeout value, a timeout will not occur. All asynchronous methods can be cancelled.
Any method which is not listed as being able to throw the JXFS_E_CLOSED exception can be executed before the open method.
The JXFS_E_REMOTE exceptions will only ever be thrown by device comm objects (i.e. the communications sub-system) and never directly by a device service or control.
 */

import com.jxfs.general.JxfsDeviceInformation;
import com.jxfs.general.JxfsStatus;
import com.jxfs.general.JxfsType;
import com.jxfs.general.JxfsVersion;
import com.jxfs.events.JxfsException;
import com.jxfs.events.IJxfsIntermediateListener;
import com.jxfs.events.IJxfsOperationCompleteListener;
import com.jxfs.events.IJxfsStatusListener;
import com.jxfs.service.IJxfsBaseService;
import java.util.Vector;



public interface IJxfsBaseControl {
	/*
	* This method must be the first method an application calls in a newly generated Device Control in order to use all other functions. Exceptions are the methods addXXXListener, getStatus()and getStatus(java.util.List). A call to any other method will throw a JxfsException with code JXFS_CLOSED.
	* This is the first time the device is physically accessed. It is asynchronous4 and returns an identificationID. After the open has completed a JxfsOperationCompleteEvent with operationID = JXFS_O_OPEN and the given identificationID is sent to the application. The result is either JXFS_RC_SUCCESSFUL or one of the error codes.
	* After the open operation has been issued (but even before the OC Event has arrived) any other method is callable. Operation requests are queued for execution. If the open request fails, all queued requests will not be executed but responded with an operation complete event with an error code of JXFS_E_CLOSED.
	* But, of course the correct behavior for an application is rather to wait for the OCEvent of the open() and only then start using the device.
	* The open() must only fail for severe, unrecoverable errors (these kind of errors are implementation dependent). Minor defects should be noticed by the DS but the open() should succeed. For details on this please also see the device specifications detailing more on the correct open() behaviour. 
	* Even if the open() fails, Status events are generated to inform the application that the Device status has changed. The application may then re-try to open the device.
	*/
	int open() throws JxfsException;

	/*
	* Finishes the usage of the device by the application. If this is the last connected Device Control to issue close, this method disables further use of the device and releases any resources currently in use. All properties are reset to their initial default state.
	* The device must be released before close() is called.
	* This method is asynchronous and returns an identificationID. After that it returns a JxfsOperationCompleteEvent with operationID = JXFS_O_CLOSE. the given identificationID and a result (most likely JXFS_RC_SUCCESSFUL). 
	* Exceptios:
	*	JXFS_E_UNREGISTERED
	*	JXFS_E_CLOSED
	*/
	int close() throws JxfsException;

	/*
	* This method attempts for the time specified by timeout (specified in milliseconds) to gain exclusive access to the device. This method returns control to the application when the claim is granted or when the timeout expires.
	* The Device Control will generate a unique tag (via the Device Manager generateUniqueTag method) for use with the Device Service claim method.
	* This will ensure that only this Device Control can claim the Device Service, if successful.
	* This behaviour means that when this call is made by an application, no other Device Control in this application, or any other application, can share access to the device.
	* A claim is granted if no other Device Control has claimed the device and only after all pending operations are finished. All the operation requests are queued.
	* As soon as a claim request is granted at the Device Service any operation requests from the DC holding the claim are the only ones which are processed.
	* Operations from other DC’s are queued until after the release is done.
	* If timeout is equal to JXFS_FOREVER (-1) then the operation waits as long as needed for the device to become available.
	* The return value is equal to true if claim() succeeds. The return value is equal to FALSE if claim() has timed out.
	* An application should release the claimed device as soon as possible.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLAIMED Device is already claimed by caller.
	* 	JXFS_E_CLOSED The open call has not been issued yet.
	* 	JXFS_E_REMOTE Communication error during remote call.
	* 	JXFS_E_PARAMETER_INVALID Invalid value for timeout parameter.
	*/
	boolean claim(int timeout) throws JxfsException;

	/*
	* This method attempts for the time specified by timeout (specified in milliseconds) to gain exclusive access to the device. This method returns control to the application when the claim is granted or when the timeout expires.
	* If successful, the tag parameter will be used to allow subsequent claims from other Device Controls within the same application to also claim the device. It is the application’s responsibility to create a sufficiently unique tag, typically by using the Device Manager generateUniqueTag method to create a unique tag.
	* A claim is granted if the device is not claimed by a Device Control with a different tag (or no tag) and only after all pending operations are finished. All the operation requests are queued. As soon as a claim request is granted at the Device Service any operation requests from the Device Control(s) holding the claim are the only ones which are processed. Operations from other DCs are queued until after the release is done.
	* If timeout is equal to JXFS_FOREVER (-1) then the operation waits as long as needed for the device to become available. 
	* The return value is equal to true if claim() succeeds. The return value is equal to FALSE if claim() has timed out.
	* An application should release the claimed device as soon as possible.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLAIMED Device is already claimed by caller.
	* 	JXFS_E_CLOSED The open call has not been issued yet.
	* 	JXFS_E_REMOTE Communication error during remote call.
	* 	JXFS_E_PARAMETER_INVALID Invalid value for timeout parameter.
	* 	JXFS_E_NOT_SUPPORTED This method is not supported.
	*/
	boolean claim(String tag, int timeout) throws JxfsException;

	/*
	* Removes exclusive access to the device for this Device Control.
	* This will wait for all running asynchronous operations from the claiming DC to finish, but only up to “timeout” milliseconds. Then the queued operations from other DCs are executed. If another claim() requests arrives at execution position it will be granted. This method returns true if the release was successful, and
	* FALSE if device operations are still pending after “timeout” milliseconds. In that case the release was NOT done and the DC has to re-issue this command (possibly after canceling an operation which ‘hangs’).
	* If other Device Controls have a valid claim when this call is made then release only removes this Device Control from having a claim against the device. All other current claims remain in effect. In this circumstance this call will wait for all running asynchronous operations from this Device Control to finish, but only up to “timeout” milliseconds.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_NOTCLAIMED Device was not claimed by caller.
	* 	JXFS_E_CLOSED The open call has not been issued yet.
	* 	JXFS_E_REMOTE Communication error during remote call.
	* 	JXFS_E_PARAMETER_INVALID Invalid value for timeout parameter.
	*/
	boolean release(int timeout) throws JxfsException;


	/*
	* This method attempts to stop the operation specified by the identificationID. If it can do so, a JxfsOperationCompleteEvent is sent which indicates that the operation was cancelled. If this method is called after an operation has completed but before the operation complete event has been returned to the caller, then no operation will take place and no exception will be thrown; eventually the operation complete event will still be returned.
	* The identificationID is returned by the Device Control to the application by any asynchronous operation request. If an invalid Id is presented here, or the operation with this Id has already finished, no action takes place.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED The open call has not been issued yet.
	* 	JXFS_E_REMOTE Communication error during remote call.
	*/
	void cancel(int identificationID) throws JxfsException;

	/*
	* This method returns a JxfsStatus object which contains the current status of the J/XFS device. This method may be called before the control has been opened. In this case whether the status returned is accurate or fake is implementation dependant.
	* The following is deprecated in favour of the status selector approach:
	* Every device can return a device specific JxfsStatus object that extends the JxfsStatus (e.g. JxfsPrinterStatus etc.). For detailed information see the separate chapter on the JxfsStatus object.Usually, it is not a JxfsStatus object returned here but one of its subclasses, depending on which device type is queried.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_REMOTE Communication error during remote call.
	*/
	JxfsStatus getStatus() throws JxfsException;

	
	/*
	* This method returns different combinations of status information in one call.
	* The status information to be returned is defined by the List of Status Selector Enums. Each of these Enums represent the status object to be returned. To retrieve the whole status information in one call an empty list should be passed.
	* The returned java.util.map contains the Status Selector Enum as keys and the correspondant status object as value.
	* For detailed information see separate chapter on JxfsStatus.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_REMOTE Communication error during remote call.
	*/
	java.util.Map getStatus(java.util.List list) throws JxfsException; //TODO: Validate parameters for Map and List

	/*
	* These methods are used by the application to register as a listener to receive the given type of events. They return true if the listener was registered successfully. 
	*/
	boolean addIntermediateListener(IJxfsIntermediateListener l);
	boolean addOperationCompleteListener(IJxfsOperationCompleteListener l);
	boolean addStatusListener(IJxfsStatusListener l);

	/*
	* These methods are used by the application to deregister itself as a listener of the given type of events. They return true if the listener was removed.
	*/
	boolean removeIntermediateListener(IJxfsIntermediateListener l);
	boolean removeOperationCompleteListener(IJxfsOperationCompleteListener l);
	boolean removeStatusListener(IJxfsStatusListener l);

	/*
	* Get the unique device name for this device (Type and distinction between similar devices, e.g. port name). Used to identify the device. This is the logical name key given in the configuration repository.
	*/
	String getDeviceName();

	/*
	* Return the version object of this Device Control. See the chapter on versioning for a detailed explanation.
	*/
	JxfsVersion getDeviceControlVersion();

	/*
	* Return the version object of this Device Service. See the chapter on versioning for detailed explanation.
	* Exceptions:
	*	JXFS_E_UNREGISTERED Device is not registered at the DM.
	*	JXFS_E_REMOTE Communication error during remote call.
	*/
	JxfsVersion getDeviceServiceVersion() throws JxfsException;

	/*
	* The physical device description, e.g. “Acme Magstripe Reader Model 36 subtype 5 (c) 1997 Acme corp.”
	* Exceptions: 
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet
	* 	JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_REMOTE Communication error during remote call
	*/
	String getPhysicalDeviceDescription() throws JxfsException;

	/*
	* The physical device’s name, e.g. “Acme MSD 36/5” Exceptions JXFS_E_UNREGISTERED Device is not registered at the DM.
	* Exceptions:
	* 	JXFS_E_CLOSED Device has not been opened yet
	* 	JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_REMOTE Communication error during remote call 
	*/
	String getPhysicalDeviceName() throws JxfsException;

	/*
	* Asynchronous function to trigger a firmware update. Returns true if the update process could be started. Delivers a JxfsOperationCompleteEvent with operationID = JXFS_O_UPDATEFIRMWARE and a result when finished. The identificationID is not used because only one update can be active at any time.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_FIRMWARE Nothing to update / available firmware doesnot match.
	* 	JXFS_E_NOT_SUPPORTED Operation not supported by this device.
	* 	JXFS_E_REMOTE Communication error during remote call 
	*/
	boolean updateFirmware() throws JxfsException;

	/*
	* Checks the firmware in the device against the one found in the repository and return:
	* Result:
	* 	OK_NEWER Firmware in repository is newer than firmware in device.
	* 	OK_OLDER Firmware in repository is older (!) than firmware in device. Update possible (but not recommended).
	* 	OK_EQUAL Firmware in the repository is equal to the firmware in the device. Update possible.
	* 	OK_OTHER Firmware in repository has a different functionality, but an update is possible.
	* 	NO_SOURCE Update not possible, no firmware found in repository.
	* 	NO_MATCH Update not possible, firmware in repository not correct for this device.
	* 	NO_SUPPORT No firmware update possibility with this device.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device is closed.
	* 	JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_REMOTE Communication error during remote call.
	*/
	int getFirmwareStatus() throws JxfsException;

	/*
	* Returns a JxfsVersion object informing about the loaded version of the firmware in the device.
	* Exceptions: 
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet
	* 	JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_NOT_SUPPORTED Operation not supported by this device.
	* 	JXFS_E_REMOTE Communication error during remote call
	*/
	
	JxfsVersion getDeviceFirmwareVersion() throws JxfsException;

	/*
	* Returns a JxfsVersion object informing about the available version of the firmware in the repository.
	* Exceptions JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet
	*	JXFS_E_NOT_SUPPORTED Operation not supported by this device.
	*	JXFS_E_REMOTE Communication error during remote call
	*/
	JxfsVersion getRepositoryFirmwareVersion() throws JxfsException;

	/*
	* Returns true if the attached device is capable of going to and returning from a power save mode.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet
	* 	JXFS_E_REMOTE Communication error during remote call
	*/
	boolean isPowerSaveModeSupported() throws JxfsException;

	/*
	* This method can be used by the application to actively request that the device becomes active again. It initiates the wakeup (if needed) and returns immediately. The int that is returned specifies the average time in seconds needed to get back to an active state (or –1 if n/a). If the device is powered up again a JxfsStatusEvent with JXFS_S_POWERSAVEOFF is sent.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	*	JXFS_E_CLOSED Device has not been opened yet
	*	JXFS_E_REMOTE Communication error during remote call
	*/
	int wakeUpFromPowerSave() throws JxfsException;

	/*
	* This method gives an application the means to access device specific functions which only apply to a specific physical device. The application can check for the availability of the special hardware e.g. via the getDeviceServiceDescription() method.
	* As the device may reside on another machine, the subclass of JxfsType containing the data must be serializable.
	* The service itself can either synchronously work on the command and return immediately or work asynchronously and notify the application via the usual intermediate and operation complete events (with special codes) during and after completion.
	* The default behavior of any services not having additional commands is to throw a JXFS_E_NOT_SUPPORTED exception.
	* For an exact description of how to use this method see the explanation in the chapter on 'Vendor specific functionality'.
	* Exceptions:
	* 	JXFS_E_UNREGISTERED Device is not registered at the DM.
	* 	JXFS_E_CLOSED Device has not been opened yet
	* 	JXFS_E_NOHARDWARE Device is not connected to the workstation.
	* 	JXFS_E_CLAIMED This method is not available at this time because the device is currently claimed for exclusive access by another control.
	* 	JXFS_E_NOT_SUPPORTED Operation not supported by this device.
	* 	JXFS_E_REMOTE Communication error during remote call
	*/
	int directIO(int command, JxfsType serializable) throws JxfsException;

	/*
	* This method must be used by the application to inform the Device Control that will no longer be used.
	* This allows the DC to remove the connection to the Device Service and free up any allocated resources.
	* Any method of the DC which needs to access the Device Service from now on only returns a JXFS_E_UNREGISTERED exception.
	* Exceptions: 
	* 	JXFS_E_OPEN Device is still open.
	* 	JXFS_E_REMOTE Communication error during remote call
	*/
	void deregisterDevice() throws JxfsException;

	/*
	* This method informs the application whether the associated Device Control represents a device which is part of an inter-dependent device.
	* A device is inter-dependent if either of the following circumstances apply:
	* * If two or more devices share the same physical component. For example a journal & passbook printer may share the same print head.
	* * If two or more logical devices are mapped onto one physical device. For example, a printer that serves as both as document & passbook printer.
	* This method returns true if the device is inter-dependent, FALSE otherwise.
	*/
	boolean isInterDependentDevice() throws JxfsException;

	/*
	* This method returns a vector of strings which contains the names of all devices that make up this interdependent device. The name of each device returned is the logical name as described in the DeviceInformation object getDeviceName method.
	* Note that getInterDependentDevices returns the names of all devices, including the name of the device associated with the calling/called Device Control.
	* Exceptions:
	*	 JXFS_E_ILLEGAL Device is not part of an interdependent device.
	*/
	Vector<?> getInterDependentDevices() throws JxfsException;
 
	//Internal Methods //TODO: private???
	/*
	* Necessary to successfully connect the Device Control to its Device Service and the Device Manager. They are only for J/XFS internal use and are only briefly outlined here. 
	* These methods must not be called by applications although this is not enforced.
	*/

	/*
	* This method is used by the Device Manager to initialize the Device Control by providing a reference to the service object itself. The Device Manager also provides the appropriate Device Information for the DC’s use. 
	*/
	void registerService(IJxfsBaseService myService, JxfsDeviceInformation di) throws JxfsException;

	/*
	* This method is called by any communication layer to inform the Device Control that the connection to the DS is broken.
	* The Device Control now has to approve this fact by using its deregisterService() functionality and must send the application a JxfsStatusEvent with JXFS_S_REMOTEFAILURE.
	* The exact details of the connection failure are written to the logger by the communication layer.
	*/
	void connectionFailure();
}






