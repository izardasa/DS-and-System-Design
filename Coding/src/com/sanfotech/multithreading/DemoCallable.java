package com.sanfotech.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoCallable
{

    static ExecutorService threadPool = Executors.newFixedThreadPool( 2 );

    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        System.out.println( "Total sum is :" + sum( 10 ) );
        threadPool.shutdown();

    }

    public static int sum( final int n )
    {
        int result = -1;

        Callable<Integer> sumTask = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                Thread.sleep( 10 );
                int sum = 0;
                for( int i = 1; i <= n; i++ )
                    sum += i;

                return sum;
            }
        };

        Callable<Void> randomTask = new Callable<Void>()
        {
            public Void call() throws InterruptedException
            {
                Thread.sleep( 3600 * 1000 );
                return null;
            }
        };

        Future<Integer> f1 = threadPool.submit( sumTask );
        Future<Void> f2 = threadPool.submit( randomTask );

        try
        {
            f2.cancel( true );

            while( !f1.isDone() )
            {
                System.out.println( "Waiting for the first task to complete." );
            }

            result = f1.get();
        }
        catch( ExecutionException | InterruptedException ex )
        {
            System.out.println( "Something went wrong." );
        }
        return result;

    }

}
