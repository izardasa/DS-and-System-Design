import java.util.Timer;

public class Sample
{

    public static void main( String[] args ) throws InterruptedException
    {
        SumUpExample.runTests();
        
    }

}

class SumUpExample
{
    static long total;
    static int maxLimit = Integer.MAX_VALUE;
    int start;
    int end;
    public SumUpExample(int start,int end)
    {
        this.start = start;
        this.end = end;
        total = 0;
    }

    public void add()
    {
        

        for( int i = start; i <= end; i++ )
        {
            total += (long)i;
          //  System.out.println( i+" "+total );
        }

        
    }

    public static void oneThread() throws InterruptedException
    {
        SumUpExample sumup = new SumUpExample(0, maxLimit);
        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread( () -> {
            sumup.add( );
        } );

        t1.start();
        t1.join();
        
        long timeEnd = System.currentTimeMillis();
        System.out.println( "Total :" + total + ", Time Taken: " + ( timeEnd - timeStart ) );
    }

    public static void twoThreads() throws InterruptedException
    {
        SumUpExample sumup1 = new SumUpExample(0,maxLimit/2);
        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread( () -> {
            sumup1.add();
        } );

        SumUpExample sumup2 = new SumUpExample(maxLimit/2+1,maxLimit);
        Thread t2 = new Thread( () -> {
            sumup2.add();
        } );

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        
        long timeEnd = System.currentTimeMillis();
        System.out.println( "Total :" + total + ", Time Taken: " + ( timeEnd - timeStart ) );
    }

    public static void fourThreads() throws InterruptedException
    {
        SumUpExample sumup1 = new SumUpExample(0, maxLimit/4);
        SumUpExample sumup2 = new SumUpExample(maxLimit/4+1, maxLimit/2);
        SumUpExample sumup3 = new SumUpExample(maxLimit/2+1, 3*maxLimit/4);
        SumUpExample sumup4 = new SumUpExample( 3*maxLimit/4+1, maxLimit );
        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread( () -> {
           sumup1.add( );
        } );

        Thread t2 = new Thread( () -> {
            sumup2.add();
        } );
        Thread t3 = new Thread( () -> {
            sumup3.add();
        } );
        Thread t4 = new Thread( () -> {
            sumup4.add();
        } );
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        
        long timeEnd = System.currentTimeMillis();
        System.out.println( "Total :" + total + ", Time Taken: " + ( timeEnd - timeStart ) );
    }
    
    public static void runTests() throws InterruptedException
    {
        oneThread();
        twoThreads();
        fourThreads();
    }
}
