package recursive;

public class LongestPalindromicSubstring {
	
	private int LCS(String str)
	{
		return LCS(str,0,str.length()-1);
	}

	private int LCS(String str, int start, int end) {
		if(start>end)
			return 0;
		
		if(start==end)
			return 1;
		
		if(str.charAt(start)==str.charAt(end))
		{
			int remainingLength = end-start-1;
			if(remainingLength == LCS(str,start+1,end-1))
				return 2+remainingLength;
		}
		
		int c1= LCS(str,start+1,end);
		int c2= LCS(str,start,end-1);
		return Math.max(c1, c2);
	}

	public static void main(String[] args) {
		
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.LCS("abdbca"));
		System.out.println(longestPalindromicSubstring.LCS("cddpd"));
		System.out.println(longestPalindromicSubstring.LCS("pqr"));

	}

}
