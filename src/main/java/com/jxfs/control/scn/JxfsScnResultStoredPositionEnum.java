package com.jxfs.control.scn;

import com.jxfs.general.JxfsEnum;

/** posible destinations of one item after been scanned or processed */
public final class JxfsScnResultStoredPositionEnum extends JxfsEnum {
    /**
     * Item is in a pocket.
     */
    public static final JxfsScnResultStoredPositionEnum POCKET = new JxfsScnResultStoredPositionEnum("pocket");

    /**
     * Item is in the escrow.
     */
    public static final JxfsScnResultStoredPositionEnum ESCROW = new JxfsScnResultStoredPositionEnum("escrow");

    /**
     * Item is at the output position.
     */
    public static final JxfsScnResultStoredPositionEnum OUTPUT = new JxfsScnResultStoredPositionEnum("output");

    /**
     * Item is at the reject position.
     */
    public static final JxfsScnResultStoredPositionEnum REJECT = new JxfsScnResultStoredPositionEnum("reject");

    private JxfsScnResultStoredPositionEnum(String myId) {
        super(myId);
    }
}

