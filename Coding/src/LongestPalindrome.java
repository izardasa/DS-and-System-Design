
public class LongestPalindrome {

	private static String findLongestPalindrom(String s) {
		int n = s.length();
		int[] currentLongest = { 0, 1 };
		int currentLongestRange = 1;

		for (int i = 0; i < n; i++) {
			int[] even = getLongestRange(i - 1, i, s);
			int[] odd = getLongestRange(i - 1, i + 1, s);
			
			int evenRange =even[1]-even[0];
			int oddRange = odd[1]-odd[0];
			if(Math.max(evenRange, oddRange)>currentLongestRange)
			{
				if(evenRange>oddRange)
					currentLongest = even;
				else
					currentLongest = odd;
			}

		}
		return s.substring(currentLongest[0], currentLongest[1]);
	}

	private static int[] getLongestRange(int left, int right, String s) {
		int n = s.length();
		while (left >= 0 && right < n)
		{
			if (s.charAt(left) != s.charAt(right))
				break;

			left--;
			right++;
		}
		
		return new int[] { left+1, right};
	}

	public static void main(String[] args) {
		System.out.println(findLongestPalindrom("abcdcb"));

	}

}
