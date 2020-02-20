import java.util.HashMap;
import java.util.Scanner;

public class SillyMistake
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while( t-- > 0 )
        {
            int n = s.nextInt();
            int[] a = new int[ n ];
            int[] b = new int[ n ];

            for( int i = 0; i < n; i++ )
                a[i] = s.nextInt();

            for( int i = 0; i < n; i++ )
                b[i] = s.nextInt();

            System.out.println( isValidPush( a, b, n ) );
        }

    }

    private static String isValidPush( int[] a, int[] b, int n )
    {
        int count = 0;
        int preDiff = 0;
        for( int i = 0; i < n; i++ )
        {
            int diff = b[i] - a[i];
            if( diff < 0 )
            {
                return "NO";
            }

            if( diff != preDiff && diff != 0 )
            {
                count++;
                preDiff = diff;
            }
            else if( diff != preDiff && diff == 0 )
            {
                preDiff = diff;
            }

        }

        if( count <= 1 )
            return "YES";
        else
            return "NO";
    }

}
