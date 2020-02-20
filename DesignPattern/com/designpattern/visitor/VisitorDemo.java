package com.designpattern.visitor;

public class VisitorDemo
{

    public static void main( String[] args )
    {
        Visitor visitor = new TaxVisitor();
        
        Necessity necessity = new Necessity(100);
        Tabacco tabacco = new Tabacco(100);
        Liquor liquor = new Liquor(100);
        
        
        System.out.println( "Necessity charges "+necessity.getPrice()+" with taxes "+ necessity.accept( visitor ) );
        System.out.println( "Tobacco charges "+tabacco.getPrice()+" with taxes " + tabacco.accept( visitor ) );
        System.out.println( "Liquor charges "+liquor.getPrice()+" with taxes " + liquor.accept( visitor ) );

    }

}
