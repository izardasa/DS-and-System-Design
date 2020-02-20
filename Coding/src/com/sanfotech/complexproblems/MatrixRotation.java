package com.sanfotech.complexproblems;

import java.util.Scanner;

public class MatrixRotation
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] A = new int[N][N];
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                A[i][j] = s.nextInt();
            }
        }
        
        rotateMatrixAntiClockwise(A,N);
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print( A[i][j]+ " " );
            }
            System.out.println(  );
        }

    }

    private static void rotateMatrixClockwise( int[][] A, int N )
    {
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N/2;j++)
            {
                int temp = A[i][j];
                A[i][j] = A[i][N-1-j];
                A[i][N-1-j] = temp;
            }
        }
    }

    private static void rotateMatrixAntiClockwise( int[][] A, int N )
    {
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        
        for(int i=0;i<N/2;i++)
        {
            for(int j=0;j<N;j++)
            {
                int temp = A[i][j];
                A[i][j] = A[N-1-i][j];
                A[N-1-i][j] = temp;
            }
        }
    }
}

