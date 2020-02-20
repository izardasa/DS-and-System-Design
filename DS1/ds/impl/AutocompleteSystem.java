package ds.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem
{
    
      
    Trie1 trie;
    private static List<String> result;
    public AutocompleteSystem(String[] sentences, int[] times)
    {
        trie = new Trie1();
        for(int i=0;i<times.length;i++)
        {
            trie.insertWord( sentences[i], times[i] );
        }
    }
    
    public List<String> input(char c)
    {
        return trie.findWordsByFrequency( trie.input( c ),3);
    }
    
    public static void main(String[] args)
    {
        String[] sentences = new String[] {"i love you","island","ironman","i love leetcode"};
        int[] times = new int[] {5,3,2,2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        
        
        for(String word: autocompleteSystem.input( 'i' ))
            System.out.println( word );
        
        System.out.println( "--------" );
        for(String word: autocompleteSystem.input( ' ' ))
            System.out.println( word );
        
        System.out.println( "--------" );
        for(String word: autocompleteSystem.input( 'a' ))
            System.out.println( word );
        
        System.out.println( "--------" );
        for(String word: autocompleteSystem.input( '#' ))
            System.out.println( word );
    }
}
class TrieNode
{
    char c;
    TrieNode[] children;
    boolean endOfSring;
    int totalCount;

    public TrieNode()
    {
        children = new TrieNode[ 27 ];
    }

}

class Trie1
{
    private TrieNode root;
    private static String wordsToSearch = "";
    private HashMap<String, Integer> wordFreuency;

   

    public Trie1()
    {
        root = new TrieNode();
        wordFreuency = new HashMap<String, Integer>();
    }

    public void insertWord( String word, int frequency )
    {
        TrieNode branch = root;
        for( int i = 0; i < word.length(); i++ )
        {
            char c = word.charAt( i );
            int charIndex = charIndex( c );
            if( branch.children[charIndex] == null )
            {
                branch.children[charIndex] = new TrieNode();
            }
            branch = branch.children[charIndex];
            branch.c = c;
        }

        branch.endOfSring = true;
        branch.totalCount += frequency;

        wordFreuency.put( word, branch.totalCount );
    }

    public List<String> findAllWords()
    {
        List<String> result = new ArrayList<String>();
        findWordsHelper( root, result, "" );
        return result;
    }

    public void findWordsHelper( TrieNode node, List<String> words, String word )
    {
        if( node == null )
            return;
        if( node.endOfSring )
        {
            words.add( word.toString() );
        }

        for( int i = 0; i <= 26; i++ )
        {
            if( node.children[i] != null )
            {
                char currentChar = node.children[i].c;
                findWordsHelper( node.children[i], words, word + currentChar );
            }
        }

    }

    public List<String> findWordsByFrequency( List<String> words, int n )
    {
        PriorityQueue<String> maxHeap =
            new PriorityQueue<>( ( a, b ) -> wordFreuency.get( b ) - wordFreuency.get( a ) );

        for( String word : words )
            maxHeap.add( word );
        List<String> result = new ArrayList<String>();
        int count = 0;
        while( !maxHeap.isEmpty() )
        {
            result.add( maxHeap.remove() );
            if( ++count == n )
                break;
        }

        return result;
    }

    public List<String> input( char ch )
    {
        List<String> result = new ArrayList<String>();

        if( ch == '#' )
        {
            insertWord( wordsToSearch, 1 );
            return result;
        }
        else
            wordsToSearch += ch;

        TrieNode temp = root;
        for( int i = 0; i < wordsToSearch.length(); i++ )
        {

            temp = temp.children[charIndex( wordsToSearch.charAt( i ) )];
            if( temp == null )
                break;
        }

        if( temp == null )
            return result;

        if( ch == '#' )
            wordsToSearch = "";
        findWordsHelper( temp, result, wordsToSearch );

        return result;

    }

    private int charIndex( char ch )
    {
        return ch == ' ' ? 26 : ch - 'a';
    }

}