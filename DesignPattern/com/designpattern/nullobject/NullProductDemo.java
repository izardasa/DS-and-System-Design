package com.designpattern.nullobject;

public class NullProductDemo
{

    public static void main( String[] args )
    {
        AbstractProduct product1 = ProductFactory.getProduct( "Mug" );
        AbstractProduct product2 = ProductFactory.getProduct( "Bottle" );
        AbstractProduct product3 = ProductFactory.getProduct( "Doormat" );
        AbstractProduct product4 = ProductFactory.getProduct( "Jar" );

        System.out.println( "-----------Products---------" );
        System.out.println( product1.getName() );
        System.out.println( product2.getName() );
        System.out.println( product3.getName() );
        System.out.println( product4.getName() );
        
    }

}
