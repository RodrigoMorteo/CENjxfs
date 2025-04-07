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

import SampleApp.Property;

/**
Class for PIN controls implementing security and cryptographic functions. */
public abstract class JxfsSecurePINKeypad extends JxfsPINKeypad implements IJxfsSecurePINKeypadControl, IJxfsCrypto {

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
	public Property getProperty() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(Property property) throws JxfsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JxfsId secureReadPIN(JxfsPINReadMode readMode) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId secureReadPIN(JxfsPINReadMode2 readMode) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId createOffset(JxfsPINOffsetData offsetData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId createPINBlock(JxfsPINBlockData pinBlockData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId validatePIN(JxfsPINValidationData validationData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId createOffsetSecure(JxfsPINOffsetData offsetData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId createPINBlockSecure(JxfsPINBlockData pinBlockData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId validatePINSecure(JxfsPINValidationData validationData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId validatePINChip(String aCCDeviceName, JxfsPINChipValidationData validationData)
			throws JxfsException {
		// TODO Auto-generated method stub
		return null;
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
	public JxfsPINCryptoModes getSupportedCryptModes() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfKeys() throws JxfsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JxfsPINIdKeyModes getIdKey() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsSecureKeyEntrySupportedEnum getSecureKeyEntrySupported() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsPINSecureKeyDetail getSecureKeyDetail() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getSecureKeyEntryState() throws JxfsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JxfsPINRemoteKeyLoadModes getRemoteKeyLoadCapabilities() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId decrypt(JxfsPINCryptoData decryptData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId encrypt(JxfsPINCryptoData encryptData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId generateMAC(JxfsPINMACData macData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsPINKeyDetail getKeyInfo(String keyName) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getKeyNameList() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importKey(JxfsPINKeyToImport keyToImport, boolean lastOrOnlyPart) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId initialize(byte[] id, byte[] key) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importEMVRSAPublicKey(JxfsPINEMVRSAKeyToImport RSAkeyToImport) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId computeSHA1Digest(JxfsSHA1Data SHA1Data) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId deleteKey(String keyName) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importRSAPublicKey(JxfsPINImportRSAPublicKey RSAPublicKeyToImport, boolean lastOrOnlyPart)
			throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId exportRSAPublicKey(JxfsPINExportRSAPublicKey RSAPublicKeyToExport) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importRSADESEncipheredPublicKey(
			JxfsPINImportRSADESEncipheredPublicKey RSADESEncipheredPublicKeyToImport) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId exportRSADESEncipheredPublicKey(
			JxfsPINExportRSADESEncipheredPublicKey RSADESEncipheredPublicKeyToExport) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId generateRSAKeyPair(JxfsPINGenerateRSAKeyPair RSAKeyPairToGenerate) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importCertificate(byte[] certificateToImport) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId exportCertificate(JxfsPINCertificateKeyType certificateKeyType) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId replaceCertificate(byte[] newCertificate) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId startKeyExchange() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId secureKeyEntry(JxfsPINSecureKeyMode secureKeyMode) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importSecureKeyEntered(JxfsPINSecureKeyToImport secureKey, boolean lastOrOnlyPart,
			int verificationType, byte[] verificationData) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId clearSecureKeyBuffer() throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId importRSAEncipheredPKCS7Key(JxfsPINImportRSAEncipheredPKCS7Key RSAEncipheredPKCS7KeyToImport)
			throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxfsId exportRSASignedPKCS7KeyConfirmation(JxfsPINKeyDetail keyDetail) throws JxfsException {
		// TODO Auto-generated method stub
		return null;
	}

}