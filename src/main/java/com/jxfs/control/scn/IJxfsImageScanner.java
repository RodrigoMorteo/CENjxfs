package com.jxfs.control.scn;
/*
* Contains method and property declarations required by all device controls which scan images.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

public interface IJxfsImageScanner 
{
	//TODO: Validate property modifies and initialization.
    public static final JxfsScnImageCapabilities imageCapabilities = new JxfsScnImageCapabilities();

    //public Property getProperty() {}

    /*
    * 5.6.3.1
    */
    JxfsId configureImageScan( JxfsScnImageScanParameters parameters) throws JxfsException;
}