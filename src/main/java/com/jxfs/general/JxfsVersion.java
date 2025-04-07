package com.jxfs.general;
public class JxfsVersion {

	private final int vendorMajor;
    private final int vendorMinor;
    private final int vendorBuild;
    private final int jxfsMajor;
    private final int jxfsMinor;
    private final String description;
    
    public JxfsVersion(int vendorMajor, int vendorMinor, int vendorBuild, int jxfsMajor, int jxfsMinor, String description) {
    	this.vendorMajor = vendorMajor;
        this.vendorMinor = vendorMinor;
        this.vendorBuild = vendorBuild;
        this.jxfsMajor = jxfsMajor;
        this.jxfsMinor = jxfsMinor;
        this.description = description;
	}

    /*
    *Return the major release number of the vendor’s implementation. 
    */
    public int getVendorMajor(){
		return vendorMajor;}

    /*
    * Return the minor release number of the vendor's implementation. The minor release number will be counted as fractions from thousand. As an example the version 1.02 will have a minor number of 20.
    */
    public int getVendorMinor() {
		return vendorMinor;}

    /*
    * Return the build number of the vendor’s implementation.
    */
    public int getVendorBuild() {
		return vendorBuild;}

    /*
    * Return the major release number of the implemented J/XFS standard.
    */
    public int getJxfsMajor() {
		return jxfsMajor;}

    /*
    * Return the minor release number of the implemented J/XFS standard. The minor release number will be counted as fractions from thousand. As an example the version 1.02 will have a minor number of 20.
    */
    public int getJxfsMinor() {
		return jxfsMinor;}

    /*
    * Return a more detailed description about this object which should also be suitable to be printed out. So, the format should be similar to “ACME Magnetic Stripe Reader Device Service 1.03 (c)1999 Acme corp.”
    */
    public String  getDescription() { //TODO: the spec's method signature is int getDescription();
		return description;}


}