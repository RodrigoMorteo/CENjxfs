package com.jxfs.control.pin;
/* 
* PIN function keys selector class. 
* Indicates for each function key if it is selected or not.
* Properties are read only.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsType;

public class JxfsPINFKeySet extends JxfsType {

    private boolean fk0;
    private boolean fk1;
    // ... declarations for other function key properties ...
    private boolean fk000;

    public JxfsPINFKeySet(boolean fk0, boolean fk1, boolean fk000) { //TODO: Validate parameters in the Key Set for function kets (F1 to F12???)
        this.fk0 = fk0;
        this.fk1 = fk1;
        // ... initialization of other function key properties ...
        this.fk000 = fk000;
    }

    // Getters for all properties (isProperty() functionality)
    public boolean isFk0() {
        return fk0;
    }

    public boolean isFk1() {
        return fk1;
    }

    // ... getters for other function key properties ...

    public boolean isFk000() {
        return fk000;
    }

    public boolean allFKeys() {
		return true;
        // ... logic to check if all properties are true ...
    }

    public boolean noFKeys() {
        // ... logic to check if all properties are false ...
    	return false;
    }
}