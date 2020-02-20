package com.designpattern.nullobject;

public class ProductFactory
{
    
    static String[] dailyNeedProducts = {"Bottle","Mug","Bucket","Jar"};
    
    public static AbstractProduct getProduct(String productName)
    {
        for(int i=0;i<dailyNeedProducts.length;i++)
        {
            if(productName.equals( dailyNeedProducts[i] ))
            {
                return new RealProduct( productName );
            }
        }
        
        return new NullProduct();
    }

}
