package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class FloorSqrt
{

    public static void main( String[] args )
    {

        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        
        if(n==0 || n==1)
        {
            System.out.println( n );
            return;
        }
        int start =0;
        int end = n;
        int ans=0;
        while(start<=end)
        {
            int mid = (start+end)/2;
            
            if(mid*mid==n)
            {
                ans = mid;
                break;
            }
            
            if(mid*mid<n)
            {
                start = mid+1;
                ans =mid;
            }
            else
            {
                end = mid-1;
            }
        }
        
        System.out.println( ans );
        
        
    }
}
