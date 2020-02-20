package topdownwithmemorization;

public class LongestPalindromicSubsequence {

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
			if (str.charAt(start) == str.charAt(end))
				dp[start][end] = 2 + LCS(str, start + 1, end - 1, dp);
			else {
				int c1 = LCS(str, start + 1, end, dp);
				int c2 = LCS(str, start, end - 1, dp);
				dp[start][end] = Math.max(c1, c2);
			}
		}

		return dp[start][end];

	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
		System.out.println(longestPalindromicSubsequence.LCS("abdbca"));
		System.out.println(longestPalindromicSubsequence.LCS("cddpd"));
		System.out.println(longestPalindromicSubsequence.LCS("pqr"));
	}

}
