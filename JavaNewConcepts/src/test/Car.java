package test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable{
	   static int age; 
	    String name; 
	    int year; 
	  String state;
	  String city;
	  String country;
	  
	    public Car() 
	    { 
	        System.out.println("Default Constructor called"); 
	    } 
	  
	    Car(String n, int y, String state, String city,String country) 
	    { 
	        name = n; 
	        year = y; 
	        age = 10; 
	        this.state= state;
	        this.city = city;
	        this.country = country;
	        
	    } 
	    public void writeExternal(ObjectOutput out)  
	                              throws IOException 
	    { 
	        out.writeObject(name); 
	        out.writeInt(age); 
	        out.writeInt(year); 
	        out.writeObject(state);
	        out.writeObject(city);
	        out.writeObject(country);
	    } 
	    public void readExternal(ObjectInput in)  
	       throws IOException, ClassNotFoundException 
	    { 
	        name = (String)in.readObject(); 
	        year = in.readInt(); 
	        age = in.readInt();
	        state = (String)in.readObject();
	        city= (String)in.readObject();
	        country = (String)in.readObject();
	    } 
	    public String toString() 
	    { 
	        return ("Name: " + name + "\n" +  
	               "Year: " + year + "\n" +  
	               "Age: " + age+"\n"+
	               "State:"+state+"\n"+
	               "City:"+city+"\n"+
	               "Country:"+country); 
	    } 
}
