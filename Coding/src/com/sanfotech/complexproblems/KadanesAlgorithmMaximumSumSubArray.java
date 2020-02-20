package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class KadanesAlgorithmMaximumSumSubArray
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int[] nums = new int[ n ];
        for( int i = 0; i < n; i++ )
        {
            nums[i] = s.nextInt();
        }

        int maxSoFar = 0;
        int maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int st = 0;
        for( int i = 0; i < n; i++ )
        {
            maxEndingHere += nums[i];

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

        System.out.println( maxSoFar+" "+start+" "+end );
    }

}
