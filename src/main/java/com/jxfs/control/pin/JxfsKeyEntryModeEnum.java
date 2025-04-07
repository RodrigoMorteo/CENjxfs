package com.jxfs.control.pin;
/*
 * The JxfsKeyEntryModeEnum class, represents methods for secure key entry during operations like manually entering a master key. 
 * The JxfsKeyEntryModeEnum class is used by the JxfsPINSecureKeyDetail class, which holds details about secure key entry.
 */

import com.jxfs.general.JxfsEnum;

public final class JxfsKeyEntryModeEnum extends JxfsEnum {

    public static final JxfsKeyEntryModeEnum NOT_SUPPORTED= new JxfsKeyEntryModeEnum("NOT_SUPPORTED");
    public static final JxfsKeyEntryModeEnum SINGLE = new JxfsKeyEntryModeEnum("SINGLE");
    public static final JxfsKeyEntryModeEnum DOUBLE = new JxfsKeyEntryModeEnum("DOUBLE");
    public static final JxfsKeyEntryModeEnum NUMERIC = new JxfsKeyEntryModeEnum("NUMERIC");
    public static final JxfsKeyEntryModeEnum UNKNOWN = new JxfsKeyEntryModeEnum("UNKNOWN");

    private final String Id;
    private String description;
    private final int Ordinal;
    private static int UpperBound;

    JxfsKeyEntryModeEnum(String myId) {
    	super(myId);
        this.Id = myId;
        this.Ordinal = UpperBound++;
    }

    public String toString() {
        return this.Id;
    }

    public int compareTo(JxfsKeyEntryModeEnum type) {
        return (Ordinal - type.Ordinal);
    }
}
