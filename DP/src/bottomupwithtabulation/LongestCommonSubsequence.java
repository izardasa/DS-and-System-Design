package bottomupwithtabulation;

import topdownwithmemorization.LongestCommonSubsequnece;

public class LongestCommonSubsequence {

	private int LCS(String str1, String str2)
	{
		int n1= str1.length();
		int n2= str2.length();
		int[][] dp = new int[n1+1][n2+1];
		
		int maxLength = 0;
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}
		return maxLength;
	}
	
	private void fminDI(String str1, String str2)
	{
		System.out.println("Minimum delete operation :" +(str1.length() - LCS(str1, str2)));
		System.out.println("Minimum insert operation :" +(str2.length() - LCS(str1, str2)));
	}
	public static void main(String[] args) {
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
//		System.out.println(longestCommonSubsequence.fminDI("abdca", "cbda"));
//		System.out.println(longestCommonSubsequence.fminDI("passport", "ppsspt"));
		longestCommonSubsequence.fminDI("abdca", "cbda");
		longestCommonSubsequence.fminDI("passport", "ppsspt");

	}

}
