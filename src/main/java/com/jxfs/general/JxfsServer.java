package com.jxfs.general;

import java.util.Vector;

/*
* Singleton Class
* After successful initialization the device manager must register the devices with a dynamic centralized cache (JxfsServer) so that other J/XFS clients know of the availability of its devices.
* The DeviceManager is the only one to access these repositories directly; the services and controls do it via the DeviceInformation objects.
*/
public class JxfsServer 
{
    public boolean announce(){
		return false;}
    public boolean removeAnnouncement(){
		return false;}
    public Vector getRemoteDeviceInformation(){
		return null;}
}