package com.jxfs.control.pin;
/*
* This class is used to specify the supported charging modes.
*/

import java.io.Serializable;

import com.jxfs.general.JxfsType;

class JxfsPINIsoSupportedModes extends JxfsType implements Serializable {
    Boolean chargeAccount;              //Specifies if charging against an account is supported.
    Boolean chargeCreditCard;           //Specifies if charging against a credit card is supported. 
    Boolean chargeECcard;               //Specifies if charging against an EC-card is supported.
    Boolean chargeCash;                 //Specifies if charging against cash is supported.
    Boolean chargeInternationalECcard;  //Specifies if charging against an international EC-card is supported.
    Boolean dischargeECcard;            //Specifies if discharging against an account of a EC-card is supported.

    JxfsPINIsoSupportedModes (Boolean chargeAccount,  Boolean chargeCreditCard, Boolean chargeECcard, Boolean chargeCash, Boolean chargeInternationalECcard, Boolean dischargeECcard) {

    }

    boolean isChargeAccount(){
		return chargeAccount;}

    boolean isChargeCreditCard(){
		return chargeCreditCard;}

    boolean isChargeECcard(){
		return chargeECcard;}

    boolean isChargeCash(){
		return chargeCash;}

    boolean isChargeInternationalECcard(){
		return chargeInternationalECcard;}

    boolean isDishargeECcard(){
    	return dischargeECcard;
    }



}
