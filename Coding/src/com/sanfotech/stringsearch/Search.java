package com.sanfotech.stringsearch;

import java.util.ArrayList;

public class Search {

	
	public static void main(String[] args) {
		Trie trie = new Trie();
//		trie.insert("sanjay");
//		trie.insert("sunil");
//		trie.insert("amit");
//		trie.insert("sahil");
//		trie.insert("bhola");
//		trie.insert("bhanu");
//		trie.insert("akash");
//		trie.insert("akshay");
	
		trie.createSuffixTrie("this is a big string");
		ArrayList<String> listString  = new ArrayList<>();
		listString.add("this");
		listString.add("yo");
		listString.add("is");
		listString.add("a");
		listString.add("bigger");
		listString.add("string");
		listString.add("kappa");
		
		
		
		for(String word : listString)
		{
			System.out.println(word +" Found : "+trie.containsWithoutEndCheck(word));
		}
		

	}

}
