package com.jxfs.control.pin;
/*
* This class defines the necessary data for setting an HSM out of order.
*/

import java.io.Serializable;

import com.jxfs.general.JxfsType;

class JxfsPINHsmInitData extends JxfsType implements Serializable {
    int initMode;           //Specifies the initialization mode as one of the following values: JXFS_PIN_INITTEMP, JXFS_PIN_INITDEFINITE, JXFS_PIN_INITIRREVERSIBLE
    byte[] onlineTime;      // Specifies the Online date and time in the format
                            // YYYYMMDDHHMMSS like in ISO BMP 61 as BCD packed
                            // characters. This parameter is ignored when the init mode equals
                            // JXFS_PIN_INITDEFINITE or JXFS_PIN_INITIRREVERSIBLE. If
                            // this parameter is null, the length of the array is zero or the value is
                            // 0x00 0x00 0x00 0x00 0x00 0x00 0x00 the online time will be set to a
                            // value in the past.

    JxfsPINHsmInitData (int initMode, byte[] onlineTime ){}


}