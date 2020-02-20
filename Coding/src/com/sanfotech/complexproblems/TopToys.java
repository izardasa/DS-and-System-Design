package com.sanfotech.complexproblems;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.PriorityQueue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class TopToys
{
    public static void main(String[] args)
    {
        TopToys tt = new TopToys();
        List<String> toys = new ArrayList<String>();
        toys.add( "anacell" );
        toys.add( "betacellular" );
        toys.add( "centracular" );
        toys.add( "deltacellular" );
        toys.add( "eurocell" );
        List<String> quotes = new ArrayList<String>();
        quotes.add( "I love anacell best services by anacell in the town " );
        quotes.add( "betacellular has great services " );
        quotes.add( "deltacellular provides much better services than betacellular " );
        quotes.add( "centracular is worse than eurocell " );
        quotes.add( "betacellular is better than deltacellular " );
        System.out.println(  tt.popularNToys( 5, 2, toys, 5, quotes ) );
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys( int numToys, int topToys, List<String> toys, int numQuotes,
        List<String> quotes )
    {

        Set<String> set = new HashSet<String>();
        for( int i = 0; i < numToys; i++ )
        {
            set.add( toys.get( i ) );
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for( String quote : quotes )
        {
            StringBuilder sb = new StringBuilder();
            HashSet<String> wordInQuotes = new HashSet<String>();
            for(int i=0;i<quote.length();i++)
            {
                char c = quote.charAt(i);
                if(Character.isLetter(c))
                {
                    sb.append(Character.toLowerCase(c));
                }
                
                if(!Character.isLetter(c) || i==quote.length())
                {
                    String word = sb.toString();
                    if(set.contains(word) && !wordInQuotes.contains(word))
                    {
                        System.out.print( word+" " );
                        map.put(word, map.getOrDefault(word,0)+1);
                        wordInQuotes.add(word);
                    }
                    sb = new StringBuilder();
                }
            }
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<String>( ( a, b ) -> map.get( b ) - map.get( a ) );
        for( String key : map.keySet() )
            maxHeap.add( key );

        ArrayList<String> listOfToys = new ArrayList<String>();

        int count = 0;
        while( !maxHeap.isEmpty() )
        {
            if( count == topToys )
                break;
            listOfToys.add( maxHeap.remove() );
            count++;
        }

        return listOfToys;
    }
    // METHOD SIGNATURE ENDS
}
