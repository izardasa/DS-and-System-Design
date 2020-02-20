package com.sanfotech.complexproblems;

import java.util.Scanner;

public class MaximumSumSubquareMatrix
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c= s.nextInt();
        int[][] A = new int[r][c];
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                A[i][j] = s.nextInt();
            }
        }
        
        int left = 0;
        int right=0;
        int top = 0;
        int bottom =0;
        int maxSum=0;
        for(int i=0;i<c;i++)
        {
            int[] colValue = new int[r];
            for(int j=i;j<c;j++)
            {
                
                for(int k=0;k<r;k++)
                {
                    colValue[k]+=A[k][j];
                }
                int[]  res = kadane( colValue );
                if(maxSum<res[2])
                {
                    left=i;
                    right = j;
                    top = res[0];
                    bottom = res[1];
                    maxSum = res[2];
                    
                }
            }
        }
        
        System.out.println( maxSum+ " "+left+" "+top+ " "+right+" "+bottom );
        
        
    }
    
    public static int[] kadane(int[] A)
    {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int st = 0;
        for( int i = 0; i < A.length; i++ )
        {
            maxEndingHere += A[i];

            if( maxEndingHere > maxSoFar )
            {
                maxSoFar = maxEndingHere;
                start =st;
                end = i;
            }
            
            if(maxEndingHere<0)
            {
                maxEndingHere = 0;
                st = i+1;
            }
            
        }
        
        return new int[] {start, end, maxSoFar};

    }

}
