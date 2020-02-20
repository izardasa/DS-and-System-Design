package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class ReachFromSourceToDestination
{

    public static void main( String[] args )
    {

        Scanner s = new Scanner( System.in );

        int row = s.nextInt();
        int col = s.nextInt();

        int[][] A = new int[ row ][ col ];

        for( int i = 0; i < row; i++ )
        {
            for( int j = 0; j < col; j++ )
            {
                A[i][j] = s.nextInt();
            }
        }

        System.out.println( floodFill( A, 0, 0, row-1, col-1 ) ?"YES":"NO");

    }

    private static boolean floodFill( int[][] A, int r, int c, int dest_x, int dest_y )
    {
        int color = A[r][c];
        boolean[][] visited = new boolean[ A.length ][ A[0].length ];
        return floodFillHelper( A, r, c, dest_x, dest_y, color, visited );

    }

    private static boolean floodFillHelper( int[][] A, int r, int c, int dest_x, int dest_y, int color,
        boolean[][] visited )
    {
        if( r == dest_x && c == dest_y )
            return true;

        if( r < 0 || r >= A.length )
            return false;

        if( c < 0 || c >= A[0].length )
            return false;
        if( visited[r][c] )
            return false;
        int cellColr = A[r][c];
        if( cellColr != color )
            return false;

        visited[r][c] = true;

        if( floodFillHelper( A, r - 1, c, dest_x, dest_y, color, visited ) )
            return true;

        if( floodFillHelper( A, r, c - 1, dest_x, dest_y, color, visited ) )
            return true;
        if( floodFillHelper( A, r, c + 1, dest_x, dest_y, color, visited ) )
            return true;
        if( floodFillHelper( A, r + 1, c, dest_x, dest_y, color, visited ) )
            return true;
        
        return false;

    }

    private static ArrayList<Integer[]> getNeighbours( int[][] a, int r, int c )
    {
        ArrayList<Integer[]> neighbours = new ArrayList<Integer[]>();
        neighbours.add( new Integer[]{ r - 1, c } );
        neighbours.add( new Integer[]{ r, c - 1 } );
        neighbours.add( new Integer[]{ r, c + 1 } );
        neighbours.add( new Integer[]{ r + 1, c } );
        return neighbours;

    }

}
