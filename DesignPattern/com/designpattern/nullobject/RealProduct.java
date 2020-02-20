package com.designpattern.nullobject;

public class RealProduct extends AbstractProduct
{

    public RealProduct()
    {
        // TODO Auto-generated constructor stub
    }
    
    public RealProduct(String name)
    {
       this.name = name;
    }
 

    @Override
    public String getName()
    {
        return name;
    }

}
