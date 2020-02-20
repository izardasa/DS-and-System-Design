package topdownwithmemorization;

import recursive.LongestCommonSubsequence;

public class LongestCommonSubsequnece {

	private int LCS(String str1, String str2)
	{
		int n1= str1.length();
		int n2= str2.length();
		Integer[][] dp = new Integer[n1][n2];
		return LCS(str1, str2,0,0,dp);
	}
	private int LCS(String str1, String str2, int i, int j, Integer[][] dp) {
		if(i==str1.length() || j==str2.length())
			return 0;
		
		if(dp[i][j]==null)
		{
			if(str1.charAt(i)==str2.charAt(j))
				dp[i][j] = 1+LCS(str1, str2, i+1, j+1, dp);
			else
				dp[i][j] = Math.max(LCS(str1, str2, i+1, j, dp), LCS(str1, str2, i, j+1, dp));
		}
		
		return dp[i][j];
	}
	public static void main(String[] args) {
		LongestCommonSubsequnece longestCommonSubsequence = new LongestCommonSubsequnece();
		System.out.println(longestCommonSubsequence.LCS("abdca", "cbda"));
		System.out.println(longestCommonSubsequence.LCS("passport", "ppsspt"));

	}

}
