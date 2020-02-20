package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class FloodFill
{

    public static void main( String[] args )
    {
        
        Scanner s = new Scanner(System.in);
        
        int row = s.nextInt();
        int col = s.nextInt();
        
        int[][] A = new int[row][col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                A[i][j] = s.nextInt();
            }
        }
        
        floodFill(A, 4,4, 3);
        
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print( A[i][j]+" " );
            }
            System.out.println(  );
        }
    }

    private static void floodFill( int[][] A, int r, int c, int newColor )
    {
     int color = A[r][c];
     floodFillHelper(A,r,c,color, newColor);
        
        
    }

    private static void floodFillHelper( int[][] A, int r, int c, int color, int newColor )
    {
        if(r<0 || r>=A.length)
            return;
        
        if(c<0 || c>=A[0].length)
            return;
        
        int cellColr = A[r][c];
        if(cellColr!=color)
            return;
        
        A[r][c] = newColor;
        
        ArrayList<Integer[]> neighbours = getNeighbours(A,r,c);
        for(int i=0;i<neighbours.size();i++)
        {
            floodFillHelper( A, neighbours.get( i )[0], neighbours.get( i )[1], color, newColor );
        }
        
    }

    private static ArrayList<Integer[]> getNeighbours( int[][] a, int r, int c )
    {
        ArrayList<Integer[]> neighbours = new ArrayList<Integer[]>();
        neighbours.add(new Integer[] {r-1,c-1} );
        neighbours.add(new Integer[] {r-1,c} );
        neighbours.add(new Integer[] {r,c-1} );
        neighbours.add(new Integer[] {r+1,c+1} );
        neighbours.add(new Integer[] {r,c+1} );
        neighbours.add(new Integer[] {r+1,c} );
        neighbours.add(new Integer[] {r+1,c-1} );
        neighbours.add(new Integer[] {r-1,c+1} );
        return neighbours;
        
        
    }

}
