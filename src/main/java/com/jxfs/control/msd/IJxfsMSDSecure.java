package com.jxfs.control.msd;

import com.jxfs.control.IJxfsMotorizedCard;
import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

public interface IJxfsMSDSecure extends IJxfsMotorizedCard {

    // Properties
    byte[] getSecureModuleKey() throws JxfsException;
    void setSecureModuleKey(byte[] secureModuleKey) throws JxfsException;
    int getSecureModuleStatus() throws JxfsException;

    // Methods
    JxfsId readData(JxfsMSDTrackSelection tracksToRead, JxfsMSDSecureMode secureMode) throws JxfsException;
    JxfsId readWMtrack(JxfsMSDTrackSelection tracksToRead, JxfsMSDSecureMode secureMode) throws JxfsException;
}