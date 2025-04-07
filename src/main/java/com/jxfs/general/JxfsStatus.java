package com.jxfs.general;

/*
* The JxfsStatus object delivers status information for J/XFS.
* Each Device Service has such an object. A copy of this is returned from the getStatus() method.
* The contents of this object reflects the Device Service status at the time when the object was returned.
* This table reflects current use of JxfsStatus object in all Device Class Interfaces:
*   PIN     getStatus returns a JxfsStatus object. No specific status objects.
*   MSD     getStatus returns a JxfsStatus object. Additional mediaStatus object.
*   TIO     getStatus returns a JxfsStatus subclassed object with a few properties.
*   CDR     getStatus returns a JxfsStatus subclassed object with lots of new properties.
*   PTR     getStatus returns a JxfsStatus object. Additional ptrStatus property contains a new subclassed JxfsStatus object with additional properties.
*   ALM     getStatus returns a JxfsStatus object. No specific status objects.
*   SIU     getStatus returns a JxfsStatus subclassed object with lots of new properties.
*   DEP     getStatus returns a JxfsStatus subclassed object with lots of new properties. Additional mediaStatus object.
*   CHK     getStatus returns a JxfsStatus object. Additional mediaStatus, inkStatus and lampStatus objects.
*   CAM     getStatus returns a JxfsStatus object. Additional getCameraStatus asynchronous method returns a JxfsStatus object for a specific focus Type.
*   VDM     getStatus returns a JxfsStatus object. Additional vdmStatus property containing new properties but not extending JxfsStatus class.
*   SCN     getStatus returns a JxfsStatus object. No specific status objects.
*   Source presents a visual representation of the relationship between JxfsStatus, its subclasses, and aggregates:
*   JxfsStatus
*       JxfsPrinterStatus
*           JxfsTonerStatus 
*           JxfsPaperStatus
*   JxfsType
*   JxfsTIOStatus
*   JxfsCDRStatus
*   JxfsMSD_CCDStatus
*/
public class JxfsStatus  extends JxfsType implements Cloneable //TODO: Check inheritance
{

    private boolean open; //Initalized by a Device Service
    private boolean claimPending;  //Initalized by a Device Service
    private boolean claimed;  //Initalized by a Device Service
    private boolean busy;  //Initalized by a Device Service
    private boolean hardwareError;  //Initalized by a Device Service
    private boolean userActionError;  //Initalized by a Device Service
    private boolean powerSave;  //Initalized by a Device Service
    private boolean manipulated;  //Initalized by a Device Service

    /*
    * Constructs a new status. Any property is false.
    */
    protected JxfsStatus() {} //TODO: Validate protected modifier

    /*
    * Set the corresponding property, i.e. void setBusy(boolean setTo).
    */
    void setProperty() {} 

    /*
    * Returns true if the device is opened, false if not.
    */
    boolean isOpen() {
		return open;} 

    /*
    * The device has received a claim request which is not yet granted.
    */
    boolean isClaimPending() {
		return claimPending;} 

    /*
    * Returns true if the device is claimed, false if not.
    */
    boolean isClaimed() {
		return claimed;} 

    /*
    * Is set if an operation is running.
    */
    boolean isBusy() {
		return busy;} 

    /*
    * A hardware error is a device error which can only be fixed by service personnel.
    */
    boolean isHardwareError() {
		return hardwareError;} 

    /*
    * If an error condition can be fixed by user action (e.g. supplying more paper) this is true. Even if this is false an error may be present, namely the above hardware error.
    */
    boolean isUserActionError() {
		return userActionError;} 

    /*
    * If neither a hardware nor user action error is present and the device is opened it is assumed to be working, i.e. this method returns true.
    */
    boolean isWorking() {
		if(!hardwareError && open)
			return true;
		else
			return false;
    }
    /*
    *  If the device is in power save mode this returns true.
    */
    boolean isPowerSave() {
		return powerSave;} 
    
    /*
    * If the device is manipulated.
    */
    boolean isManipulated() {
		return manipulated;}

}