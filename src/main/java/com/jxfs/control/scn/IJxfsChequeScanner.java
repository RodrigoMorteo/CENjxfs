package com.jxfs.control.scn;

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

/*
* Contains method and property declarations required by all device controls which scan cheques. 
*/

public interface IJxfsChequeScanner
{
	//TODO: Validate property modifiers and initialization
    public static final JxfsScnChequeCapabilities chequeCapabilities = new JxfsScnChequeCapabilities();

    //public Property getProperty() {}

    /*
    * 5.7.3.1
    */
    JxfsId configureChequeScan( JxfsScnChequeScanParameters parameters) throws JxfsException;

    
}