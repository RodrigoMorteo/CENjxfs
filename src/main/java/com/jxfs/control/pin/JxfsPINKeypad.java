package com.jxfs.control.pin;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.jxfs.events.IJxfsIntermediateListener;
import com.jxfs.events.IJxfsOperationCompleteListener;
import com.jxfs.events.IJxfsStatusListener;
import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsDeviceInformation;
import com.jxfs.general.JxfsId;
import com.jxfs.general.JxfsStatus;
import com.jxfs.general.JxfsType;
import com.jxfs.general.JxfsVersion;
import com.jxfs.service.IJxfsBaseService;

/**
Base class for PIN controls.
Contains properties specific to PIN device controls. */
class JxfsPINKeypad implements IJxfsPINKeypadControl {

	@Override
	public JxfsId readData(JxfsPINReadMode readMode) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId readData(JxfsPINReadMode2 readMode) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int open() throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int close() throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean claim(int timeout) throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean claim(String tag, int timeout) throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean release(int timeout) throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancel(int identificationID) throws JxfsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JxfsStatus getStatus() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getStatus(List list) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIntermediateListener(IJxfsIntermediateListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOperationCompleteListener(IJxfsOperationCompleteListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStatusListener(IJxfsStatusListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeIntermediateListener(IJxfsIntermediateListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeOperationCompleteListener(IJxfsOperationCompleteListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStatusListener(IJxfsStatusListener l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDeviceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsVersion getDeviceControlVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsVersion getDeviceServiceVersion() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalDeviceDescription() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalDeviceName() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFirmware() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFirmwareStatus() throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JxfsVersion getDeviceFirmwareVersion() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsVersion getRepositoryFirmwareVersion() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPowerSaveModeSupported() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int wakeUpFromPowerSave() throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int directIO(int command, JxfsType serializable) throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deregisterDevice() throws JxfsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInterDependentDevice() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<?> getInterDependentDevices() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerService(IJxfsBaseService myService, JxfsDeviceInformation di) throws JxfsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionFailure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getInputRawSupported() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getInputCookedSupported() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getBeepOnPressSupported() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEventOnStartSupported() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

}