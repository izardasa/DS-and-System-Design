package ds.model;


public class TrieNode {
	public boolean isEndOfString;
	public TrieNode[] children ;
	private final int ALPAHBET_SIZE=26;
	
	public TrieNode(){
		children = new TrieNode[ALPAHBET_SIZE];
		for(int i=0;i<ALPAHBET_SIZE;i++)
		{
			children[i]=null;
		}
		isEndOfString = false;
	}
}
