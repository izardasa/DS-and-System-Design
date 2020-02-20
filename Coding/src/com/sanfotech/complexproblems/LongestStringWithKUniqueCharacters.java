package com.sanfotech.complexproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestStringWithKUniqueCharacters
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        String res = findLongestStringWithKUniqueCharacters(s.next(), s.nextInt());
        System.out.println( res );
    }
    
    private static boolean isGreaterThanKUniqueCharacters(int[] chars, int k)
    {
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(chars[i]>0)
                count++;
        }
        
        return count>k;
    }

    private static String findLongestStringWithKUniqueCharacters( String str, Integer k )
    {
       char[] chars = str.toCharArray();
       int[] map = new int[26];
       int start =0;
       int end =0;
       int longestLength =0;
       int si=0;
       int ei=0;
       Arrays.fill( map, 0 );
       while(end<chars.length)
       {
           int c = chars[end++]-'a';
           map[c]++;
           while(isGreaterThanKUniqueCharacters( map, k ))
           {
               map[chars[start++]-'a']--;
           }
           
           if(longestLength<end-start)
           {
               ei= end;
               si=start;
               longestLength = end-start;
           }
       }
       
       return str.substring( si,ei );
    }

}

