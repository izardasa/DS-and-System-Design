package com.sanfotech.multithreading;

import java.util.concurrent.ExecutionException;

public class ThreadLocalDemo
{

    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        UnsafeCounter counter = new UnsafeCounter();
        Thread[] tasks = new Thread[100];
        for( int i = 0; i < 100; i++ )
        {
            Thread t = new Thread( () -> {

                for( int j = 0; j < 100; j++ )
                    counter.increment();
                
                System.out.println( counter.count.get() );
            } );
            
            tasks[i] = t;
            tasks[i].start();

        }
        
        for(int i=0;i<100;i++)
        {
            tasks[i].join();
        }
        System.out.println( counter.count.get() );

    }

}

class UnsafeCounter
{

    ThreadLocal<Integer> count = new ThreadLocal<>().withInitial( ()->0 );
    public void increment()
    {
        count.set( count.get()+1 );
    }
}
