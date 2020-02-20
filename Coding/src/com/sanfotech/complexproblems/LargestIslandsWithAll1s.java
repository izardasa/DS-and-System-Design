package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestIslandsWithAll1s
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int r = s.nextInt();
        int c = s.nextInt();

        int[][] A = new int[ r ][ c ];

        for( int i = 0; i < r; i++ )
        {
            for( int j = 0; j < c; j++ )
            {
                A[i][j] = s.nextInt();
            }
        }

        int n = getLargestIsland( A );
        System.out.println( n );

    }

    private static int getLargestIsland( int[][] A )
    {
        boolean[][] visited = new boolean[ A.length ][ A[0].length ];
        int islandSize = 0;
        int largestIslandSize = 0;
        for( int i = 0; i < A.length; i++ )
        {
            for( int j = 0; j < A[0].length; j++ )
            {
                if( isSafe( i, j, A, visited ) )
                {

                    islandSize = dsf( A, visited, i, j );
                }

                if( islandSize > largestIslandSize )
                    largestIslandSize = islandSize;

            }

        }

        return largestIslandSize;
    }

    private static boolean isSafe( int r, int c, int[][] A, boolean[][] visited )
    {
        if( r < 0 || c < 0 || r >= A.length || c >= A[0].length || visited[r][c] || A[r][c] == 0 )
            return false;
        return true;
    }

    private static int dsf( int[][] A, boolean[][] visited, int row, int col )
    {

        visited[row][col] = true;

        int size = 1;

        ArrayList<Integer[]> neighbours = getNeighbours( A, row, col );

        for( Integer[] n : neighbours )
        {
            if( isSafe( n[0], n[1], A, visited ) )
                size += dsf( A, visited, n[0], n[1] );
        }

        return size;
    }

    private static ArrayList<Integer[]> getNeighbours( int[][] A, int row, int col )
    {
        ArrayList<Integer[]> neighbours = new ArrayList<Integer[]>();
        neighbours.add( new Integer[]{ row + 1, col + 1 } );
        neighbours.add( new Integer[]{ row, col + 1 } );
        neighbours.add( new Integer[]{ row + 1, col } );
        neighbours.add( new Integer[]{ row - 1, col - 1 } );
        neighbours.add( new Integer[]{ row, col - 1 } );
        neighbours.add( new Integer[]{ row - 1, col } );
        neighbours.add( new Integer[]{ row + 1, col - 1 } );
        neighbours.add( new Integer[]{ row - 1, col + 1 } );

        return neighbours;
    }

}
