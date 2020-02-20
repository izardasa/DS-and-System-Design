package topdownwithmemorization;



public class LongestCommonSubstring {

	private int LCS(String str1, String str2)
	{
		int n1 = str1.length();
		int n2= str2.length();
		int count = Math.max(n1, n2);
		Integer[][][] dp = new Integer[n1][n2][count];
		return LCS(str1, str2,0,0,0,dp);
	}
	
	private int LCS(String str1, String str2, int i1, int i2, int count, Integer[][][] dp) {
		if(i1==str1.length() || i2==str2.length())
			return count;
		
		if(dp[i1][i2][count]==null)
		{
			int c1 = count;
			if(str1.charAt(i1)==str2.charAt(i2))
			{
				c1= LCS(str1, str2, i1+1, i2+1, count+1, dp);
			}
			
			int c2 = LCS(str1, str2, i1+1, i2, 0, dp);
			int c3= LCS(str1, str2, i1, i2+1, 0, dp);
			
			dp[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
		}
		
		return dp[i1][i2][count];
	}

	public static void main(String[] args) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		System.out.println(longestCommonSubstring.LCS("ABCDE", "DDDBCDEFG"));
	}

}
