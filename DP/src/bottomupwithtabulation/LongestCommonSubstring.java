package bottomupwithtabulation;



public class LongestCommonSubstring {

	
	private int LCS(String str1, String str2)
	{
		int n1= str1.length();
		int n2= str2.length();
		int[][] dp = new int[n1+1][n2+1];

		int maxLength = 0;
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dp[i][j] = 1+ dp[i-1][j-1];
					maxLength = Math.max(maxLength, dp[i][j]);
				}
			}
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		System.out.println(longestCommonSubstring.LCS("sdfABCDEF", "DDDBCDEFG"));
	}

}
