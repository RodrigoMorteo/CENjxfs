package com.jxfs.general;
/*
* Helper class which only contains information about a LogListener 
It contains a description (as returned by the corresponding LogListener) as well as an integer id which is set to a unique value
from the JxfsLogger in order to clearly identify this LogListener. Instances of class JxfsID
are unique within the VM where they are created. If the parameterless constructor is used
for this type the values of the ID and description are undefined.
*/

public class JxfsId 
{
	// Properties
    private int id; //The spec don't specify how the uniqueness of the ID is enforced. It's likely the responsibility of the class using JxfsId (such as JxfsLogger) to ensure that unique IDs are generated. A common approach is to use a static counter that increments with each new JxfsId created.
    private String description;
    public JxfsId() {
	} // the constructor
    public JxfsId(int id, String description) {// second constructor
        this.id = id;
        this.description = description;
    }
    public void setId(int id) { // Setter for id
    	this.id = id;
    }
    public int getId() { // Getter for id
    	 return id;
    }; 
    public void setDescription(String description) { // Setter for description
    	this.description = description;
    }
    public String getDescription() { // Getter for description
    	return this.description;
    }
    public String toString() { // returns the id + the description in one String
		return id + " " + description;
	} 
    protected Object clone() { // returns a clone of this object
		return null; //TODO: Implement clone logic
	} 
    
}