package bottomupwithtabulation;

import java.util.Scanner;

public class AssemblyLineScheduling
{

    public static void main( String[] args )
    {
        int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
        int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
        int e[] = { 10, 12 }, x[] = { 18, 7 };
       System.out.println( getMinTimeToBuildCar( e, x, a, t, a[0].length ) ); 
    }

    private static int getMinTimeToBuildCar( int[] e, int[] x, int[][] a, int[][] t, int noOfStations )
    {
        int[] T1 = new int[ noOfStations ];
        int[] T2 = new int[ noOfStations ];

        T1[0] = e[0] + a[0][0];
        T2[0] = e[1] + a[1][0];

        for( int i = 1; i < noOfStations; i++ )
        {
            T1[i] = Math.min( a[0][i] + T1[i - 1], a[0][i] + T2[i - 1] + t[1][i] );
            T2[i] = Math.min( a[1][i] + T2[i - 1], a[1][i] + T1[i - 1] + t[0][i] );
        }

        return Math.min( T1[noOfStations - 1] + x[0], T2[noOfStations - 1] + x[1] );
    }

}
