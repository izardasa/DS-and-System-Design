package com.sanfotech.complexproblems;

import java.util.Scanner;
import java.util.Stack;

public class MaximumSubSquareMatrix
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
        
        int[][] dp = new int[r+1][c+1];
        int maxSqaure = -1;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(A[i][j]==1)
                {
                    dp[i+1][j+1]=Math.min( Math.min( dp[i][j],dp[i][j+1] ),dp[i+1][j])+1;
                    if(maxSqaure<dp[i+1][j+1])
                        maxSqaure = dp[i+1][j+1];
                }
            }
        }
        System.out.println( maxSqaure );
    }

}
