package recursive;

public class LongestCommonSubstring {

	private int LCS(String str1, String str2) {
		return LCS(str1, str2, 0, 0, 0);
	}

	private int LCS(String str1, String str2, int i1, int i2, int count) {
		if (i1 == str1.length() || i2 == str2.length())
			return count;

		
		if (str1.charAt(i1) == str2.charAt(i2))
			count= LCS(str1, str2, i1 + 1, i2 + 1, count + 1);

		int c1 = LCS(str1, str2, i1 + 1, i2, 0);
		int c2 = LCS(str1, str2, i1, i2 + 1, 0);
		return Math.max(count,Math.max(c1, c2));
	}

	public static void main(String[] args) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		System.out.println(longestCommonSubstring.LCS("ABCDE", "DDDBCDEFG"));
	}

}
