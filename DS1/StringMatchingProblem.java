
public class StringMatchingProblem {

	public static void main(String[] args) {
		findStringKMP("ABCDEFGHABCAB", "AB");
	}
	
	private static void findStringKMP(String text, String pattern)
	{
		int m = text.length();
		int n = pattern.length();
		if(m==0 || n==0)
		{
			System.out.println(" Please enter string with size more than 1 character");
		}
		
		int[] lps = computePrefixTable(pattern);
		
		int i=0;
		int j=0;
		
		while(i<m)
		{
			if(text.charAt(i)==pattern.charAt(j))
			{
				i++;
				j++;
				
				if(j==n)
				{
					System.out.println("String found at index: "+(i-j));
					j=lps[j-1];
				}
			
			}
			else
			{
				if(j>0)
				{
					j=lps[j-1];
				}
				else
				{
					i++;
				}
			}
		}
	}

	private static int[] computePrefixTable(String pattern)
	{
		int M  = pattern.length();
		int[] lps = new int[M];
		lps[0]=0;
		int len=0;
		int i=1;
		while(i<M)
		{
			if(pattern.charAt(i)==pattern.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len>0)
				{
				len = lps[len-1];
				}
				else
				{
					lps[i]=0;
					i++;
				}
			}
			
		}
		
		return lps;
		
	}
	private static boolean isSubstringBruteForce(String str1, String str2) {
		int m = str2.length();
		int n = str1.length();
		
		for(int i=0;i<=n-m;i++)
		{
			int j=0;
			while(j<m && str1.charAt(i+j)==str2.charAt(j))
				j=j+1;
			
			if(j==m)
				return true;
		}
		return false;
		
	}

}
