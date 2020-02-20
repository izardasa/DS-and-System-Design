import java.util.HashMap;
import java.util.Scanner;

public class DominatedSubArray
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while( t-- > 0 )
        {
            int n = s.nextInt();
            int[] A = new int[ n ];

            for( int i = 0; i < n; i++ )
                A[i] = s.nextInt();

            System.out.println( shortestDominatedArray( A, n ) );
        }
    }

    private static int shortestDominatedArray( int[] A, int n )
    {
        if( n == 1 )
            return -1;

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int minDist = Integer.MAX_VALUE;
        for( int i = 0; i < n; i++ )
        {
            if( !map.containsKey( A[i] ) )
            {
                map.put( A[i], i + "_" + Integer.MAX_VALUE );
            }
            else
            {
                String[] value = map.get( A[i] ).split( "_" );
                int index = Integer.parseInt( value[0] );
                int dist = Integer.parseInt( value[1] );

                if( dist > i - index )
                    dist = i - index;

                String val = i + "_" + dist;
                map.put( A[i], val );

                if( dist < minDist )
                    minDist = dist;
            }
        }

        if( minDist == Integer.MAX_VALUE )
            minDist = -1;
        else
            minDist = minDist + 1;

        return minDist;

    }

}
