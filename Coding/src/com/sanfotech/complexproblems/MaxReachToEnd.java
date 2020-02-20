package com.sanfotech.complexproblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaxReachToEnd
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int[] jumps = new int[ n ];
        for( int i = 0; i < n; i++ )
            jumps[i] = s.nextInt();

        int[] minJumps = new int[ n ];
        int[] path = new int[ n ];

        Arrays.fill( minJumps, Integer.MAX_VALUE );
        minJumps[0] = 0;
        for( int i = 1; i < n; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( j + jumps[j] >= i && minJumps[i] > minJumps[j] + 1 )
                {
                    minJumps[i] = minJumps[j] + 1;
                    path[i] = j;
                }

            }
        }

        for( int i = 0; i < n; i++ )
        {
            System.out.print( minJumps[i] + " " );
        }
        System.out.println();
        for( int i = 0; i < n; i++ )
        {
            System.out.print( path[i] + " " );
        }
        
        System.out.println(  );
        StringBuilder sb = new StringBuilder();
        int index=path[n-1];
        while(index!=0)
        {
            sb.append( index+ " " );
            index = path[index];
        }
        sb.append( 0 );
        
        System.out.println( sb.reverse() );
    }

}
