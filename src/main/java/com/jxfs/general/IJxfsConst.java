package com.jxfs.general;

/*
*Special codes for specific devices (IJxfsXYZConst.java). Each Device Control can optionally have such an additional constants file.
*/

/**Constant definitions concerning all devices.*/
public interface IJxfsConst {
//###################################################################
//#### General constants
//###################################################################
/** General constant:
* Any error start at number...
*/
public static final int JXFSERR = 1000;
/** General constant:
* Any extended Error starts at number ...
*/
public static final int JXFSERREXT = 2000;
/** General constant:
* basic operation id code OPEN
*/
public static final int JXFS_O_OPEN = 900;
/** General constant:
* basic operation id code CLOSE
*/
public static final int JXFS_O_CLOSE = 901;

//iJxfsBaseControl Firmware Status

/** General constant:
* basic operation id code JXFS_O_UPDATEFIRMWARE
*/
public static final int JXFS_O_UPDATEFIRMWARE = 902;
/** General constant:
* Firmware in repository is newer than current firmware.
*/
public static final int OK_NEWER = 903;
/** General constant:
* Current firmware is newer but update possible.
*/
public static final int OK_OLDER = 904;
/** General constant:
* Different firmware functionality but update possible.
*/
public static final int OK_OTHER = 905;

/** General constant:
* No firmware found in the repository. Update not possible, no firmware found in repository.
*/
public static final int NO_SOURCE = 906;
/** General constant:
* Firmware in the repository is not correct for this device. Update not possible.
*/
public static final int NO_MATCH = 907;
/** General constant:
* Firmware update is not possible with this device.
*/
public static final int NO_SUPPORT = 908;

/**
* Specifies active (successfully started) local devices. Active devices in the same process as the application (application local). A device is active if its Device Service is successfully started.
*/
public static final int JXFS_LEVEL_ACTIVE = 909;
/**
* Specifies local devices. Configured devices in the same process as the application (not necessarily active).
*/
public static final int JXFS_LEVEL_CONFIGURED = 910;
/**
* Specifies active (successfully started) devices on this workstation.The same as JXFS_LEVEL_ACTIVE plus all active devices in other processes on this workstation.
*/
public static final int JXFS_LEVEL_WORKSTATION = 911;
/**
* Specifies active (successfully started) devices. JXFS_LEVEL_WORKSTATION and active devices on any other workstation as well.
*/
public static final int JXFS_LEVEL_ALL = 912;
/** General constant:
* Firmware in the repository is equal to the firmware in the device.
* Update possible.
*/
public static final int OK_EQUAL = 913;

//###################################################################
//#### Offset constant
//###################################################################
/** Offset constant:
* Any code defined by a specific device operation should start from
* this offset in order not to mix up with J/XFS definitions.
*/

public static final int JXFSDEVICE_OFFSET = 3000;
/** Offset constant of known device types:
* PTR
*/
public static final int JXFS_PTR_OFFSET = JXFSDEVICE_OFFSET + 0000;
/** Offset constant of known device types:
* MSD
*/
public static final int JXFS_MSD_OFFSET = JXFSDEVICE_OFFSET + 1000;
/** Offset constant of known device types:
* PIN
*/
public static final int JXFS_PIN_OFFSET = JXFSDEVICE_OFFSET + 2000;
/** Offset constant of known device types:
* PINIso
*/
public static final int JXFS_ISO_OFFSET = JXFSDEVICE_OFFSET + 2500;
/** Offset constant of known device types:
* CDR
*/
public static final int JXFS_CDR_OFFSET = JXFSDEVICE_OFFSET + 3000;
/** Offset constant of known device types:
* ALM
*/
public static final int JXFS_ALM_OFFSET = JXFSDEVICE_OFFSET + 4000;
/** Offset constant of known device types:
* TIO
*/
public static final int JXFS_TIO_OFFSET = JXFSDEVICE_OFFSET + 5000;
/** Offset constant of known device types:
* CHK
*/
public static final int JXFS_CHK_OFFSET = JXFSDEVICE_OFFSET + 6000;
/** Offset constant of known device types:
* SIU
*/
public static final int JXFS_SIU_OFFSET = JXFSDEVICE_OFFSET + 7000;
/** Offset constant of known device types:
* DEP
*/
public static final int JXFS_DEP_OFFSET = JXFSDEVICE_OFFSET + 8000;
/** Offset constant of known device types:
* CAM
*/
public static final int JXFS_CAM_OFFSET = JXFSDEVICE_OFFSET + 9000;
/** Offset constant of known device types:
* VDM
*/
public static final int JXFS_VDM_OFFSET = JXFSDEVICE_OFFSET + 10000;
/** Offset constant:
* Any rc or code defined by a specific device for a direct-IO
* operation should start from this offset in order not to mix
* up with J/XFS definitions.
*/
public static final int JXFSDIRECTIO_OFFSET = 30000;
/**
* Offset constant for trace points / trace levels of device services or
* applications.
*/
public static final int JXFS_LOG_USEROFFSET = 100;

/////////////////////////////////////////////////////////////////////
// Return Codes from calls which deliver an immediate result
/////////////////////////////////////////////////////////////////////
/** Return code from calls which deliver an immediate result:
* Standard return for successful calls
*/
public static final int JXFS_RC_SUCCESSFUL = 0;

/** Return codes from calls which deliver an immediate result:
* Unspecified unsuccessful return
*/
public static final int JXFS_RC_UNSUCCESSFUL = 1;
/////////////////////////////////////////////////////////////////////
// Exception code
/*
* The standard exception within J/XFS is the JxfsException. It is thrown wherever an exception is needed and contains the following parameters (all except errorCode may be empty:
* Parameter             Type            Meaning
* errorCode             int             The error code. One of the defined JXFS_E_...codes.
* errorCodeExtended     int             An extended error code. This can be a system or vendor dependent error code. 
* description           String          Textual description of the error.
* origException         Exception       The original exception which was caught and replaced by this JxfsException. A standard sample would be that a RemoteException is caught and a new JxfsException with error code JXFS_E_REMOTE is created. Then the original exception is put into it – if the application wants to analyze the exception further it can get it from here.
*/
/////////////////////////////////////////////////////////////////////
/** Exception code:
* Device Control is not registered at the service. Device is not registered at the Device Manager. It must either have been instantiated using new(), which is not allowed, or has already been deregistered at the Device Manager which disables this control completely.
*/
public static final int JXFS_E_UNREGISTERED = 1 + JXFSERR;
/** Exception code:
* Device still closed, function not yet available. Device has not been opened yet. The application should not rely on JXFS_E_CLOSED being thrown at once if the device is closed
*/
public static final int JXFS_E_CLOSED = 2 + JXFSERR;
/** Exception code:
* Device still already or still opened. //Device is already opened. The application should not rely on JXFS_E_OPEN being thrown at once if the device is open as it depends on the internal scheduling mechanism of the Device Service if the Device Service will accept an open call when the device is open, but a close is already pending. Therefore the application should also be prepared to accept the JXFS_E_OPEN code as an OC event code and not only as an exception.
*/
public static final int JXFS_E_OPEN = 3 + JXFSERR;
/** Exception code:
* Device is already or still claimed by this Device Control. The calling method is not available at this time because the device is currently claimed for exclusive access by another control.
*/
public static final int JXFS_E_CLAIMED = 4 + JXFSERR;
/** Exception code:
* Device is not claimed
*/
public static final int JXFS_E_NOTCLAIMED = 5 + JXFSERR;
/** Exception code:
* Requested Service not available, i.e. devicename/service class unknown or not found
*/
public static final int JXFS_E_NOSERVICE = 6 + JXFSERR;
/** Exception code:
* Requested communications object not available, i.e
* the device is not remotely accessible
*/
public static final int JXFS_E_NOTREMOTE = 7 + JXFSERR;
/** Exception code:
* Requested Control not available
*/
public static final int JXFS_E_NOCONTROL = 8 + JXFSERR;
/** Exception code:
* Device is disabled
*/
public static final int JXFS_E_DISABLED = 9 + JXFSERR;
/** Exception code:
* Illegal request. Not allowed at this time or never allowed.
* This value is usually the result of a problem in the application code.
* e.g. the DM is already initialized, of the call was already done.
*/
public static final int JXFS_E_ILLEGAL = 10 + JXFSERR;
/** Exception code:
* The device hardware could not be found or is not connected. The Device is not connected to the workstation.
*/
public static final int JXFS_E_NOHARDWARE = 11 + JXFSERR;
/** Exception code:
* The device is switched offline
*/
public static final int JXFS_E_OFFLINE = 12 + JXFSERR;
/** Exception code:
* The requested item (device or key) does not exit. i.e. error in the parameter: The server was found but the identification (configKey) given is unknown or logical_name unknown
*/
public static final int JXFS_E_NOEXIST = 13 + JXFSERR;
/** Exception code:
* Object already exists
*/
public static final int JXFS_E_EXISTS = 14 + JXFSERR;
/** Exception code:
* The operation failed or device service is not initialized. i.e. service class failed to initialize.
*/
public static final int JXFS_E_FAILURE = 15 + JXFSERR;
/** Exception code:
* A timeout occurred before completion
*/
public static final int JXFS_E_TIMEOUT = 16 + JXFSERR;
/** Exception code:
* Operation not possible, device is already busy
*/
public static final int JXFS_E_BUSY = 17 + JXFSERR;
/** Exception code:
* One of the parameters given was invalid. Further information
* may be found in extendedErrorCode, i.e. error in the parameter: There was a problem connecting to the specified server(s).
*/
public static final int JXFS_E_PARAMETER_INVALID = 18 + JXFSERR;
/** Exception code:
* Errors during a remote operation, i.e. communication error during remote call.
*/
public static final int JXFS_E_REMOTE = 19 + JXFSERR;
/** Exception code:
* Errors during an input or output operation
*/
public static final int JXFS_E_IO = 20 + JXFSERR;
/** Exception code:
* The operation was cancelled by the application via cancel()
*/
public static final int JXFS_E_CANCELLED = 21 + JXFSERR;
/** Exception code:
* The operation is not supported by this object
*/
public static final int JXFS_E_NOT_SUPPORTED = 22 + JXFSERR;
/** Exception code:
* Error during firmware update or no runnable firmware in device
*/
public static final int JXFS_E_FIRMWARE = 23 + JXFSERR;
/** Exception code:
* Unpredictable system error/exeception occurred that is not
* device related.
*/
public static final int JXFS_E_SYSTEM = 24 + JXFSERR;
/** Exception code:
* Error occurred that is device related.
*/
public static final int JXFS_E_HARDWAREERROR = 25 + JXFSERR;
/////////////////////////////////////////////////////////////////////
/* Status constants
*  All the connected Device Controls (and thus the application or applet) are informed of certain changes of the device status. 
*  They receive a JxfsStatusEvent with the corresponding status and with a null details object in the following cases:
*   Status                  Meaning
    JXFS_S_CLAIMED          Sent if the device was claimed.
    JXFS_S_RELEASED         Sent if the device was just released by a Device Control which had claimed the device.
    JXFS_S_HARDWAREERROR    Sent if a hardware error was detected by the Device Service.
    JXFS_S_USERACTIONERROR  Sent if an error was detected which is resolvable by user intervention. If a more specific JxfsStatusEvent is generated regarding the error (e.g. a TONER_OUT) then NO additional event with this id is sent.
    JXFS_S_WORKING          Sent if an error has been fixed to indicate that the device is working again.
    JXFS_S_SHUTDOWN         The device service has completed its shutdown and is not usable any more.
    JXFS_S_REMOTEFAILURE    The communication between DS and DC is broken; device is not accessible any more.
    JXFS_S_POWERSAVEON      Device is gone into power save mode.
    JXFS_S_POWERSAVEOFF     Device has returned from power save mode.
    JXFS_S_MANIPULATION     The device service detected a manipulation.
    JXFS_S_NO_MANIPULATION  The manipulation state has ended and the device is normal again. Some manipulation sensors require vendor specific functionality to reset the manipulation state. Therefore not all devices that join the manipulation state can also leave that state automatically.
*/
/////////////////////////////////////////////////////////////////////
/** Status constant:
* control released
*/
public static final int JXFS_S_RELEASED = 1;

/** Status constant:
* control claimed. Sent if the device was claimed.
*/
public static final int JXFS_S_CLAIMED = 2;
/** Status constant:
* hardware error occured
*/
public static final int JXFS_S_HARDWAREERROR = 3;
/** Status constant:
* user action error occured
*/
public static final int JXFS_S_USERACTIONERROR = 4;
/** Status constant:
* action still working
*/
public static final int JXFS_S_WORKING = 5;
/** Status constant:
* shutdown
*/
public static final int JXFS_S_SHUTDOWN = 6;
/** Status constant:
* power save mode on
*/
public static final int JXFS_S_POWERSAVEON = 7;
/** Status constant:
* power save mode off
*/
public static final int JXFS_S_POWERSAVEOFF = 8;
/**
* A running device service was stopped. In the details parameter the logical name of the DS is given.
*/
public static final int JXFS_S_SERVICE_STOPPED = 9;
/**
* A stopped device service was started. In the details parameter the logical name of the DS is given.
*/
public static final int JXFS_S_SERVICE_STARTED = 10;
/**
* Communication is broken.
*/
public static final int JXFS_S_REMOTEFAILURE = 11;
/**
* Threshold status has changed.
*/
public static final int JXFS_S_BIN_STATUS = 12;
/**
* Media status has changed.
*/
public static final int JXFS_S_MEDIA_STATUS = 13;
/**
* Device detected a manipulation.
*/
public static final int JXFS_S_MANIPULATION = 14;
/**
* Manipulation state has ended.
*/
public static final int JXFS_S_NO_MANIPULATION = 15;
/////////////////////////////////////////////////////////////////////
// General Constants
/////////////////////////////////////////////////////////////////////
/** General constant:
*/
public static final int JXFS_FOREVER = -1;

/** General constant:
*/
public static final int JXFS_ALL = -1;
/**
* Specifies the first valid value for a controlId.
*/
public final static int JXFS_VALID_CONTROLID=2;


/*
* REVIEW THE FOLLOWING CONSTANTS mentioned in the BASE ARCHITECTURE document
*/

public static final int JXFS_E_CLOSE = JXFS_E_CLOSED; //TODO: Check syntax as this constant is used in the spec.
public static final int JXFS_E_NOT_OPEN = JXFS_E_CLOSED; //TODO: This constant is mentioned in the spec but is not defined.
public static final int JXFS_E_NO_EXIST = JXFS_E_NOEXIST;//TODO: CHECK SYNTAX as the constant in mentioned in the spec but not define. 
public static final int JXFS_E_NOT_OWNER = -1; //TODO: CHECK VALUE as the constant is mentioned in the spec but not initialized.


//TODO: CHECK NAMES AND VALUES. They are mentioned in the spec but not defined
/*
* public static final int JXFS_S_CLOSED 
* public static final int JXFS_S_IDLE
* public static final int JXFS_S_BUSY
* public static final int JXFS_S_ERROR

* public static final int JXFS_O_CLOSE
*/
public static final int JXFS_S_MEDIA_NOT_PRESENT = 0; //Media is not present in the device.
public static final int JXFS_S_MEDIA_EJECTED = 1; // Media is at the entry/exit slot of the device.
public static final int JXFS_S_MEDIA_JAMMED = 2; // Media in the device is jammed.
public static final int JXFS_S_MEDIA_PRESENT = 4; // Media is inserted in the device.
public static final int JXFS_S_MEDIA_UNKNOWN = 8; // State of the media cannot be determined.
public static final int JXFS_S_MEDIA_RETRACTED = 32; // Media is retracted into the retain bin.
public static final int JXFS_S_MEDIA_NOTSUPPORTED = 16; //Media is not supported by this device. (deprecated)

/*
* For the JxfsMediaStatus class
*/
public static final int JXFS_S_MTR_INSERT = 0;  // Media is inserted by the user
public static final int JXFS_S_MTR_TAKE = 1;    // Media is taken by the user
public static final int JXFS_S_MTR_EJECT = 2;   // Media is ejected, and presented to the user at the exit slot
public static final int JXFS_S_MTR_REINSERT = 3;    // Media is reinserted from the exit slot back to the unit
public static final int JXFS_S_MTR_RETRACT = 4; // Media is retracted to the retain bin
public static final int JXFS_S_MTR_NEXT = 5;    // This transition always takes place after a retract transition. 
public static final int JXFS_S_MTR_JAM = 6; // Media is jammed from any state
public static final int JXFS_S_MTR_UNKNOWN = 7; // Media status has gone into an unknown state, from any state
public static final int JXFS_S_MTR_INVALID = -1;    // The transition is invalid, and not contemplated in the state diagram. This value will be returned when an invalid value of the previousState parameter is given.

public static final int JXFS_S_BIN_FULL = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_HIGH = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_LOW = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_EMPTY = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_UNKNOWN = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_UNSUPPORTED = 0; //TODO: Check value as it is not defined in the spec.
public static final int JXFS_S_BIN_OK = 0; //TODO: Check value as it is not defined in the spec.

}