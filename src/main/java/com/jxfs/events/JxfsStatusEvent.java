/*
* A Status Event is sent if the status of the device has changed. The reason for this may either be a change due to an operation (such as “paper low”), or it may occur due to user interaction (such as “device made offline”).
* This type of event is sent to ALL the connected Device Controls.
* The Device Service creates Event event instances of this class and delivers them through the J/XFS PIN Device Control's event callbacks to the application
*/
package com.jxfs.events;

 import com.jxfs.general.JxfsType;

public class JxfsStatusEvent extends JxfsEvent
{
	private int status;
	private JxfsType details;
	private int result;
	private int extendedResult;
    /*
    * Constructor for this Event. 
    */
    JxfsStatusEvent (Object source, int status) {
    	super(source);
    	this.status = status;
    }

    /*
    * Constructor for this Event – all parameters except result and extendedResult
    */
    JxfsStatusEvent (Object source, int status, JxfsType details) {
    	super(source);
    	this.status = status;
    	this.details = details;
    }

    /*
    * Constructor for this Event – complete parameters 
    */
    JxfsStatusEvent (Object source, int status, JxfsType details, int result, int extendedResult) {
    	super(source);
    	this.status = status;
    	this.details = details;
    	this.result = result;
    	this.extendedResult = extendedResult;
    }

    /*
    * The status the affected device has changed to. See the list below for details on when these events are sent. Each specific Device type also adds some more status codes.
    */
    int getStatus() {
    	return status;
    }

    /*
    * This is filled if the given status does not give the exact and complete status change information.
    * Return:
    *   JxfsType or one of its subclasses Indicates the detailed status conditions of the device.
    * An example here would be (for the printer) that a status of JXFS_S_PTR_TONER would be sent indicating something with the toner changed. The application could then query this details object for the exact condition (is it empty or low or ...).
    * If a generic status change is reported (see section on JxfsStatus) then this field is empty (==null).  //TODO: Implement validation for when it's null
    */
    Object getDetails() {
    	return details;
    }

    /*
    *  Specifies additional information on the reason that originated the event.
    * Notice that a status event may be issued even if the status itself did not change, but the result field did.
    * Returns -1 if not used. //TODO: Implement validation for when it's not used
    */
    int getResult() {
    	return result;
    }

    /*
    * Specifies extended device specific information. Its usage by the application must only occur if the specific device service is determined. Also, by using it application will now be vendor dependent.
    * Notice that a status event may be issued even if the status itself did not change, but the extended result did.
    * Returns -1 if not used.  //TODO: Implement validation for when it's not used
    */
    int getExtendedResult() {
    	return extendedResult;
    }

}