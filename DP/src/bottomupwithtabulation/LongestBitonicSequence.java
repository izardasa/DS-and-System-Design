package bottomupwithtabulation;

import java.util.Arrays;

public class LongestBitonicSequence
{

    public static int LBSlength( int[] A )
    {
        int n = A.length;
        int[] lis1 = new int[ n ];
        int[] lis2 = new int[ n ];

        Arrays.fill( lis1, 1 );
        Arrays.fill( lis2, 1 );
        for( int i = 1; i < n; i++ )
        {
            for(int j=0;j<i;j++)
            {
            if( A[i] > A[j] && lis1[i] < lis1[j] + 1 )
                lis1[i] = lis1[j] + 1;
            }
        }

        for( int i = n - 2; i > 0; i-- )
        {
            for(int j=n-1;j>i;j--)
            {
            if( A[i] > A[j] && lis2[i] < lis2[j] + 1 )
                lis2[i] = lis2[j] + 1;
            }
        }

        int max = -1;
        for( int i = 0; i < n; i++ )
        {
            if( max < lis1[i] + lis2[i] )
                max = lis1[i] + lis2[i];
        }
        return max-1;

    }

    public static void main( String[] args )
    {

        System.out.println( LBSlength( new int[] {4,2,5,9,7,6,10,3,1} ) );
        System.out.println( LBSlength( new int[] {4,2,3,6,10,1,12} ) );
    }

}
