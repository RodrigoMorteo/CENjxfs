/////////////////////////////////////////////////////////////////////
//
// JxfsException
//
// Exception class used to report all J/XFS errors.
//
/////////////////////////////////////////////////////////////////////
package com.jxfs.events;

/*
* Exception class. The J/XFS PIN Device Control creates and throws exceptions on method failure and property access failure.
*/
public class JxfsException extends java.lang.Exception {
    protected int errorCode;
    protected int errorCodeExtended;
    private Exception origException;
    
    /* Some utility constructors to allow some parameters to be omitted. If description is not directly given it is filled with errorCode and errorCodeExtended. */
    public JxfsException(int errorCode)
    {
        this(errorCode, 0, "" + errorCode, null);
    }

    public JxfsException(int errorCode, int errorCodeExtended)
    {
        this(errorCode, errorCodeExtended, "" + errorCode + ", " + errorCodeExtended, null);
    }
    
    public JxfsException(int errorCode, String description)
    {
        this(errorCode, 0, description, null);
    }
    
    public JxfsException(int errorCode, int errorCodeExtended, String description)
    {
        this(errorCode, errorCodeExtended, description, null);
    }
    
    public JxfsException(int errorCode, String description, Exception origException)
    {
        this(errorCode, 0, description, origException);
    }
    
    /* main constructor with all parameters */
    public JxfsException(int errorCode, int errorCodeExtended, String description, Exception origException)
    {
        super(description);
        this.errorCode = errorCode;
        this.errorCodeExtended = errorCodeExtended;
        this.origException = origException;
    }
    
    public int getErrorCode() {
        return errorCode;
    }
    
    public int getErrorCodeExtended()
    {
        return errorCodeExtended;
    }
    public Exception getOrigException()
    {
        return origException;
    }
}