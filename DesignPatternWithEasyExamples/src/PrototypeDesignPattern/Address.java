package PrototypeDesignPattern;

public class Address
{

    public Address( String streetAddress1, String streetAddress2, String city, int zipCode, String type )
    {
        super();
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.zipCode = zipCode;
        this.type = type;
    }

    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private int zipCode;
    private String type;

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getStreetAddress1()
    {
        return streetAddress1;
    }

    public void setStreetAddress1( String streetAddress1 )
    {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2()
    {
        return streetAddress2;
    }

    public void setStreetAddress2( String streetAddress2 )
    {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode( int zipCode )
    {
        this.zipCode = zipCode;
    }

    @Override
    public String toString()
    {
        return "[ streetAddress1=" + streetAddress1 + ", streetAddress2=" + streetAddress2 + ", city=" + city
            + ", zipCode=" + zipCode + ", type= "+type+"]\n";
    }

}
