package com.sanfotech.complexproblems;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleWithAll1s
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int r = s.nextInt();
        int c = s.nextInt();
        int[][] A = new int[ r ][ c ];
        int[] histogram = new int[ c ];
        int maxRectangleSize = 0;
        for( int i = 0; i < r; i++ )
        {

            for( int j = 0; j < c; j++ )
            {
                A[i][j] = s.nextInt();
                if( A[i][j] == 0 )
                    histogram[j] = 0;
                else
                    histogram[j] += A[i][j];

            }

            int histogramSize = maxHistogramSize( histogram );
            if( histogramSize > maxRectangleSize )
                maxRectangleSize = histogramSize;

        }

        System.out.println( maxRectangleSize );
    }

    private static int maxHistogramSize( int[] nums )
    {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int top = -1;
        int area = 0;
        for( i = 0; i < nums.length; )
        {
            if( stack.isEmpty() || nums[stack.peek()] <= nums[i] )
            {
                stack.push( i );
                i++;
            }
            else
            {
                top = stack.pop();

                if( stack.isEmpty() )
                {
                    area = nums[top] * i;
                }
                else
                {
                    area = nums[top] * ( i - stack.peek() - 1 );
                }

                if( area > maxArea )
                    maxArea = area;
            }
        }

        while( !stack.isEmpty() )
        {
            top = stack.pop();
            if( stack.isEmpty() )
            {
                area = nums[top] * i;
            }
            else
            {
                area = nums[top] * ( i - stack.peek() - 1 );
            }

            if( area > maxArea )
                maxArea = area;

        }
        return maxArea;
    }

}
