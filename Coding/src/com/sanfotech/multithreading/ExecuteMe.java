package com.sanfotech.multithreading;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ExecuteMe
{
    public static void main( String[] args ) throws InterruptedException
    {
        Set<Integer> set = new HashSet<Integer>();
        DemoRunnable demo = new DemoRunnable();
        HashMap<Integer,String> map = new HashMap<Integer, String>();
        

        Thread t = new Thread( demo );
        t.start();
        //t.join();
        
        t.setDaemon( true );
        System.out.println( "In the main thread." );
    }
}

class DemoRunnable implements Runnable
{

    @Override
    public void run()
    {
        while( true )
        {
            System.out.println( "I ran the thread by implemening the runnable interface." );
            try
            {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
