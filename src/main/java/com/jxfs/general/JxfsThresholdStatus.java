/*
* This class defines a generic API to query and detect several threshold values. This can be 
* e.g. the paper supply present in a printer (to detect if it’s low or empty) or the retain bin of
* a card reader (to detect if its full or almost full).
* This object is received by the application either by calling getStatus() and querying the
* device specific status object or via certain JxfsStatusEvents. The state given by an object of
* this type reflects the state of the device at the time of its sending, i.e. the state may already
* have changed again. It is always only filled by the Device Service.
*/
package com.jxfs.general;

public class JxfsThresholdStatus extends JxfsType implements Cloneable 
{
    private int thresholdState; //Read and write, initialized by Device Service Class

    /*
    * Constructs a new object, threshold state is set accordingly.
    */
    public JxfsThresholdStatus(int state) {
    	this.thresholdState = state; 
    }

    /*
    * Sets the property. No sanity checking is done.
    */
    public void setThresholdState(int state) {
    	this.thresholdState = state;
    }

    /*
    * Returns the property. This method is deprecated as of CWA 14923:2004.
    */
    @Deprecated
    public int getThresholdState() {
        return thresholdState;
    }

    /* 
    * Returns true if the bin is full (the value of the thresholdState property is JXFS_S_BIN_FULL).
    */
    public boolean isFull() {
		return false;
	}

    /*
    * Returns true if the bin is high (the value of the thresholdState property is JXFS_S_BIN_HIGH). 
    */
    public boolean isHigh() {
		return false;
	}

    /*
    * Returns true if the bin is low (the value of the thresholdState property is JXFS_S_BIN_LOW).
    */
    public boolean isLow() {
		return false;
	}

    /*
    * Returns true if the bin is empty (the value of the thresholdState property is JXFS_S_BIN_EMPTY). 
    */
    public boolean isEmpty() {
		return false;
	}

    /*
    * Returns true if the status of the bin cannot be determined with the device in its current state (the value of the thresholdState property is JXFS_S_BIN_UNKNOWN).
    */
    public boolean isUnknown() {
		return false;
	}

    /*
    * Returns true if the device supports bin threshold status capabilities. (the value of the thresholdState property is not JXFS_S_BIN_UNSUPPORTED).
    */
    public boolean isSupported() {
		return false;
	}

    /*
    * Returns true only if the value of the property is exactly JXFS_S_BIN_OK. Therefore, this does not mean that if isOK() returns false, there is necessarily a problem. The bin can be just high or low, for example, but functioning perfectly.
    */
    public boolean isOK() {
		return false;
	}
    /*
    * Returns a short textual representation of the contents of this object.
    */
 // Override toString() for a human-readable representation
    @Override
    public String toString() {
		
        // ... Implementation to generate a string representation ...
    	return null;
    }
}