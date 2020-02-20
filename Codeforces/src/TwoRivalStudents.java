import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TwoRivalStudents
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while( t-- > 0 )
        {
            int n = s.nextInt();
            int x = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();

            System.out.println( getMaxDistance( n, x, a, b ) );
        }
    }

    private static int getMaxDistance( int n, int x, int a, int b )
    {

        int max = Math.max( a, b );
        int min = Math.min( a, b );

        int extra = 0;

        max = max+x;
        if(max>n)
        {
            extra = max-n;
            max = n;
        }

        
        min -= extra;
        if( min < 1 )
            min = 1;

        return max - min;
    }

}
