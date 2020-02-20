
public class FindAllPermutation {
	public static void permutation(String str) {
		permutationHelper("", str);
	}

	private static void permutationHelper(String perm, String word) {
		if (word.length() == 0)
			System.out.println(perm + word);

		else {
			for (int i = 0; i < word.length(); i++) {
				permutationHelper(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
			}
		}

	}

	public static void main(String[] args) {
		permutation("san");
	}
}
