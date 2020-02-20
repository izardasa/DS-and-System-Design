package com.sanfotech.stringsearch;

import java.util.Set;

public class Trie {

	TrieNode root = new TrieNode();
	
	public void insert(String word)
	{
		TrieNode temp = root;
		int n = word.length();
		
		for (int i = 0; i < n; i++) 
		{
			Character ch = word.charAt(i);
			TrieNode child = temp.children.get(ch);
			
			if(null==child)
			{
				TrieNode node = new TrieNode();
				temp.children.put(ch, node);
				temp= node;
			}
			else
			{
				temp = child;
			}
		}
		
		temp.children.put('*', null);
		
	}
	
	public boolean contains(String word)
	{
		TrieNode temp = root;
		int n = word.length();
		for (int i = 0; i < n; i++) 
		{
			Character ch = word.charAt(i);
			TrieNode children = temp.children.get(ch);
			if(null==children)
				return false;
			
			temp =children;
		}
		
		Set<Character> keys = temp.children.keySet();
		for(Character key: keys)
			if(key=='*')
				return true;
		
		return false;
	}
	

	public boolean containsWithoutEndCheck(String word)
	{
		TrieNode temp = root;
		int n = word.length();
		for (int i = 0; i < n; i++) 
		{
			Character ch = word.charAt(i);
			TrieNode children = temp.children.get(ch);
			if(null==children)
				return false;
			
			temp =children;
		}
		
		
		return true;
	}

	
	public void createSuffixTrie(String word)
	{
		int n = word.length();
		for (int i = 0; i < n; i++) 
		{
			insert(word.substring(i));
		}
	}
	
	public void createPrefixTrie(String word)
	{
		int n = word.length();
		for (int i = 0; i < n; i++) 
		{
			insert(word.substring(0,i+1));
		}
	}
	
}
