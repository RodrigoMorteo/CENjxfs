package com.jxfs.control.pin;

import java.util.Vector;

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

/**
Interface for PIN controls implementing security and cryptographic functions. 
*/

public interface IJxfsCrypto extends IJxfsPINKeypadControl {

    // Properties
    JxfsPINCryptoModes getSupportedCryptModes() throws JxfsException;
    int getNumberOfKeys() throws JxfsException;
    JxfsPINIdKeyModes getIdKey() throws JxfsException;
    JxfsSecureKeyEntrySupportedEnum getSecureKeyEntrySupported() throws JxfsException;
    JxfsPINSecureKeyDetail getSecureKeyDetail() throws JxfsException;
    boolean getSecureKeyEntryState() throws JxfsException;
    JxfsPINRemoteKeyLoadModes getRemoteKeyLoadCapabilities() throws JxfsException;

    // Methods
    JxfsId decrypt(JxfsPINCryptoData decryptData) throws JxfsException;
    JxfsId encrypt(JxfsPINCryptoData encryptData) throws JxfsException;
    JxfsId generateMAC(JxfsPINMACData macData) throws JxfsException;
    JxfsPINKeyDetail getKeyInfo(String keyName) throws JxfsException;
    Vector getKeyNameList() throws JxfsException;
    JxfsId importKey(JxfsPINKeyToImport keyToImport, boolean lastOrOnlyPart) throws JxfsException;
    JxfsId initialize(byte[] id, byte[] key) throws JxfsException;
    JxfsId importEMVRSAPublicKey(JxfsPINEMVRSAKeyToImport RSAkeyToImport) throws JxfsException;
    JxfsId computeSHA1Digest(JxfsSHA1Data SHA1Data) throws JxfsException;
    JxfsId deleteKey(String keyName) throws JxfsException;
    JxfsId importRSAPublicKey(JxfsPINImportRSAPublicKey RSAPublicKeyToImport, boolean lastOrOnlyPart) throws JxfsException;
    JxfsId exportRSAPublicKey(JxfsPINExportRSAPublicKey RSAPublicKeyToExport) throws JxfsException;
    JxfsId importRSADESEncipheredPublicKey(JxfsPINImportRSADESEncipheredPublicKey RSADESEncipheredPublicKeyToImport) throws JxfsException;
    JxfsId exportRSADESEncipheredPublicKey(JxfsPINExportRSADESEncipheredPublicKey RSADESEncipheredPublicKeyToExport) throws JxfsException;
    JxfsId generateRSAKeyPair(JxfsPINGenerateRSAKeyPair RSAKeyPairToGenerate) throws JxfsException;
    JxfsId importCertificate(byte[] certificateToImport) throws JxfsException;
    JxfsId exportCertificate(JxfsPINCertificateKeyType certificateKeyType) throws JxfsException;
    JxfsId replaceCertificate(byte[] newCertificate) throws JxfsException;
    JxfsId startKeyExchange() throws JxfsException;
    JxfsId secureKeyEntry(JxfsPINSecureKeyMode secureKeyMode) throws JxfsException;
    JxfsId importSecureKeyEntered(JxfsPINSecureKeyToImport secureKey, boolean lastOrOnlyPart, int verificationType, byte[] verificationData) throws JxfsException;
    JxfsId clearSecureKeyBuffer() throws JxfsException;
    JxfsId importRSAEncipheredPKCS7Key(JxfsPINImportRSAEncipheredPKCS7Key RSAEncipheredPKCS7KeyToImport) throws JxfsException;
    JxfsId exportRSASignedPKCS7KeyConfirmation(JxfsPINKeyDetail keyDetail) throws JxfsException;
}