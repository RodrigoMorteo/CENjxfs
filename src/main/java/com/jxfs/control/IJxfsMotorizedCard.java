package com.jxfs.control;

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsThresholdStatus;

public interface IJxfsMotorizedCard {

    // Getters for properties
    int getPowerOffCapabilities() throws JxfsException;

    int getPowerOnCapabilities() throws JxfsException;

    JxfsThresholdStatus getRetainBinStatus() throws JxfsException;

    int getRetainCardCount() throws JxfsException;

    boolean getRetainCapability() throws JxfsException;

    int getSecureModuleType() throws JxfsException;

    // Methods for card manipulation
    void resetRetainCardCount() throws JxfsException;

    int ejectCard() throws JxfsException;

    int retainCard() throws JxfsException;
}