package com.sanfotech.stringsearch;

import java.util.HashMap;

public class LongestSubstringWithoutDuplicates
{

    public static String longestSubstring( String S )
    {
        int n = S.length();
        int startIndex = 0;
        int[] longest = { 0, 1 };
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for( int i = 0; i < n; i++ )
        {
            Character ch = S.charAt( i );

            if( indexMap.get( ch ) != null )
            {
                startIndex = Math.max( startIndex, indexMap.get( ch ) + 1 );

            }

            if( longest[1] - longest[0] < i + 1 - startIndex )
            {
                longest[1] = i + 1;
                longest[0] = startIndex;
            }

            indexMap.put( ch, i );
        }
        return S.substring( longest[0], longest[1] );
    }

    public static void main( String[] args )
    {
        System.out.println( longestSubstring( "clementisacap" ) );

    }

}
