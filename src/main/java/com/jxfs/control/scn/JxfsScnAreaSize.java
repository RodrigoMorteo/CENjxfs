package com.jxfs.control.scn;
/*
* Keeps the size of a media to be scanned.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsType;

public class JxfsScnAreaSize extends JxfsType implements IJxfsScnConst
{
    private int width = JXFS_C_SCN_VALUE_NOT_INITIALIZED;
    private int height = JXFS_C_SCN_VALUE_NOT_INITIALIZED;

    public JxfsScnAreaSize() {
	}

   public JxfsScnAreaSize (int width, int height) throws JxfsException {}

}