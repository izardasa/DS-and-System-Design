package PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable
{
    private int id;
    private String name;

    private List<Address> addresses;

    public Employee( int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
        this.addresses = new ArrayList<Address>();
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }
    
    public void loadData()
    {
         
             Address homeAddress = new Address( "Near Ryan International School", "Opposite Brookefiled Mall", "Bengaluru", 560037, "Home" );
             Address officeAddress = new Address( "Kalyani Platina", "Opposite Cosmos Mall", "Bengaluru", 560037, "Office" );
             Address permanentAddress = new Address( "Hanuman Temple", "Near Dist. Office", "Raigarh", 496001, "Permanent" );
             getAddresses().add( homeAddress );
             getAddresses().add( officeAddress );
             getAddresses().add( permanentAddress );
    }

    @Override
    public String toString()
    {
        return "Employee id=" + id + ", name=" + name + ",\n addresses=" + addresses + " \n HashCode = "+hashCode();
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setAddresses( List<Address> addresses )
    {
        this.addresses = addresses;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}
