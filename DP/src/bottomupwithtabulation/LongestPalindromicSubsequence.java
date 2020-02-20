package bottomupwithtabulation;


public class LongestPalindromicSubsequence {

	private int LCS(String str)
	{
		int n = str.length();
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			dp[i][i]=1;
		}
		
		for (int start = n-1; start >=0; start--) {
			for (int end = start+1; end < n; end++) {
				if(str.charAt(start)==str.charAt(end))
					dp[start][end] = 2+dp[start+1][end-1];
				else
					dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
			}
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
		System.out.println(longestPalindromicSubsequence.LCS("abdbca"));
		System.out.println(longestPalindromicSubsequence.LCS("cddpd"));
		System.out.println(longestPalindromicSubsequence.LCS("pqr"));

	}

}
