package com.jxfs.general;
import java.io.Serializable;

public class JxfsDeviceInformation  implements Serializable
{
    private String localDeviceName; //The unique device name for this device in this J/XFS client. It is freely assignable during the installation. Note that this is a LOGICAL device name. Every device on a workstation must have a unique name.
    private String deviceName;  //This property only exists by its getDeviceName() method. It returns the localDeviceName, but in the case of a remote device this name is augmented by the workstation name the device is connected to. Although an implementation of J/XFS may want to use its own format for the unique identification of a device we strongly suggest to use the format “<devicename>@<hostname>”, i.e. printer2@workstation1.sample.domain.com to specify this. See chapter “Remote device access” at section 2.4. //TODO: This property was not shown in the diagram
    private String  description; //A String with the clear text description what this device is and where it can be found. May be used to present in a list to the user. Sample: “Passbookprinter 2nd floor (Mr. Millers office)”. //TODO: the diagram shows this property as int instead of string    
    private String deviceKey; //Unique identifier for the device in the repository, e.g. the deviceName without blanks. Like the localDeviceName this must be unique for all devices connected to a workstation.

    public JxfsDeviceInformation () {}

    public JxfsDeviceInformation (String localDeviceName, String deviceName, String description, String deviceKey)
    {
        //TODO: validate method signature and set properties accordingly. 
    }


    /*
    * This method can be used to gather the version information of a new firmware present in the repository for this device. It is null if no new firmware is present.
    */
    public JxfsVersion getFirmwareVersion() {
		return null;}

    /*
    * This call returns the actual byte codes of the firmware from the repository. It can be used by the Device Service to update the device if requested.
    */
    public byte[] getFirmware() { return null;} //TODO: Implement logic to return value

    public String getDescription() { return description;}
    public String getDeviceKey() { return deviceKey;}
    public String getDeviceName() { return deviceName;}
    public String getLocalDeviceName() { return localDeviceName; }
   
}