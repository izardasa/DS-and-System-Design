package bottomupwithtabulation;



public class LongestPalindromicSubstring {

	private int LCS(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		int maxLength = 1;
		for (int start = n - 1; start >= 0; start--) {
			for (int end = start + 1; end < n; end++) {

				if (str.charAt(start) == str.charAt(end)) {
					if (dp[start + 1][end - 1] || end-start==1) {
						dp[start][end] = true;
						maxLength = Math.max(end - start + 1, maxLength);
					}
				}
			}
		}
		
		return maxLength;

	}

	private int countLCS(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];

		int count=0;
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			count++;
		}

		for (int start = n - 1; start >= 0; start--) {
			for (int end = start + 1; end < n; end++) {

				if (str.charAt(start) == str.charAt(end)) {
					if (dp[start + 1][end - 1] || end-start==1) {
						dp[start][end] = true;
						count++;
					}
				}
			}
		}
		
		return count;

	}
	
	public static void main(String[] args) {
		
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.LCS("abdbca"));
		System.out.println(longestPalindromicSubstring.LCS("cddpd"));
		System.out.println(longestPalindromicSubstring.LCS("pqr"));
		
		System.out.println(longestPalindromicSubstring.countLCS("abdbca"));
		System.out.println(longestPalindromicSubstring.countLCS("cddpd"));
		System.out.println(longestPalindromicSubstring.countLCS("pqr"));

	}

}
