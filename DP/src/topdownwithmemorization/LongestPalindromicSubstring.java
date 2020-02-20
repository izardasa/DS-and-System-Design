package topdownwithmemorization;

public class LongestPalindromicSubstring {

	private int LCS(String str) {
		int n = str.length();
		Integer[][] dp = new Integer[n][n];
		return LCS(str, 0, n - 1, dp);

	}

	private int LCS(String str, int start, int end, Integer[][] dp) {
		if (start > end)
			return 0;

		if (start == end)
			return 1;

		if (dp[start][end] == null) {
			if (str.charAt(start) == str.charAt(end)) {
				int remainingLength = end - start - 1;
				if (remainingLength == LCS(str, start + 1, end - 1, dp)) {
					dp[start][end] = 2 + remainingLength;
					return dp[start][end];
				}
			}
			dp[start][end] = Math.max(LCS(str, start + 1, end, dp), LCS(str, start, end - 1, dp));
		}
		return dp[start][end];
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.LCS("abdbca"));
		System.out.println(longestPalindromicSubstring.LCS("cddpd"));
		System.out.println(longestPalindromicSubstring.LCS("pqr"));
	}

}
