import java.util.Scanner;

public class EpicGame
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int a = s.nextInt();
        int b = s.nextInt();
        int heap = s.nextInt();

        int count = 0;
        while( heap > 0 )
        {
            if( count % 2 == 0 )
                heap -= findGCD( a, heap );
            else
                heap -= findGCD( b, heap );
            count++;
        }
        if( count % 2 != 0 )
            System.out.println( 0 );
        else
            System.out.println( 1 );
    }

    private static int findGCD( int a, int b )
    {
        if( a == 0 )
            return b;

        if( b == 0 )
            return a;
        int greater = a > b ? a : b;
        int smaller = a == greater ? b : a;

        return findGCD( greater % smaller, smaller );
    }

}
