package com.jxfs.service;
/*
* The advocated way to implement complex devices is to have a single device service object that will create a delegated object for each sub-component. By doing this it is possible to have interface version protection. The IJxfsComplexDeviceService interface, defined in the com.jxfs.service package, enables the device manager to query a complex device service for a specific sub-component, and register it with the device control. 
* A complex device service is required to implement the IJxfsComplexDeviceService interface only.
* In order to provide the backward compatibility with complex device services conform to the older version of the J/XFS specification, the device manager should check whether the instantiated complex device service implements the IJxfsComplexDeviceService interface.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsLocalDeviceInformation;

public interface IJxfsComplexDeviceService {

    /*
    * This method is used by the Device Manager to supply the detailed device information to the complex device service. The your_infos array contains detailed information objects for all sub-components of the complex device service.
    * Exceptions:
    *    JXFS_E_PARAMETER_INVALID The given parameter is invalid.
    */
    void initialize(JxfsLocalDeviceInformation[] your_infos) throws JxfsException;

    /*
    * Description This method is used by the Device Manager to retrieve the delegate object which represents a specific sub-component of the complex device service. The logical_name parameter is the logical name of the device (e.g. "MSD1"). This name corresponds with the logical_name parameter in the getDevice() method of the IJxfsDeviceManager interface.
    * Exceptions:
    *   JXFS_E_PARAMETER_INVALID The given parameter is invalid. There is no sub-component with the given logical name. 
    */
    IJxfsBaseService getSubComponent(String logical_name) throws JxfsException;



}