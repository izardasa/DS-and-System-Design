package bottomupwithtabulation;

public class LavenshteinDistance {

	private static int lavenshteinDistance(String s1, String s2)
	{
		int n1 = s1.length();
		int n2 = s2.length();
		
		int[][] edit = new int[n1+1][n2+1];
		for (int r = 0; r <= n1; r++) 
		{
			for (int c = 0; c <=n2; c++) 
			{
				if(r==0)
					edit[r][c] = c;
				else if(c==0)
					edit[r][c] = r;
				
				else if(s1.charAt(r-1)==s2.charAt(c-1))
					edit[r][c] = edit[r-1][c-1];
				else
					edit[r][c] = 1+Math.min(Math.min(edit[r-1][c-1], edit[r-1][c]),edit[r][c-1]);
				
			}
			
		}
		return edit[n1][n2];
		
	}
	public static void main(String[] args) {
		System.out.println(lavenshteinDistance("abcwer", "yabd"));

	}

}
