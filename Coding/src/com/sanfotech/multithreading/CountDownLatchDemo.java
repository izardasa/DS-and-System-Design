package com.sanfotech.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

class WorkerThread extends Thread
{
    CountDownLatch latch;
    public WorkerThread(CountDownLatch latch , String name)
    {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println( "Thread "+Thread.currentThread().getName()+" Started." );
        try
        {
            Thread.sleep( 3000 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "Thread "+Thread.currentThread().getName()+" Completed." );
        
        latch.countDown();
        
    }
    
}

class MasterThread extends Thread
{
    public MasterThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        System.out.println( "Master thread "+Thread.currentThread().getName()+" started." );
        try
        {
            Thread.sleep( 2000 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "Master thread "+Thread.currentThread().getName()+" completed." );
    }
    
    
}

public class CountDownLatchDemo
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(2);
        WorkerThread worker1 = new WorkerThread( latch, "Worker Thrad 1. " );
        WorkerThread worker2 = new WorkerThread( latch, "Worker Thrad 2. " );
        
        worker1.start();
        worker2.start();
        
        try
        {
            latch.await();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        MasterThread masterThread = new MasterThread( "Master Thread " );
        masterThread.start();
    }
}
