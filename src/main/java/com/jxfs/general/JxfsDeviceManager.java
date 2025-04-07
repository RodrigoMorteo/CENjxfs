package com.jxfs.general;
import java.io.Serializable;
import java.util.Vector;

import com.jxfs.control.IJxfsBaseControl;
import com.jxfs.events.IJxfsKeyValueChangeListener;
import com.jxfs.events.IJxfsStatusListener;
import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsVersion;

public class JxfsDeviceManager { //a singleton object where device requests are routed to. There is exactly one DM in each Java VM.
    
    /* 
    * This call returns a reference to the DM in a Java VM. There is exactly one DM in each Java VM.
    */
    static JxfsDeviceManager getReference() {
		return null;} 

    /*
    * JxfsDeviceManager.getReference().initialize("RMI,client1,srv(2006),backupsrv(2007)");
    */
    void initialize(String configurationParameters) throws JxfsException {}

    /*
    * Returns a Vector of JxfsDeviceInformation objects which represent the information about devices available to this J/XFS client. Level specifies in more detail which devices are reported and can be one of the following constants (Also defined in the DeviceManager
    * JXFS_LEVEL_ACTIVE Active devices in the same process as the application (application local). A device is active if its Device Service is successfully started.
    * JXFS_LEVEL_CONFIGURED Configured devices in the same process as the application (not necessarily active).
    * JXFS_LEVEL_WORKSTATION The same as JXFS_LEVEL_ACTIVE plus all active devices in other processes on this workstation
    * JXFS_LEVEL_ALL JXFS_LEVEL_WORKSTATION and active devices on any other workstation as well.
    */
    Vector getDeviceList(int level) {
		return null;}

    /*
    * Returns a list of JxfsDeviceInformation objects which represent the available devices of the given type (identified by the given control classname, e.g. JxfsTIOControl). The level is the same as in the above call.
    */
    Vector getDeviceListFor(Class control_classname, int level) {
		return null;}

    /*
    * With this method the application requests a device. The logical_name given here can be queried from a JxfsDeviceInformation object with the method getDeviceName().
    * The returned Device Control object has a connection to its Device Service, but the device is not opened yet. If the application stops using the device it must be closed (if it has opened it) and then deregistered with deregisterDevice().
    * Exceptions 
    * JXFS_E_NOSERVICE devicename/service class unknown or not found 
    * JXFS_E_NOEXIST logical_name unknown
    * JXFS_E_FAILURE service class failed to initialize.
    */
    IJxfsBaseControl getDevice(String logical_name) throws JxfsException {
		return null;}

    /*
    * Here, the application requests a device of type control_classname without specifying a concrete name. The DM should return a Device Control for the default device of this type for this J/XFS client or - if no default is configured - to the first such device found. If the application stops using the device it must be released and then deregistered with deregisterDevice().
    * Execptions
    * JXFS_E_NOSERVICE devicename/service class unknown or not found
    * JXFS_E_NOEXIST logical_name unknown
    * JXFS_E_FAILURE service class failed to initialize.
    */
    IJxfsBaseControl getDevice(Class control_classname) throws JxfsException {
		return null;}
    
    /*
    * This method allows an arbitrary object to be retrieved under the given key from the repository. It must be either a basic Java data type (String, int, etc.) or a subclass of JxfsType.
    * If the key is not found in the repository an exception with JXFS_E_NOEXIST is thrown.
    * Any String value may be used as a key name.
    */
    Serializable getValueForKey(String key) throws JxfsException {
		return key;}

    /*
    * Saves the given object persistently in the repository using the given key. If the key does not exist, it is created, if it exists, the value is replaced.
    * To remove a key from the repository, use this method and specify null as the value parameter.
    * An exception JXFS_E_ILLEGAL is thrown if the key specified is not allowed.
    * This can e.g. happen if a read-only key with the same name exists which cannot be overwritten. Any String value may be used as a key name. 
    */
    void setValueForKey(String key, Serializable value) throws JxfsException {}

