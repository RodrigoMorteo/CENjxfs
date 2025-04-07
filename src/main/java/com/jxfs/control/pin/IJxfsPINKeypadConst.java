package com.jxfs.control.pin;

/**
 * Interface containing the Jxfs constants that are common to several device categories
 */
interface IJxfsPINKeypadConst { //TODO: validate class inheritance extends IJxfsConst
	//Error Codes
	public static final int JXFS_E_PIN_PROTINVALID =  5501;       //The specified protocol is invalid
	public static final int JXFS_E_PIN_MACINVALID = 5503;         //The MAC of the message is not correct
	public static final int JXFS_E_PIN_ACCESSDENIED = 5504;       //The encryption module is either not initialized or not ready for any vendor specific reason.
	public static final int JXFS_E_PIN_FORMATINVALID = 5505;      //The format of the message is invalid. 
	public static final int JXFS_E_PIN_CONTENTINVALID = 5506;     //The contents of one of the security relevant fields are invalid.
	public static final int JXFS_E_PIN_MODENOTSUPPORTED = 5507;   //Initialization mode not supported. 
	public static final int JXFS_E_PIN_INVALID_TAG = 5509;        //The value of the tag data is invalid.
	
	// Status Events
	public static final int JXFS_S_PIN_OPT_REQUIRED  = 5522; //This status event indicates that the online data/time stored in a HSM has been reached. As there are no more details available, the details property of this status event is null.This event may be triggered by the clock reaching a previously stored online time or by the online time being set to a time that lies in the past. The online time may be set by the setHsmTData method or by a secureMsgReceive method that contains a message from a host system containing a new online date/time. The event does not mean that any keys or other data in the HSM is out of date now. It just indicates that the terminal should communicate with a "Personalisierungsstelle" as soon as possible using the methods secureMsgSend / secureMsgReceive and the ISOPS protocol. 
	public static final int JXFS_S_PIN_HSM_TDATA_CHANGED = 5523; //This event indicates that one of the values of the terminal data has changed (these are the data that can be set using setHsmTData). I.e. this event will be sent especially when the online time or the HSM status is changed because of a hsmInit command or an OPT online dialog (secureMsgSend / secureMsgReceive with JXFS_PIN_PROTPS). The data is a JxfsPINTData object. 
	
	//Operation Codes
	public static final int JXFS_O_PIN_SEND_MSG = 5524;
	public static final int JXFS_O_PIN_RECEIVE_MSG = 5525;
	public static final int JXFS_O_PIN_GET_JOURNAL = 5526;
	public static final int JXFS_O_PIN_GET_TDATA = 5527;
	public static final int JXFS_O_PIN_SET_TDATA = 5528;
	public static final int JXFS_O_PIN_HSM_INIT = 5529;
	
	//ZKA Protocols
	public static final int JXFS_PIN_PROTISOAS = 5511;
	public static final int JXFS_PIN_PROTISOLZ = 5512;
	public static final int JXFS_PIN_PROTISOPS = 5514;
	public static final int JXFS_PIN_PROTCHIPZKA = 5515;
	public static final int JXFS_PIN_PROTHSMLDI = 5516;
	public static final int JXFS_PIN_PROTBMP = 5517;
	public static final int JXFS_PIN_PROTRAWDATA = 5518;
	
	//ZKA Initialization Modes
	public static final int JXFS_PIN_INITTEMP = 5519;
	public static final int JXFS_PIN_INITDEFINITE = 5520;
	public static final int JXFS_PIN_INITIRREVERSIBLE = 5521;
}