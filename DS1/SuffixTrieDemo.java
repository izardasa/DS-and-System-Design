import java.util.HashMap;

public class SuffixTrieDemo {
	
	static class TrieNode
	{
		HashMap<Character, TrieNode> children = new HashMap<>();
	}
	
	static class SuffixTrie
	{
		TrieNode root = new TrieNode();
		Character endCharacter  ='*';
		void populateSuffixTrie(String str)
		{
			int n = str.length();
			for (int i = 0; i < n; i++) {
				populateSuffixTrieHelper(i, str);
			}
			
		}
		public void populateSuffixTrieHelper(int i, String str) {
			TrieNode node = root;
			for (int j = i; j < str.length(); j++) {
				Character letter = str.charAt(j);
				if(!node.children.containsKey(letter))
				{
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
				}
				
				node = node.children.get(letter);
			}
			node.children.put(endCharacter, null);
		}
		
		public boolean contains(String str)
		{
			int n = str.length();
			TrieNode node =root;
			for (int i = 0; i < n; i++) 
			{
				Character letter = str.charAt(i);
				if(!node.children.containsKey(letter))
					return false;
				
				node = node.children.get(letter);
			}
			return node.children.containsKey(endCharacter)?true:false;
		}
	}

	public static void main(String[] args) {
		SuffixTrieDemo.SuffixTrie demo = new SuffixTrieDemo.SuffixTrie();
		demo.populateSuffixTrie("abcd");
		System.out.println(demo.contains("abcd")); 

	}

}
