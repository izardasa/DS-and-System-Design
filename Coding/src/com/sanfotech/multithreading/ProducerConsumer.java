package com.sanfotech.multithreading;

import java.util.Vector;

public class ProducerConsumer
{
    public static void main( String[] args ) throws InterruptedException
    {
        Vector<Integer> sharedQueue = new Vector<Integer>();
        Thread t1 = new Thread( new Producer( sharedQueue, 4 ) );
        Thread t2 = new Thread( new Consumer( sharedQueue, 4 ) );

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Producer extends Thread
{
    @Override
    public void run()
    {
        for( int i = 0; i < 7; i++ )
        {
            try
            {
                produce( i );
            }
            catch( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    final Vector<Integer> sharedQueue;
    final int SIZE;

    public Producer( Vector<Integer> sharedQueue, int size )
    {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    public synchronized void produce( int n ) throws InterruptedException
    {
        while( sharedQueue.size() == SIZE )
        {
            System.out.println( "Queue is full. wait ." );
            sharedQueue.wait();
        }

        sharedQueue.add( n );
        sharedQueue.notifyAll();
    }

}

class Consumer extends Thread
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep( 1000 );
            for( int i = 0; i < 3; i++ )
                consume();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    final Vector<Integer> sharedQueue;
    final int SIZE;

    public Consumer( Vector<Integer> sharedQueue, int size )
    {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    public synchronized void consume() throws InterruptedException
    {
        while( sharedQueue.size() != 0 )
        {
            int num = sharedQueue.remove( 0 );
            System.out.println( "Consumed " + num );
            sharedQueue.wait();
        }

        System.out.println( "Queue is empty" );
        sharedQueue.notify();

    }
}