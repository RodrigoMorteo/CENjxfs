package com.jxfs.general;
import java.io.Serializable;
import java.net.URL;

import com.jxfs.events.IJxfsKeyValueChangeListener;
import com.jxfs.events.JxfsException;

public class JxfsLocalDeviceInformation extends JxfsDeviceInformation implements Serializable, IJxfsConst {
    private URL textResource; // An URL (uniform resource locator, the Internet – way of specifying resource, e.g. “http://www.acme.com/support/printers”) which identifies a location where the DS can find a file. This allows the Device Service to gain access to a file in a device specific format which can contains any language dependant strings the DS wants to use as parameters, e.g. in error messages.
   
    public JxfsLocalDeviceInformation(){}
     /*
    * This method allows an arbitrary persistent object to be retrieved from the repository under the given key. If the key is not found in the repository an exception with JXFS_E_NOEXIST is thrown. 
    */
    public Serializable getValueForKey(String key) throws JxfsException {
		return new String();} //TODO: return the actual value

    /*
    * Saves the persistent object under the given name. If the key does not exist, it is created, if it exists, the value is replaced. The object must be a subclass of Serializable. To remove a key from the repository, use this method and specify null as the value parameter.
    * An exception JXFS_E_ILLEGAL is thrown if the key specified is not allowed.
    * This can e.g. happen if a read-only key with the same name exists which cannot be overwritten.
    */
    public void setValueForKey(String key, Serializable value) throws JxfsException {}

    /*
    * This method registers the listener to be informed when the value for the key "key" in the repository changes. Throws a JXFS_E_PARAMETER_INVALID exception if one of the parameters is null.
    */
    public void addKeyValueChangeListener(IJxfsKeyValueChangeListener listener, String key) throws JxfsException{}

    /*
    * Removes the given listener. Throws a JXFS_E_PARAMETER_INVALID exception if one of the parameters is null. If the listener is not known, a JXFS_E_FAILURE is thrown.
    */
    public void removeKeyValueChangeListener(IJxfsKeyValueChangeListener listener) throws JxfsException {}

     //TODO: public String textResource;
}

