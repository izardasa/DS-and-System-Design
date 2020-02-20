package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfIslands
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int r = s.nextInt();
        int c = s.nextInt();
        
        int[][] A = new int[r][c];
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                A[i][j] = s.nextInt();
            }
        }
        
        int n = getNumberOfIslands(A);
        System.out.println( n );
        
    }

    private static int getNumberOfIslands( int[][] A )
    {
        int countIslands = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                if(A[i][j]==1 &&  !visited[i][j])
                {
                    countIslands++;
                    dsf(A,visited, i, j);
                }
            }

        }
        
        return countIslands;
    }

    private static void dsf( int[][] A, boolean[][] visited, int row, int col )
    {
        if(row< 0 || col<0 || row>=A.length || col >= A[0].length || visited[row][col] || A[row][col]==0)
            return;
        
        visited[row][col] = true;
        
        ArrayList<Integer[]> neighbours = getNeighbours(A, row, col);
        
        for(Integer[] n: neighbours)
        {
            dsf(A, visited, n[0],n[1]);
        }
    }

    private static ArrayList<Integer[]> getNeighbours( int[][] A, int row, int col )
    {
         ArrayList<Integer[]> neighbours = new ArrayList<Integer[]>();
         neighbours.add( new Integer[] {row+1,col+1} );
         neighbours.add( new Integer[] {row,col+1} );
         neighbours.add( new Integer[] {row+1,col} );
         neighbours.add( new Integer[] {row-1,col-1} );
         neighbours.add( new Integer[] {row,col-1} );
         neighbours.add( new Integer[] {row-1,col} );
         neighbours.add( new Integer[] {row+1,col-1} );
         neighbours.add( new Integer[] {row-1,col+1} );
         
         return neighbours;
    }
    
    

}
