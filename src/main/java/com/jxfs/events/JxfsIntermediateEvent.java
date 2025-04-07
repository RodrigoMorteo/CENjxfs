package com.jxfs.events;
/* 
* An Intermediate Event is sent if intermediate results of an operation have to be sent to the application. This can either be to inform the application of some conditions specific to the operation (e.g. if a cash dispense command has to be delayed for a couple of minutes) or to deliver intermediate data (e.g. the keystrokes pressed by the user). 
It is sent only to the Device Control which started the operation. 
*/

import java.io.Serializable;

public class JxfsIntermediateEvent extends JxfsEvent {
    private Object source;
    private int operationID;
    private int identificationID;
    private int reason;
    private Serializable object;
    /* 
    * Constructor for this Event. the ‘data’ variable is set to null.
    */
    JxfsIntermediateEvent (Object source, int operationID, int identificationID, int reason) {
    	super(source);
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.reason = reason;
    }
    /*
    * Constructor for this Event with complete parameters  
    */
    JxfsIntermediateEvent (Object source, int operationID, int identificationID, int reason, Serializable object) {
    	super(source);
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.reason = reason;
    	this.object = object;
    }

    /*
    * The id number for the operation type.
    * One of the constant definitions showing which type of operation the event is related to.
    */
    int getOperationID() 
    {
        return operationID;
    }

    /*
    * The id which was given by the operation method to the application, -1 if not used.
    */    
    int getIdentificationID()
    {
        if(identificationID < 0) //TODO: Check how to validate that identificationID was not used
            return -1;
        else 
            return identificationID;
    }
    /* 
    * Specifies what the reason for this event was (e.g. JXFS_I_CDR_DISPENSE_DELAYED).
    */
    int getReason() 
    {
        return reason;
    }
    
    /*
    * Contains the optionally added data for the application or null. If it is not a Java base data type then the object stored here should should be a subclass of JxfsType. 
    */
    Serializable getData() 
    {
		return object;

    }
} 