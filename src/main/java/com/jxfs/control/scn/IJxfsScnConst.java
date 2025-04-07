package com.jxfs.control.scn;

import com.jxfs.general.IJxfsConst;

/*
* Contains constants that are common to all Scanner controls.
*/
interface IJxfsScnConst extends IJxfsConst
{
    /*
    * Error Codes
    */
    public static final int JXFS_E_SCN_NOMEDIA = 15000; // There is no media to work on.
    public static final int JXFS_E_SCN_MEDIA_INVALID = 15001; // No appropriate media was found.
    public static final int JXFS_E_SCN_MEDIA_JAMMED = 15002; // Media is jammed.
    public static final int JXFS_E_SCN_MEDIA_TYPE_UNSUPPORTED = 15003; // The media that the device is trying to scan or process is not supported.
    public static final int JXFS_E_SCN_SCAN_FAILURE = 15004; // No scan conditions were satisfied.
    public static final int JXFS_E_SCN_SHUTTER_FAILED = 15005; // The shutter failed to open/close.
    public static final int JXFS_E_SCN_POSITION_ERROR = 15006; // An error has occured at an input/output IJxfsScnCommonControl = position. ; //.positionStatus’ s, for those positions in use, should be queried to determine whether a hardware error has occurred or whether the position has simply become full.
    public static final int JXFS_E_SCN_STORAGE_FULL = 15007; // Execution cannot proceed because one or more of the required pocket or escrow to perform the operation is full. The current status of the pockets and escrow should be checked to determine the cause of the problem.
    public static final int JXFS_E_SCN_STAMP_NOT_SUPPORTED = 15008; // A stamping operation on the front or rear of the media cannot be performed.
    public static final int JXFS_E_SCN_ENCODE_NOT_SUPPORTED = 15009; // An encoding operation on the media cannot be performed.
    public static final int JXFS_E_SCN_ENDORSE_NOT_SUPPORTED = 15010; // An endorsing operation on the front or rear of the media cannot be performed.
    public static final int JXFS_E_SCN_INVALID_ENCODE_DATA = 15011; // Data cannot be encoded on media.
    public static final int JXFS_E_SCN_INVALID_ENDORSE_DATA = 15012; // Data cannot be endorsed on media.

    /*
    * Operation Codes
    */
    public static final int JXFS_O_SCN_SCAN = 15100 ; // scan
    public static final int JXFS_O_SCN_PROCESS = 15101 ; // process
    public static final int JXFS_O_SCN_PROCESS_BUNDLE = 15102 ; // processBundle
    public static final int JXFS_O_SCN_CONFIGURE_CHEQUE_SCAN = 15103 ; // configureChequeScan
    public static final int JXFS_O_SCN_CONFIGURE_IMAGE_SCAN = 15104 ; // configureImageScan
    public static final int JXFS_O_SCN_RESET = 15105 ; // reset
    public static final int JXFS_O_SCN_ROLLBACK = 15106 ; // rollback
    public static final int JXFS_O_SCN_SHUTTER_MOVE = 15107 ; // shutterMove
    public static final int JXFS_O_SCN_RETRACT = 15108 ; // retract

    /*
    * Constants 
    */
    public static final int JXFS_C_SCN_VALUE_NOT_INITIALIZED = -1; // The value has not been initialized.
    public static final int JXFS_C_SCN_ESCROW = -2; // Value used to identify escrow destination in commands requiring pockets (scan, process and processBundle).
    public static final int JXFS_C_SCN_NOT_SUPPORTED = -3; // The property is not supported.
    public static final int JXFS_C_SCN_UNKNOWN = -4; // The content of the property is not yet known.

    /*
    * Position Codes 
    */
    public static final int JXFS_C_SCN_POS_LEFT = 4; // left side
    public static final int JXFS_C_SCN_POS_CENTER = 8; // center side
    public static final int JXFS_C_SCN_POS_RIGHT = 16; // right side
    public static final int JXFS_C_SCN_POS_FRONT = 32; // front side
    public static final int JXFS_C_SCN_POS_REAR = 64; // rear side
    public static final int JXFS_C_SCN_POS_TOP = 128; // top side
    public static final int JXFS_C_SCN_POS_BOTTOM = 256; // bottom side

    /*
    * Barcode formats
    */
    public static final String JXFS_C_SCN_BARCODE_UPCA_E = "upca_e"; //UPC-A/E barcode type.
    public static final String JXFS_C_SCN_BARCODE_EAN8_13 = "ean8_13"; //EAN-8/13 barcode type.
    public static final String JXFS_C_SCN_BARCODE_JAN8_13 = "jan8_13"; //JAN 8/13 barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODE39 = "code39"; //CODE 39 barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODE128 = "code128"; //CODE 128 barcode type.
    public static final String JXFS_C_SCN_BARCODE_NW7 = "nw7"; //NW-7 (CODABAR) barcode type.
    public static final String JXFS_C_SCN_BARCODE_ITF = "itf"; //Interleaved 2 of 5 (ITF) barcode type.
    public static final String JXFS_C_SCN_BARCODE_UPCA_E2 = "upca_e2"; //UPC-A/E with 2 digit add-on barcode type.
    public static final String JXFS_C_SCN_BARCODE_UPCA_E5 = "upca_e5"; //UPC-A/E with 5 digit add-on barcode type.
    public static final String JXFS_C_SCN_BARCODE_EAN8_132 = "ean8_132"; //EAN-8/13 with 2 digit add-on barcode type.
    public static final String JXFS_C_SCN_BARCODE_EAN8_135 = "ean8_135"; //EAN-8/13 with 5 digit add-on barcode type.
    public static final String JXFS_C_SCN_BARCODE_EAN128 = "ean128"; //EAN 128 barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODE93 = "code93"; //CODE 93 barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODE11 = "code11"; //CODE 11 (USD-8)
    public static final String JXFS_C_SCN_BARCODE_MSIPLESSEY = "msiplessey"; //MSI / PLESSEY barcode type.
    public static final String JXFS_C_SCN_BARCODE_STD2OF5 = "std2of5"; //STANDARD 2 of 5 barcode type.
    public static final String JXFS_C_SCN_BARCODE_IND2OF5 = "ind2of5"; //INDUSTRIAL 2 of 5 barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODE49 = "code49"; //CODE 49 barcode type.
    public static final String JXFS_C_SCN_BARCODE_POSTNET = "postnet"; //POSTNET barcode type.
    public static final String JXFS_C_SCN_BARCODE_PDF417 = "pdf417"; //PDF-417 barcode type.
    public static final String JXFS_C_SCN_BARCODE_DATAMATRIX = "datamatrix"; //DATAMATRIX barcode type.
    public static final String JXFS_C_SCN_BARCODE_MAXICODE = "maxicode"; //MAXICODE barcode type.
    public static final String JXFS_C_SCN_BARCODE_CODEONE = "codeone"; //CODE ONE barcode type.
    public static final String JXFS_C_SCN_BARCODE_CHANNELCODE = "channelcode"; //CHANNEL CODE barcode type.
}