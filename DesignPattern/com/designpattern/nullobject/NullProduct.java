package com.designpattern.nullobject;

public class NullProduct extends AbstractProduct
{

    @Override
    public String getName()
    {
        return "This product is not available.";
    }

}
