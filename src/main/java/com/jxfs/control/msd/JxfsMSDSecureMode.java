package com.jxfs.control.msd;

import com.jxfs.general.JxfsType;
/**
 * The class serves as a container for configuration options that determine how security features should be applied during a read operation on a magnetic stripe card.
 */
public class JxfsMSDSecureMode extends JxfsType {
    // Properties
    private boolean securityCheck;
    private boolean secureTestCard;

    // Getters and Setters
    public boolean isSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(boolean securityCheck) {
        this.securityCheck = securityCheck;
    }

    public boolean isSecureTestCard() {
        return secureTestCard;
    }

    public void setSecureTestCard(boolean secureTestCard) {
        this.secureTestCard = secureTestCard;
    }

    // Constructor
    public JxfsMSDSecureMode(boolean securityCheck, boolean secureTestCard) {
        this.securityCheck = securityCheck;
        this.secureTestCard = secureTestCard;
    }
}
