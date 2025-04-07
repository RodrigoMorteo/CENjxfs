package com.jxfs.service;
/*
* All methods in the IJxfsBaseService interface are synchronous, unless it is explicitly stated otherwise.
* There is no general timeout control available for asynchronous methods. Unless a method specifically makes it possible for the user to specify a timeout value, a timeout will not occur. All asynchronous methods can be cancelled.
* Any method which is not listed as being able to throw the JXFS_E_CLOSED exception can be executed before the open method.
* The JXFS_E_REMOTE exceptions will only ever be thrown by device comm objects (i.e. the communications sub-system) and never directly by a device service or control.
* If a device service is called with any method before the initialize method, or after the initialize method fails, then the device service should return JXFS_E_FAILURE. 
*/

import com.jxfs.events.IJxfsEventNotification;
import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsLocalDeviceInformation;
import com.jxfs.general.JxfsStatus;
import com.jxfs.general.JxfsType;
import com.jxfs.general.JxfsVersion;

import java.util.Vector;


public interface IJxfsBaseService {

    /*
    * This method must be the first method a control (identified by control_id) calls in a newly generated Device Control in order to use all other functions. Exceptions are the addXXXListener methods, getStatus() and getStatus(java.util.List). The device service is required to obtain and cache device status before an open is issued; although precisely when this occurs is an implementation detail. A call to another methods throws a JxfsException with code JXFS_CLOSED.
    * This is the first time the device is physically accessed. It is asynchronous7 and returns an identificationID. After the open completed a JxfsOperationCompleteEvent with operationID = JXFS_O_OPEN and the given identificationID is sent to the application. The result is either JXFS_RC_SUCCESSFUL or one of the error codes.
    * After the open operation has been issued (but even before the OC Event has arrived) any other method is callable. Operation requests are queued for execution, and if the open fails, they are discarded.
    * But, of course the correct behavior for an application is rather to wait for the OCEvent of the open() and only then start using the device.
    * If the OC event returns success the device is connected to the workstation and device status is correct.
    * The open() must only fail for severe, unrecoverable errors (this kind of errors is implementation dependent). Minor defects should be noticed by the DS but the open() should succeed. For details on this please also see the device specifications detailing more on the correct open() behaviour.
    * Even if the open() fails, Status events are generated to inform the application that the Device status has changed. The application may then re-try to open the device.
    * Exceptions:
    *   JXFS_E_OPEN Device is already opened.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    int open(int control_id) throws JxfsException;

    /*
    * This method closes the device for the DC’s usage. If no other control is using it (i.e. there is no other Control that has issued an open() call), then the device is also physically closed (i.e. shutdown or deactivated).
    * This method is asynchronous and returns an identificationID. After that it returns a JxfsOperationCompleteEvent with operationID = JXFS_O_CLOSE. the given identificationID and a result (most likely JXFS_RC_SUCCESSFUL).
    * Exceptions:
    *   JXFS_E_CLAIMED Device is still claimed.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    int close(int control_id) throws JxfsException;

    /*
    * Tries to claim the device for exclusive use. See the explanation on claim in the Device Control chapter as well as the section on ‘Reserving devices for exclusive use’. Claim() returns true, if performed successfully or FALSE if not.
    * This method is now deprecated and will never be invoked by the infrastructure.
    * It is replaced by the claim method below.
    * Exceptions:
    *   JXFS_E_CLAIMED Device is still claimed.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    *   JXFS_E_PARAMETER_INVALID Invalid value for timeout parameter. 
    */
    boolean claim(int timeout, int control_id) throws JxfsException;


    /*
    * Tries to claim the device for exclusive use. See the explanation on claim in the Device Control chapter as well as the section on ‘Reserving devices for exclusive use’. Claim() returns true, if performed successfully or FALSE if not. If the timeout parameter is set to 0 then true will be returned only if the device is currently unclaimed. If a timeout value less than –1 (JXFS_FOREVER) is specified the results are implementation dependant.
    * Exceptions:
    *   JXFS_E_CLAIMED Device is still claimed.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    *   JXFS_E_PARAMETER_INVALID Invalid value for timeout parameter.
    *   JXFS_E_NOT_SUPPORTED This method is not supported. 
    */
    boolean claim(String tag, int timeout, int control_id) throws JxfsException;

    /*
    * Assuming that the calling Device Control has a current claim (Device Service keeps track of all Device Controls with a claim), this call removes access to the device for the calling Device Control. If this is the last ‘claiming’ Device Control     to release its claim then exclusive access is removed. Other Device Controls (using another unique string tag) may now successfully claim the device. It also causes the queue of waiting claim() requests to be checked and will result in the longest waiting request to be granted. The control_id identifies the control.
    * This method returns to the application when the operation is complete. If timeout occurs, e.g. an operation is still pending, FALSE is returned.
    * Exceptions 
    *   JXFS_E_NOTCLAIMED Device was not claimed by caller.   
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    *   JXFS_E_PARAMETER_INVALID
    */
    boolean release(int timeout, int control_id) throws JxfsException;

