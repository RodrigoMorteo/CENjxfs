package com.jxfs.general;
/*
* The JxfsLogger is a single separate object which exists in every Java VM. Every object of
* course has access to its local JxfsLogger only. It can report errors and write informational
* and trace messages to the log.
* The final logging of all messages is not done by the JxfsLogger itself. Rather a listener
* interface exists which can be implemented by other objects (under application control).
* The JxfsLogger sends out the messages to any object which has registered to be a listener.
* This is a very flexible mechanism using the Java event notification scheme, which makes it
* easy to distribute the available information.
* There is also no restriction on who is using the JxfsLogger. It is especially not restricted to
* transfer only J/XFS related messages. Basically, even the application might use the
* JxfsLogger to report what’s going on to an independent instance.
*/

import java.util.Vector;

import com.jxfs.events.IJxfsErrorLogListener;
import com.jxfs.events.IJxfsLogListener;

/*
* The ‘level’ integer specified in the trace log messages is not predefined.
* This standard, however, proposes to adhere to the following rules:
•   Ids from 1 to 9 should be used to describe the workflow as outlined below;
•   Ids 10 to 99 are for generic trace points
•   Ids starting with 100 are for additional custom trace points.
*     Value   Meaning
*     1       Report with this id that an operation request was made and interesting parameters to it.
*     2       Report with this id if an operation was completed, i.e. an OC Event is sent an its values.
*     3       A device property has changed.
*     4       The device status has changed (includes device ready, device closed and shutdown).
*     5 .. 9  Reserved, not used in this version
*     10      Method entry
*     11      Method exit
*     80-99   Reserved for J/XFS internal use
*     100     JXFS_LOG_USEROFFSET, start of first custom trace point.
*/

public class JxfsLogger 
{

  /*
  * The objects (or module groups of objects) which want to send messages to the JxfsLogger
  * must first initialize the JxfsLogger for their use. They have to send it a short textual
  * identifier and a longer description suitable for display. The short identifier must be used for
  * all subsequent write calls. This is used by the JxfsLogger and its listeners to identify which
  * class or module has generated the message and also enables them to use filters on a module
  * bases.
  * Then they can use the 2 different writing methods, one for reporting error conditions and
  * the other one to write trace log entries. The log entries are delivered with a level indicator
  * which can be analyzed by a LogListener.
  * Every message given to the JxfsLogger is automatically augmented with a timestamp (a
  * Date object) and a description of the issuing thread where the line was generated, so it is
  * not needed to include such information by the issuing object. 
  */

  /*
  * Returns the reference to the JxfsLogger-Object. Must be used to access this singleton. 
  */
  static JxfsLogger getReference() {
	return null;}

  /*
  * Must be used by each object before the first line is reported to identify itself in both a short and a long form. The short form should uniquely identify this object (i.e. “DevMgr”), and the description should be suitable for display in a supervisor application, e.g. “Acme Passbook printer Device Service, Version 1.2”)
  * This method returns false if the given origin already exists as registered.
  */
  boolean registerModule(String origin, String description) {
	return false;}

  /*
  * If the object doesn’t use the Logger any more it should deregister using this call.
  * If should only do this if it has successfully registered before.
  * This method returns false if the origin wasn’t found in the registered list.
  */
  boolean deregisterModule(String origin){
	return false;}

  /*
  * Use this method to issue an error message. The issuer is the sending object itself. The origin is a short string with the module identification, it should have been announced to the logger by a previous registerModule() call.
  * The errorCode is the generic errorCode for this error, extendedErrorCode is a vendor specific, more detailed, code. The message is the error message itself in a language-specific form, the hintText gives some hints regarding a way to solve the error. Both message and hintText should not be long explanations but rather short strings (1-3 lines), and the help_url gives the originator of the message a way to announce where more detailed information regarding this error can be found.
  * When not applicable, extendedErrorCode may be specified as 0, and hintText and help_url may be left blank (“”). The other parameters are mandatory.
  * If some internal error occurred, false is returned.
  * Using an unregistered origin here is not recommended, but the message is logged anyway.
  */
  boolean writeErrorLog(Object issuer, String origin, long errorCode, long extendedErrorCode, String message, String hintText, String help_url) {
	return false;}

  /*
  * Use this method to issue a log message. The issuer is the sending object itself. 
  * The origin is a short string with the module identification, it should have been announced to the logger by a previous registerModule() call.
  * The level identifier is an integer. It is left to the programmer to define the exact semantics of this integer.
  * The message itself should be clearly readable, and may also be language specific using the mechanism as outlined in the writeErrorLog method description.
  * To use an unregistered origin here is not recommended, but the message is logged anyway. 
  */
  boolean writeLog(Object issuer, String origin, int level, String message){
	return false;}

  /*
  *If logging is used there are potentially very many log entries. It is advisable to prevent generation of many log messages which are only thrown away afterwards. Also, creating the message to be logged may be time-consuming.
  * For maximum system performance, before issuing a writeLog() call the issuer can check if that message should be logged at all. It does so by calling this method. If True is returned, the logging is desired. So, a typical usage is 
  *  if (JxfsLogger.getReference().isLogActive(“DM”,5)
  *  {
  *  JxfsLogger.getReference().writeLog(“DM”,5,0,”Cannot load class”+classToInstantiate,””,””);
  *  }
  * The logActive state may dynamically change during runtime. A user of the logger should not issue this only once during startup but before every call.
  *How is this logging activated and deactivated? This is considered to be a detail of a J/XFS implementation and is thus not described here.
  */
  boolean isLogActive(String origin, int level) {
	return false;}

  /*
  * Any object implementing the required interfaces can register with these methods to receive either only the error messages or both error and log messages. Any registered LogListener will also receive all error messages.
  * A registration of the same object to both methods returns an error.
  * If the listener could not be added, a null value is returned.
  */
  JxfsId addErrorLogListener(IJxfsErrorLogListener listener) {
	return null;}
  JxfsId addLogListener(IJxfsLogListener listener) {
	return null;}

  /*
  * Use these methods to deregister interest in the messages. The parameter can be queried from the JxfsId object corresponding to this Listener (returned from getErrorLogListeners())
  */
  boolean removeErrorLogListener(int listenerId){
	return false;}
  boolean removeLogListener(int listenerId){
	return false;}

  /*
  * Return a Vector containing objects of type JxfsId for all registered ErrorLogListeners. 
  */
  Vector getErrorLogListeners() {
	return null;}

  /*
  * Return a Vector containing objects of type JxfsId for all registered LogListeners.
  */
  Vector getLogListeners() {
	return null;}

  /*
  * Return the reference to the ErrorLogListener identified by the listenerId.
  */
  IJxfsErrorLogListener getErrorLogListener(int listenerId) {
	return null;}

  /*
  * Return the reference to the LogListener identified by the listenerId.
  */
  IJxfsErrorLogListener getLogListener(int listenerId) {
	return null;}


  /*
  * This method should only be used by the DeviceManager. It prepares for system shutdown: The JxfsLogger now tells all connected listeners to shutdown. After this call has completed the JxfsLogger is in its original startup state again.
  */
  void shutdown() {}

}