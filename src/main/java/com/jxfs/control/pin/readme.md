## Handling of null parameters
3.1 If null is passed as a method parameter, a JxfsException exception with the error Code property set to JXFS_E_PARAMETER_INVALID will be thrown, unless the handling of a null parameter is explicitly specified for a particular method.

# 4 Classes and Interfaces
All operation methods return an identificationID. If an operation cannot be processed because of an error detected before the asynchronous processing of the method begins (i.e. before the calling thread returns) a JxfsException is thrown.
After processing has taken place, a JxfsOperationCompleteEvent is generated which contains detailed information about the status of the operation, i.e., if it failed or succeeded, and eventually additional data as a result.
The Constants, Error Codes, Exceptions, Status Codes and Support Classes that are used in the methods are described in special chapters at the end of the documentation.

## 4.1 Access to properties
Please note the following when determining the meaning of a property's Access:
 R The property is read only.
 W The property is write only.
 R/W The property may be read or written.
To access these properties the applications must use the appropriated methods specified by the JavaBean specification. Note that boolean properties are read using isProperty method instead of getProperty.

getProperty
    Syntax Property getProperty () throws JxfsException
    Description Returns the requested property.
    Parameter None
    Event No additional events are generated.
    Exceptions Some possible JxfsException value codes. Common values are:
        JXFS_E_CLOSED
        JXFS_E_UNREGISTERED
        JXFS_E_REMOTE

setProperty
    Syntax void setProperty (value) throws JxfsException
    Description Sets the requested property.
    Parameter The desired property value.
    Event No additional events are generated
    Exceptions Some possible JxfsException value codes. Common values are:
        JXFS_E_CLOSED
        JXFS_E_UNREGISTERED
        JXFS_E_REMOTE
        JXFS_E_PARAMETER_INVALID

isProperty ???

# Constants

| Name | Meaning | Value | Used By |
| ---- | ------- | ----- | ------- |
| JXFS_PIN_INITTEMP | Initialize the HSM temporarily (K_UR remains loaded) | | JxfsPINHsmInitData |
JXFS_PIN_INITDEFINITE | Initialize the HSM definitely (K_UR is deleted) | | JxfsPINHsmInitData |
JXFS_PIN_INITIRREVERSIBLE | Initialize the HSM irreversibly (can only be restored by the vendor) | | JxfsPINHsmInitData |

# Codes

## Error Codes

| Value | Meaning  | Numerical Value |
| ----- | -------- | --------------- |
| JXFS_E_PIN_PROTINVALID | The specified protocol is invalid | 5501 |
| JXFS_E_PIN_MACINVALID  | The MAC of the message is not correct | 5503 |
| JXFS_E_PIN_ACCESSDENIED| The encryption module is either not initialized or not ready for any vendor specific reason. | 5504 |
| JXFS_E_PIN_FORMATINVALID | The format of the message is invalid. | 5505 |
| JXFS_E_PIN_CONTENTINVALID | The contents of one of the security relevant fields are invalid. | 5506 |
| JXFS_E_PIN_MODENOTSUPPORTED | Initialization mode not supported. | 5507 |
| JXFS_E_PIN_INVALID_TAG | The value of the tag data is invalid. | 5509 |

## Status Events

| Value | Meaning  | Numerical Value |
| ----- | -------- | --------------- |
| JXFS_S_PIN_OPT_REQUIRED | This status event indicates that the online data/time stored in a HSM has been reached. As there are no more details available, the details property of this status event is null.This event may be triggered by the clock reaching a previously stored online time or by the online time being set to a time that lies in the past. The online time may be set by the setHsmTData method or by a secureMsgReceive method that contains a message from a host system containing a new online date/time. The event does not mean that any keys or other data in the HSM is out of date now. It just indicates that the terminal should communicate with a "Personalisierungsstelle" as soon as possible using the methods secureMsgSend / secureMsgReceive and the ISOPS protocol. | 5522 |
| JXFS_S_PIN_HSM_TDATA_CHANGED | This event indicates that one of the values of the terminal data has changed (these are the data that can be set using setHsmTData). I.e. this event will be sent especially when the online time or the HSM status is changed because of a hsmInit command or an OPT online dialog (secureMsgSend / secureMsgReceive with JXFS_PIN_PROTPS). The data is a JxfsPINTData object. | 5523 |

## Operation Codes

| Constant | Numerical Value |
| ----- | -------- |
| JXFS_O_PIN_SEND_MSG | 5524 |
| JXFS_O_PIN_RECEIVE_MSG | 5525 |
| JXFS_O_PIN_GET_JOURNAL | 5526 |
| JXFS_O_PIN_GET_TDATA | 5527 |
| JXFS_O_PIN_SET_TDATA | 5528 |
| JXFS_O_PIN_HSM_INIT | 5529 |

## ZKA Protocols
JXFS_PIN_PROTISOAS = 5511
JXFS_PIN_PROTISOLZ = 5512
JXFS_PIN_PROTISOPS = 5514
JXFS_PIN_PROTCHIPZKA = 5515
JXFS_PIN_PROTHSMLDI = 5516
JXFS_PIN_PROTBMP = 5517
JXFS_PIN_PROTRAWDATA = 5518


### Other
JxfsMSDControl c=myDeviceManager.getDevice(“CardReader”);

JxfsPINPadControl p=myDeviceManager.getDevice(“PINPad”);
JxfsMSDControl c=myDeviceManager.getDevice(“CardReader”);
c.open(this);
c.claim(JXFS_FOREVER);
JxfsPINPadControl p=myDeviceManager.getDevice(“PINPad”);
p.open(this);
p.claim(JXFS_FOREVER); // WORKS for separate but
// fails for complex devices!
...work with c and p...
c. release(); p.release();
c.close(); p.close(); ...

