import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BarsuBall
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int[] boys = new int[ n ];

        for( int i = 0; i < n; i++ )
            boys[i] = s.nextInt();

        int m = s.nextInt();
        int[] girls = new int[ m ];
        for( int i = 0; i < m; i++ )
            girls[i] = s.nextInt();

        int pair = 0;
        Arrays.sort( boys );
        Arrays.sort( girls );

        int i = 0, j = 0;
        while( i < boys.length && j < girls.length )
        {
            int diff = Math.abs( boys[i] - girls[j] );
            if( diff <= 1 )
            {
                i++;
                j++;
                pair++;
            }
            else if( boys[i] < girls[j] )
                i++;
            else
                j++;
        }
        
        System.out.println( pair );
    }

}
