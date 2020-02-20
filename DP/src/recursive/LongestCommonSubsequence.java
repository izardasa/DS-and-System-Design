package recursive;

public class LongestCommonSubsequence {

	private int LCS(String str1, String str2)
	{
		return LCS(str1, str2, 0, 0);
	}
	private int LCS(String str1, String str2, int i, int j) {
		if(i==str1.length() || j==str2.length())
			return 0;
		
		int c1= 0;
		if(str1.charAt(i)==str2.charAt(j))
			return 1+ LCS(str1, str2, i+1, j+1);
		
		int c2= LCS(str1, str2, i+1, j);
		int c3= LCS(str1, str2, i, j+1);
		
		return Math.max(c1, Math.max(c2, c3));
	}
	public static void main(String[] args) {
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
		System.out.println(longestCommonSubsequence.LCS("abdca", "cbda"));
		System.out.println(longestCommonSubsequence.LCS("passport", "ppsspt"));

	}

}