    /*
    * This method attempts to restore the device and its service back to the conditions before the operation was called, that has to be cancelled. An attempt will be made to stop the operation specified by the identificationID and to cancel any corresponding events that have not yet been reported to registered listeners. This method will try its best to cancel the specified operation. Even if there is no corresponding operation for the identificationID or the operation can not be cancelled, no exception will be thrown. If cancel() ends with success aJxfsOperationCompleteEvent will be sent. The control_id identifies the control.
    * Exceptions: 
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call. 
    */
    void cancel(int identificationID, int control_id) throws JxfsException;

    /*
    * This method returns a JxfsStatus object that reports the current status of the J/XFS device. When this method is called before an open, whether the status returned is accurate or fake is implementation dependant. Every device usually returns a device specific JxfsStatus object that extends the JxfsStatus (e.g. JxfsPrinterStatus etc.).
    * Exceptions 
    *   JXFS_E_REMOTE Communication error during remote call.
    */

    JxfsStatus getStatus(int control_id) throws JxfsException;

    /*
    * Returns the version information object of the Device Service.
    * Exceptions:
    *    JXFS_E_REMOTE Communication error during remote call. 
    */
    JxfsVersion getDeviceServiceVersion(int control_id) throws JxfsException;

    /* 
    * Description The physical device description, e.g., “Acme Magstripe Reader Model 36 subtype 5 (c) 1997 Acme corp.”
    * Exceptions:
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    String getPhysicalDeviceDescription(int control_id) throws JxfsException;


    /*
    * Description The physical device’s name, e.g., “Acme MSD 36/5”
    * Exceptions:
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call. 
    */
    String getPhysicalDeviceName(int control_id) throws JxfsException;

    /*
    * 
    * Description Asynchronous function to trigger a firmware update. Returns true if the update process could be started. Delivers a JxfsOperationCompleteEvent with operationID = JXFS_O_UPDATEFIRMWARE and a result when finished. The identificationID is not used because only one update can be active at any time.
    * Exceptions
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_FIRMWARE Nothing to update / available firmware does not match.
    *   JXFS_E_NOT_SUPPORTED Operation not supported by this device.
    *   JXFS_E_REMOTE Communication error during remote call.
    */   
    boolean updateFirmware(int control_id) throws JxfsException;

    /*
    * Checks the firmware in the device against the one found in the repository.
    * Result:
    *   OK_NEWER Firmware in repository is newer than firmware in device.
    *   OK_OLDER Firmware in repository is older (!) than firmware in device. Update possible (but not recommended).
    *   OK_EQUAL Firmware in the repository is equal to the firmware in the device. Update possible.
    *   OK_OTHER8 Firmware in repository has a different functionality, but an update is possible.
    *   NO_SOURCE Update not possible, no firmware found in repository.
    *   NO_MATCH Update not possible, firmware in repository not correct for this device.
    *   NO_SUPPORT No firmware update possibility with this device.
    * Exceptions 
    *   JXFS_E_CLOSED Device is closed.
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    int getFirmwareStatus(int control_id) throws JxfsException;

    /*
    * Return JxfsVersion objects informing about the loaded and available Versions of the firmware in the device. If the operation is not supported the according exception is thrown.
    * Exceptions 
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_NOT_SUPPORTED Operation not supported by this device.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    JxfsVersion getDeviceFirmwareVersion(int control_id) throws JxfsException;
    
    /*
    * Return JxfsVersion objects informing about the loaded and available Versions of the firmware in the device. If the operation is not supported the according exception is thrown.
    * Exceptions 
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_NOT_SUPPORTED Operation not supported by this device.
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    JxfsVersion getRepositoryFirmwareVersion(int control_id) throws JxfsException;

    /*
    * Returns true if the attached device is capable of going to and returning from a power save mode.
    * Exceptions JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    boolean isPowerSaveModeSupported(int control_id) throws JxfsException;

    /*
    * This method can be used by the application to actively request that the device becomes active again. It initiates the wakeup (if needed) and returns immediately. The int that is returned specifies the average time in seconds needed to get back to an active state (or –1 if n/a). If the device is powered up again a JxfsStatusEvent with JXFS_S_POWERSAVEOFF is sent.
    * Exceptions: 
    *   JXFS_E_CLOSED Device is already closed.
    *   JXFS_E_REMOTE Communication error during remote call.
    */
    int wakeUpFromPowerSave(int control_id) throws JxfsException;

