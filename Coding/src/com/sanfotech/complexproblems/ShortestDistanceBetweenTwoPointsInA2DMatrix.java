package com.sanfotech.complexproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestDistanceBetweenTwoPointsInA2DMatrix
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c= s.nextInt();
        String[][] A = new String[r][c];
        
        int sRow=0;
        int sCol=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                A[i][j] = s.next();
                if(A[i][j]=="S")
                {
                    sRow = i;
                    sCol = j;
                }
                
            }
        }
        
        int shortestDistance = findShortestDistanceInMatrix(A, sRow, sCol);
        System.err.println( shortestDistance );
    }

    private static int findShortestDistanceInMatrix( String[][] A, int sRow, int sCol )
    {
       Queue<Point> queue = new LinkedList<Point>();
       boolean[][] visited = new boolean[A.length][A[0].length];
       queue.add( new Point(sRow,sCol, 0) );
       
       while(!queue.isEmpty())
       {
           Point temp = queue.remove();
           int r =temp.row;
           int c = temp.col;
           int d = temp.distance;
           if(A[r][c].equals( "D"))
               return d;
           
           if(r-1>=0 && !visited[r-1][c] && A[r-1][c]!="0")
           {
               queue.add(  new Point(r-1,c,d+1) );
               visited[r-1][c] = true;
           }
          
           if(c-1>=0 && !visited[r][c-1] && A[r][c-1]!="0")
           {
               queue.add(  new Point(r,c-1,d+1) );
               visited[r][c-1] = true;
           }
           
           if(c+1<A[0].length && !visited[r][c+1] && A[r][c+1]!="0")
           {
               queue.add( new Point(r,c+1,d+1) );
               visited[r][c+1] = true;
           }
           
           if(r+1<A.length && !visited[r+1][c] && A[r+1][c]!="0" )
           {
               queue.add(  new Point(r+1,c, d+1) );
               visited[r+1][c] = true;
           }
       }
  
       return -1;
    }

  
        
}
class Point
{
    int row;
    int col;
    int distance;
    public Point( int row, int col, int distance )
    {
        super();
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
    
    
}