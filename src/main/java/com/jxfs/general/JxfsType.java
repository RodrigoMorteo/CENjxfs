/*
* This is a class any J/XFS class which contains data should inherit from. This can be the data objects delivered within some events or any other complex object which serves as an input or output parameter for Device Control methods.
* This is needed to ensure the streamability of any data class used in J/XFS because any data object might be streamed over a network connection and must be stored in the repository in its binary format.
* Java base data types like String, int, etc. are streamable anyway and thus may be used as parameters without putting them into special wrapper classes.
*/
package com.jxfs.general;

public class JxfsType {

    //Property getProperty( ){} //TODO: check wher the getPropery method should be placed.
    /*
    * Constructs a deep copy of the object and returns a reference to that copy. This method constructs deep copies of this object and all objects directly or indirectly referenced by it. A reference to the copy is returned. It is guarantied that all modifications of the copy won’t affect the original object.
    */
    JxfsType copy() {
		return null;
	}
}