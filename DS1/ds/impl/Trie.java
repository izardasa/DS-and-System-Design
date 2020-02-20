package ds.impl;

import ds.model.TrieNode;

public class Trie {
	public static TrieNode root= new TrieNode();
	

	public static void insert(String key)
	{
		int level =0;
		int length = key.length();
		TrieNode pCrawl = root;
		for(level=0;level<length;level++)
		{
			int index = key.charAt(level)-'a';
			if(pCrawl.children[index]==null)
			{
				pCrawl.children[index]=new TrieNode();
				
			}
			
			pCrawl = pCrawl.children[index];
		}
		
		pCrawl.isEndOfString = true;
	}
	
	public static boolean search(String key)
	{
		int level=0;
		int length = key.length();
		TrieNode pCrawl = root;
		
		for(level=0;level<length;level++)
		{
			int index = key.charAt(level)-'a';
			if(pCrawl.children[index]==null)
				return false;
			
			pCrawl = pCrawl.children[index];
		}
		if(pCrawl!=null && pCrawl.isEndOfString)
			return true;
		
		return false;
	}
}
