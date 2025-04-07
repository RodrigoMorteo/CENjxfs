package com.jxfs.general;

import java.io.Serializable;

/*
* This class can be used in cases where just a simple serializable data element is required, in order to avoid the proliferation of JxfsType subclasses.
*/
public class JxfsBasicType extends JxfsType implements Serializable {
    // Properties
    protected Serializable value; //Initialized by device Service Classes. Holds a serializable object. Its class will vary depending on the Device Service and the place where this object is used.

    // Constructor
    public JxfsBasicType(Serializable value) {
        this.value = value;
    }

    // Methods
    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }
}