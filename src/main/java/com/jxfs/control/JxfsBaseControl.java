package com.jxfs.control;
/*
* Base class for all device controls.
*/

import com.jxfs.control.pin.JxfsPINFKeySet;
import java.util.Vector;

public class JxfsBaseControl {
	Vector supportedFDKeys;  
	JxfsPINFKeySet supportedFKeys;  //TODO: CHECK implementation
	boolean inputRawSupported;
	boolean inputCookedSupported;
	boolean beepOnPressSupported; 
	boolean eventOnStartSupported;
}