package com.jxfs.general;
public class JxfsMediaStatus extends JxfsType implements Cloneable, IJxfsConst {

    public int mediaState = JXFS_S_MEDIA_UNKNOWN; //Initalized by Device Service classes. Event: If the value of this property changes, the Device Service will send all registered IJxfsStatusListeners a JxfsStatusEvent with the following value and the corresponding mediaState object. This usually overrides the generation of a generic UserActionError event.  

    /*
    * Returns true if media is in the entry/exit slot of the device (the value of the mediaState property is JXFS_S_MEDIA_EJECTED).
    */
    public boolean isEjected() {return false;}

    /*
    * Returns true if media is jammed in the device (the value of the mediaState property is JXFS_S_MEDIA_JAMMED).
    */
    public boolean isJammed() {return false;}

    /*
    * Returns true if media is inserted in the device (the value of the mediaState property is JXFS_S_MEDIA_PRESENT).
    */
    public boolean isPresent() {return false;}

    /*
    * Returns true if the status of the media cannot be determined with the device in its current state (the value of the mediaState property is JXFS_S_MEDIA_UNKNOWN).
     */
    public boolean isUnknown() {return false;}


    /*
    * Returns true if media is in the retract bin (the value of the mediaState property is JXFS_S_MEDIA_RETRACTED).
    * Notice: this media state value is a special temporary condition. See the state diagram below and its related text for an explanation.
    */
    public boolean isRetracted() {return false;}

    /*
    * Returns true if no media is present in the device (the value of the mediaState property is JXFS_S_MEDIA_NOT_PRESENT).
    */
    public boolean isNoMedia() {return false;}

    /*
    * Calculates the transition that triggered the state change between the previous state and the current one. This is a helping method that can be used to determine what user action or application request originated the change to the current media status.
    * The returned value will be one of the following:
    *   JXFS_S_MTR_INSERT 
    *   JXFS_S_MTR_TAKE 
    *   JXFS_S_MTR_EJECT 
    *   JXFS_S_MTR_REINSERT 
    *   JXFS_S_MTR_RETRACT 
    *   JXFS_S_MTR_NEXT 
    *   JXFS_S_MTR_JAM 
    *   JXFS_S_MTR_UNKNOWN 
    *   JXFS_S_MTR_INVALID 
    */
    public int getTransition(JxfsMediaStatus previousState) {
		return mediaState;}

    
     /*
    * Returns a small textual representation of this object. This is an identifier, the int and a short code of the state (in capitals if true, in small caps otherwise). Sample: “MediaStatus(6-eJpu)@4AC2F, with the hex number being the hash code of the object.
    */
    @Override 
    public String toString() {
    	return ""; 
    }
    
}