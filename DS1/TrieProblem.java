import ds.impl.Trie;

public class TrieProblem {

	public static void main(String[] args) {
		String[] keys = new String[] { "sanjay", "izardar", "is", "a", "software", "engineer" };
		for (int i = 0; i < keys.length; i++)
			Trie.insert(keys[i]);
		
		System.out.println(Trie.search("engineers"));
	}

}
