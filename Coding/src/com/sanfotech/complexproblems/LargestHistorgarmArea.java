package com.sanfotech.complexproblems;

import java.util.Scanner;
import java.util.Stack;

public class LargestHistorgarmArea
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int[] nums = new int[ n ];
        for( int i = 0; i < n; i++ )
            nums[i] = s.nextInt();

        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int top = -1;
        int area = 0;
        for( i = 0; i < n; )
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
        System.out.println( maxArea );
    }

}
