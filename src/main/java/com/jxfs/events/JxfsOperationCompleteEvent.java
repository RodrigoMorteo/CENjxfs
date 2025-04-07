/**
* A JxfsOperationCompleteEvent is always sent when a previously started operation terminates. It is sent only to the Device Control which started the operation.
* It can either just inform if a successful completion of an output command (e.g. “printed”), returns the data of a requested input operation or gives information if the operation failed, perhaps returning a partial dataset.
* The exact parameters of the event are defined in the Device Control definition of every device type.
* The JxfsOperationCompleteEvent is a cornerstone of the J/XFS asynchronous operation model, providing a mechanism for applications to receive notifications about the completion of operations on devices.
*/
package com.jxfs.events;

import java.io.Serializable;
/**
 
 */
public class JxfsOperationCompleteEvent extends JxfsEvent
{
    private int operationID;	//identifies the type of the operation
    private int identificationID; //identifies the operation. 
    private int result; //The result code contains the result of the operation
    private int extendedResult;
    private Serializable data; //the optional data object can deliver additional data.
    
    /*
    * Constructor for this Event. Variables data and extendedResult left empty.
    */
    JxfsOperationCompleteEvent (Object source, int operationID, int identificationID, int result) {
    	super(source);
    	this.source = source;
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.result = result;
    }

    /* 
    * Constructor for this Event. Only data is not given here.
    */
    JxfsOperationCompleteEvent (Object source, int operationID, int identificationID, int result, int extendedResult) {
    	super(source);
    	this.source = source;
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.result = result;
    	this.extendedResult = extendedResult;
    }

    /*
    * Constructor for this Event. Without the extendedResult.
    */
    JxfsOperationCompleteEvent (Object source, int operationID, int identificationID, int result, Serializable data) {
    	super(source);
    	this.source = source;
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.result = result;
    	this.data = data;
    }

    /*
    * Constructor for this Event. Fills all parameters. 
    */
    JxfsOperationCompleteEvent (Object source, int operationID, int identificationID, int result, int extendedResult, Serializable data) {
    	super(source);
    	this.source = source;
    	this.operationID = operationID;
    	this.identificationID = identificationID;
    	this.result = result;
    	this.extendedResult = extendedResult;
    	this.data = data;
    }

    /*
    * The operationID which states what kind of operation is complete.
    */
    int getOperationID() {
		return operationID;
	}

    /*
    * The id which was given by the operation method to the application, -1 if not used.
    */
    int getIdentificationID() {
		return identificationID;
	}  

    /*
    * Specifies the operation result. It is JXFS_RC_SUCCESSFUL if everything was fine.
    */
    int getResult() {
    	return result;
    }

    /*
    * This is a device specific value! Its usage by the application must only occur if the specific device service is determined.
    * Also, by using it application will now be vendor dependent. Returns –1 if not used. 
    */
    int getExtendedResult() {
    	return extendedResult;
    }

    /*
    * Contains optionally added data for the application.
    * If it is not a Java base data type then the object stored here should be a subclass of JxfsType.
    */
    Serializable getData() {
    	return data;
    } 
}