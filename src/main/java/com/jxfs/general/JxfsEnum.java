package com.jxfs.general;
import java.lang.reflect.*;

public abstract class JxfsEnum extends JxfsType{
    private transient String _fieldName;
    
    protected JxfsEnum(String fieldName) {
    	this._fieldName = fieldName;
    }
    
    private void writeObject( java.io.ObjectOutputStream out) throws java.io.IOException {
        Class clazz = getClass();
        Field [] f = clazz.getDeclaredFields();
        for( int i = 0; i < f.length; i++) {
            try{
                int mod = f[ i].getModifiers();
                if( Modifier.isStatic( mod) && Modifier.isFinal( mod) && Modifier.isPublic( mod)) {
                    if( this == f[ i].get( null)) {
                        String fName=f[ i].getName();
                        out.writeObject( fName);
                    }
                }
            } 
            catch( IllegalAccessException ex)
            {
                throw new java.io.IOException( ex.getMessage());
            }
        }
    }

    private void readObject( java.io.ObjectInputStream in) throws java.io.IOException {
        try
        {
        	_fieldName = ( String)in.readObject();
        }
        catch( ClassNotFoundException ex)
        {
            throw new java.io.IOException( ex.getMessage());
        }
    }

    public Object readResolve() throws java.io.ObjectStreamException {
        try
        {
            Class clazz = getClass();
            Field f = clazz.getField( _fieldName);
            return f.get( null);
        } 
        catch( Exception ex)
        {
            ex.printStackTrace();
            throw new java.io.InvalidObjectException( "Failed to resolve object");
        }
    }
}