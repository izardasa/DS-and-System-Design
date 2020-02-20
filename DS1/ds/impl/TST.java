package ds.impl;

import java.util.ArrayList;

import ds.model.TSTNode;

public class TST {

	private TSTNode root;
	private ArrayList<String> al;
	public TST() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}
	
	public void insert(String word)
	{
		root= insert(root, word,0);
	}

	public TSTNode insert(TSTNode root, String word, int index) {
		if (root == null)
			root = new TSTNode(word.charAt(index));

		if (word.charAt(index) > root.getData())
			root.setRight(insert(root.getRight(), word, index));
		else if (word.charAt(index) < root.getData())
			root.setLeft(insert(root.getLeft(), word, index));
		else {
			if (index + 1 < word.length()) {
				root.setEqual(insert(root.getEqual(), word, index + 1));
			} else {
				root.setEndOfString(true);
			}
		}

		return root;

	}
	
	private void delete(TSTNode root, char[] word, int index)
	{
		if(root==null)
			return;
		
		if(word[index]>root.getData())
			delete(root.getRight(),word,index);
		else if(word[index]<root.getData())
			delete(root.getLeft(),word,index);
		else 
		{
			if(root.isEndOfString() && index==word.length-1)
			{
				root.setEndOfString(false);
			}
			else if(index+1<word.length)
			{
				delete(root.getEqual(),word,index+1);
			}
		}
	}
	
	public void delete(String word)
	{
		delete(root,word.toCharArray(),0);
	}
	
	private boolean search(TSTNode root, char[] word, int index)
	{
		if(root==null)
			return false;
		
		if(word[index]>root.getData())
			return search(root.getRight(), word, index);
		else if(word[index]<root.getData())
			return search(root.getLeft(), word, index);
		else
		{
			if(index==word.length-1 && root.isEndOfString())
				return true;
			else if(index==word.length-1)
				return false;
			else
				return search(root.getEqual(), word, index+1);
		}
	}
	
	public boolean search(String word)
	{
		return search(root, word.toCharArray(), 0);
	}
	
	public String toString(){
		 al = new ArrayList<String>();
		 traverse(root,"");
		 return "Ternary Search Tree :"+al;
		
	}

	private void traverse(TSTNode root, String str) {
		if(root!=null)
		{
			traverse(root.getLeft(),str);
			
			str = str+root.getData();
			if(root.isEndOfString())
				al.add(str);
			
			traverse(root.getEqual(),str);
			str = str.substring(0,str.length()-1);
			traverse(root.getRight(),str);
		}
		
		
		
	}
	
	public static int lengthOfLargestString(TSTNode root)
	{
		if(root==null)
			return 0;
		return Integer.max(Integer.max(lengthOfLargestString(root.getLeft()), lengthOfLargestString(root.getRight())),lengthOfLargestString(root.getEqual())+1 );
	}
}
