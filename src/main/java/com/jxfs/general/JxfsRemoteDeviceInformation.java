package com.jxfs.general;

import java.io.Serializable;

public class JxfsRemoteDeviceInformation extends JxfsDeviceInformation implements Serializable
{
    private String workstationName;  // The (unique) name of the workstation the device is connected to, usually the TCP/IP hostname.

    public JxfsRemoteDeviceInformation (){}
}