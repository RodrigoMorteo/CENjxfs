package com.jxfs.control.pin;

import java.util.Vector;
import com.jxfs.control.*;

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

/*
Base interface for PIN controls.
Contains methods declarations specific to PIN device controls.
*/
interface IJxfsPINKeypadControl extends IJxfsBaseControl {
	
	public static final Vector supportedFDKeys = new Vector();
	JxfsPINFKeySet supportedFKeys = new JxfsPINFKeySet(false, false, false); // object indicating supported Function Keys.
	public static final boolean inputRawSupported = false; 		// A boolean indicating if raw input mode is supported.
	public static final boolean inputCookedSupported = false; 	// A boolean indicating if cooked input mode is supported.
	public static final boolean beepOnPressSupported = false; 	// A boolean indicating if beeping on key press is supported.
	public static final boolean eventOnStartSupported = false; 	// A boolean indicating if an event is sent when the PIN entry starts.
	boolean getInputRawSupported() throws JxfsException;
	boolean getInputCookedSupported() throws JxfsException;
	boolean getBeepOnPressSupported() throws JxfsException;
	boolean getEventOnStartSupported() throws JxfsException;
	JxfsId readData(JxfsPINReadMode readMode) throws JxfsException;
	JxfsId readData(JxfsPINReadMode2 readMode) throws JxfsException;    
	/*identificationID readData (JxfsPINReadMode readMode) throws JxfsException;
	identificationID readData (JxfsPINReadMode2 readMode) throws JxfsException;*/
}