package com.sanfotech.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Task implements Runnable
{
    CyclicBarrier barrier;

    public Task( CyclicBarrier barrier )
    {
        this.barrier = barrier;
    }

    @Override
    public void run()
    {
        System.out.println( "Thread started " + Thread.currentThread().getName() );
        try
        {
            barrier.await();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch( BrokenBarrierException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "Thread started " + Thread.currentThread().getName() );
    }

}

public class CyclicBarrierDemo
{
    public static void main( String[] args )
    {

        CyclicBarrier cb = new CyclicBarrier( 3, () -> {
            System.out.println( "All parties are waiting at the barrier" );
        } );

        Thread t1 = new Thread(new Task( cb), "Thread 1" );
        Thread t2 = new Thread( new Task( cb), "Thread 2" );
        Thread t3 = new Thread( new Task( cb), "Thread 3" );
        
        t1.start();
        t2.start();
        t3.start();
    }
}
