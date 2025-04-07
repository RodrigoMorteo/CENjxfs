package com.jxfs.control.pin;
/*
Interface for PIN controls implementing secure PIN entry and validation.
Contains methods specific to device controls for the secure PIN device category.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;

import SampleApp.Property;

interface IJxfsSecurePINKeypadControl extends IJxfsPINKeypadControl {

		public static final JxfsPINFormats supportedPINFormats = new JxfsPINFormats();
		public static final JxfsPINValidationAlgorithms supportedValidationAlgorithms = new JxfsPINValidationAlgorithms();
		public static final JxfsPINChipPresentationModes supportedChipPresentationModes = new JxfsPINChipPresentationModes();
        Property getProperty() throws JxfsException;
		void setProperty(Property property) throws JxfsException;
		JxfsId secureReadPIN (JxfsPINReadMode readMode) throws JxfsException;
		JxfsId secureReadPIN (JxfsPINReadMode2 readMode) throws JxfsException;
		JxfsId createOffset (JxfsPINOffsetData offsetData) throws JxfsException;
		JxfsId createPINBlock (JxfsPINBlockData pinBlockData) throws JxfsException;
		JxfsId validatePIN (JxfsPINValidationData validationData) throws JxfsException;
		JxfsId createOffsetSecure (JxfsPINOffsetData offsetData) throws JxfsException;
		JxfsId createPINBlockSecure (JxfsPINBlockData pinBlockData) throws JxfsException;
        //When the operation completes a JxfsOperationCompleteEvent event will be sent by J/XFS PINKeypad Device Control to all registered OperationCompleteListeners.
        /*
        With combined MSD-PIN devices, this function does not require that
        offset and/or validation data be returned to the device as parameters.
        Instead, offset and/or validation data can be automatically read from
        the card in the device.
        The behavior is as follows:
        1 – If card is present in reader and ejectCurrent property is false then go to 5.
        2 – If card is present in reader and ejectCurrent property is true then eject the card.
        3 – Arm the device to accept a magnetic stripe card.
        4 – Poll card status and verify that card is seated.
        5 – Perform the intended function using the data read from the card.
        6 – Eject the card if ejectWhenComplete property is true. 
        */
		JxfsId validatePINSecure (JxfsPINValidationData validationData) throws JxfsException;
		JxfsId validatePINChip (java.lang.String aCCDeviceName, JxfsPINChipValidationData validationData) throws JxfsException;
}