    /*
    * This method gives an application the means to access device specific functions which only apply to a specific physical device.
    * For an exact description about the functionality see the description of the directIO in the Device Control chapter and the explanation in 'Vendor specific functionality'.
    * The default behavior of any services not having additional commands is to totally ignore this method by throwing a JxfsException with the exception code JXFS_E_NOTSUPPORTED.
    * Exceptions:
    *   JXFS_E_NOHARDWARE Device is not connected to the workstation.
    *   JXFS_E_CLOSED Device is closed.
    *   JXFS_E_CLAIMED This method is not available at this time because the device is currently claimed for exclusive access by another control.
    *   JXFS_E_NOT_SUPPORTED Operation not supported by this device.
    *   JXFS_E_REMOTE Communication error during remote call.
    */

    int directIO(int command, JxfsType serializable, int control_id) throws JxfsException;

    /*
    * This method is used by the Device Manager to deliver the detailed device information to the service.
    * Exceptions:
    *    JXFS_E_PARAMETER_INVALID The given parameter is invalid.
    */
    void initialize(JxfsLocalDeviceInformation your_info) throws JxfsException;

    /*
    * 
    * This method must be the first method that is called by the Device Control in order to register for events and identify the control during all method calls. If a method on the service is called before the registerControl method is called, or after the deregisterControl method is called, then a JXFS_E_UNREGISTERED exception should be thrown. The Device Service must keep a list of all connected controls to deliver events and check the state of the registered controls (has opened the service, has claimed the service). As long as any useful information can be retrieved from the Device Service it should be allowed to start. So, e.g. even if no hardware device is attached the service should be started, but the status should then be JXFS_S_HARDWAREERROR, as it still may be desirable to issue some other options. In this case, during the following open() a JXFS_E_NOHARDWARE is returned. The return value is an unique id identifying the control registering for this service.
    * The EventCallback object given here may also be a Device Communication object and not the Device Control itself. The device_control_type parameter given here is the name of the Device Control interface class (i.e. “IJxfsALMControl”) and allows a Device Service which implements a complex device to identify which ‘part’ of the device the DC wants to access. 
    * The returned value is greater or equal than JXFS_VALID_CONTROLID = 2. 
    * Exceptions 
    *   JXFS_E_PARAMETER_INVALID A parameter was null or otherwise invalid.
    *   JXFS_E_REMOTE Communication error during the method call.
    *   JXFS_E_EXISTS Specified Control is already registered
    */
    int registerControl(String device_control_type, IJxfsEventNotification callbacks_implementing_control) throws JxfsException;

    /*
    * This method must be the last method a Device Control object (identified by control_id) calls in a device service to deregister for events.
    * Exceptions:
    *   JXFS_E_OPEN Device is still opened.
    *   JXFS_E_ REMOTE Communication error during remote call. 
    */
    void deregisterControl(int control_id) throws JxfsException;

    /* 
    * This method is called by any communication layer to inform the Device Service that the connection to the Device Control is broken.
    * The Device Service now has to approve this fact by, if applicable, releasing, closing and deregistering on behalf of the Device Control.
    * The exact details of the connection failure are logged to the logger by the communication layer.
    */
    void connectionFailure(int control_id);

    /*
    * 
    * This method is used by the Device Manager to deactivate a Device Service. It should be implemented by the DS in a way to guarantee that it always succeeds (shouldn’t get stuck).
    * The DS ends the current job (if not possible it terminates it) and throws away all the pending jobs (without sending OC Events). Then it shuts down the physical device and writes any remaining persistent data into the repository.
    * Finally, it sends a JxfsStatusEvent with the status JXFS_S_SHUTDOWN to all registered Device Controls. They have to delete their reference to the Device Service and disable themselves (i.e. always return JXFS_E_UNREGISTERED out of any operation from now on). This event is then propagated to the application by the DC’s.
    * Exceptions:
    *    JXFS_E_REMOTE Communication error. Probably not all remote Device Controls could be informed. 
    */
    void shutdown() throws JxfsException;

    /* 
    * This method informs the Device Control whether the associated device represents a device which is part of an inter-dependent device. The Device Service returns true if the device is inter-dependent, FALSE otherwise.
    * Exceptions JXFS_E_OPEN Device is still opened.
    *   JXFS_E_ REMOTE Communication error during remote call.
    */
    boolean isInterdependentDevice() throws JxfsException;

    /*
    * On receiving this call, the Device Service builds and returns a vector of strings which contains the names of all component devices that make up this interdependent device. The name of each device returned is the logical_name as described in the DeviceInformation object getDeviceName method.
    * Exceptions:
    *   JXFS_E_ILLEGAL Device is not part of an Interdependent device.
    */
    Vector getInterDependentDevices() throws JxfsException;
   
}
