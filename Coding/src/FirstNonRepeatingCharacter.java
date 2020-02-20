
public class FirstNonRepeatingCharacter {

	public static void printFirstNonRepeatingCharacter(String str) {
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i)-'a'] == 1)
			{
				System.out.println(str.charAt(i));
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("test");
		printFirstNonRepeatingCharacter("abcdcb");
	}
}
