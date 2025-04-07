/////////////////////////////////////////////////////////////////////
//
// IJxfsEventNotification
//
// Interface defining callback methods in the Device
// Control that are callable by a Device Service.
//
/////////////////////////////////////////////////////////////////////
package com.jxfs.events;

/*
 * The IJxfsEventNotification interface serves as a crucial link between the J/XFS Device Service layer and the Device Control layer, enabling asynchronous event communication. 
 * The Device Service uses this interface to deliver events to the Device Control, which then forwards them to the application. 
 * Asynchronous Communication: The IJxfsEventNotification interface facilitates asynchronous communication between the Device Service and Device Control, allowing the Device Service to continue processing without waiting for the application to handle events.
 * Event Handling in Device Control: The Device Control plays an active role in receiving events, queueing them, and delivering them to the application in a separate thread.
 * Exception Handling: The fireXXXEvent() methods can throw a JxfsException if an error occurs during event delivery. The specific error codes would be defined in the J/XFS specification.
 * Importance for Device Sharing: This event mechanism is especially important when devices are shared over a network, as it allows multiple applications to receive notifications about device events.
 * */
public interface IJxfsEventNotification
{
    public void fireIntermediateEvent(JxfsIntermediateEvent e) throws JxfsException;
    public void fireOperationCompleteEvent(JxfsOperationCompleteEvent e) throws JxfsException;
    public void fireStatusEvent(JxfsStatusEvent e) throws JxfsException;
}