    /*
    * If the application or a Device Control or Device Service want to be informed about changes that happen to the value of a certain key, they must use this method to indicate where the change information should be delivered and what key it is interested in.
    * They have to implement the IJxfsKeyValueChangeListener interface. This contains only the method:
    * void keyValueChangeOccurred(String key, Serializable value); 
    * It is called by the Device Manager after registering. Also, the second parameter provides the new value for the key.
    */
    void addKeyValueChangeListener(IJxfsKeyValueChangeListener l, String key) throws JxfsException {}

    /*
    * Remove the given KeyValueChangeListener object from the listening list.
    */
    void removeKeyValueChangeListener(IJxfsKeyValueChangeListener l) throws JxfsException {}

    /*
    * Description Return the version object for this Device Manager
    */
    JxfsVersion getDeviceManagerVersion() {
    	return null; // Return the version object
    }

    /*
    * With these methods the application can register as a listener to receive the JxfsStatusEvents from the DeviceManager (Returning true if the listener was successfully added or removed). Currently, JxfsStatusEvents with the following Ids are defined:
        JXFS_S_SHUTDOWN
        JXFS_S_REMOTEFAILURE
        JXFS_S_SERVICE_STOPPED
        JXFS_S_SERVICE_STARTED
    */
    boolean addStatusListener(IJxfsStatusListener l) {
		return false;}
    boolean removeStatusListener(IJxfsStatusListener l) {
		return false;}
    
    /*
    * Start the Device Service identified by the given name. The logical_name given here can be queried from a DeviceInformation object with the method getDeviceName().
    * If the device is already started this method immediately returns.
    * A start is called by the DeviceManager during initialization phase and is also implicitly done during a getDevice call on the local machine. So, this method is reserved for administration purposes.
    * This method only works for devices attached locally to this DM (i.e. where the DS is running in the same JavaVM as the DM). Exceptions:
    * JXFS_E_NOSERVICE
    * JXFS_E_NOEXIST
    * JXFS_E_FAILURE
    */
    void start(String logical_name) throws JxfsException {}

    /*
    * Stop the device with the given name. The logical_name given here can be queried from a DeviceInformation object with the method getDeviceName().
    * The Device Manager does the following: First, the DeviceManager removes any entries for this device from the central J/XFS server. Then it calls the shutdown method of all the local Device Service objects. The Device Services in turn shut down the physical device, write any remaining persistent data into the repository and send a JxfsStatusEvent (JXFS_S_SHUTDOWN) to any remaining connected Device Controls, which have to notice the status change and deactivate any device access (See the Device Service method description for details).
    * This method fails if the given name is unknown by throwing a JxfsException with code JXFS_E_NOEXIST or if the DS was not started.
    * This method is reserved for administration purposes; the DM uses this method to shut down any DS during a shutdown.
    */
    void stop(String logical_name) throws JxfsException {}

    /*
    * Prepare the shutdown of the J/XFS infrastructure. The Device Manager calls the above stop() method for all local devices. Finally it deactivates the logger by calling its shutdown() method, disables itself and returns control to the application.
    */
    void shutdown() {
	}

    /*
    * This method generates a unique tag on each call across all workstations managed by the Device Manager. The format and mechanism for generating this tag will be dependent on each implementation of the Device Manager and no assumptions on format should be made by application developers. However,one possible format that may be used by Device Manager implementers to generate the unique tag is the following <workstation_id>_<timestamp>_<counter> workstation_id: a string that uniquely identifies the workstation which contains the requesting application timestamp: a string representation of the time at which this request was received by the Device Manager counter: a counter which is incremented on each call to generateUniqueTag received by the Device Manager. This counter may be initialized to 1 on first call after the Device Manager is started.
    * This helper method is useful when used in conjunction with the form of the claim method which accepts a tag parameter, when accessing interdependent devices. For more information, see the claim method description of the IJxfsBaseControl interface.
    */
    String generateUniqueTag() throws JxfsException {
		return null;}

}

