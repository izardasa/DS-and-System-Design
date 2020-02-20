package com.sanfotech.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FinallyDemo
{
    public static class A
    {
        
    }
    public static class B
    {
        
    }
    public static void main( String[] args ) throws InterruptedException
    {
    List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++)
            list.add( i );
        
//        for(Integer num: list)
//            list.remove( 0 );
        
   
    
    
    }
    
    public double sum()
    {
        int a=10;
        int b=0;
        double c=0.0;
        try
        {
            
           System.exit( 0 );
        }
        catch(Exception ex)
        {
            System.out.println( ex.getMessage() );
        }
        finally
        {
            System.out.println( "I reached finally" );
        }
        
        return c;
    }
}


