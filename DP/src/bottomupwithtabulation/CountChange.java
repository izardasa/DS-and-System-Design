package bottomupwithtabulation;

public class CountChange {

	private int countChange(int[] denomination, int total)
	{
		int n =denomination.length; 
		if(n==0)
			return 0;
		
		int[][] dp = new int[n][total+1];
		return countChange(denomination, total,dp);
		
	}
	private int countChange(int[] denomination, int total, int[][] dp) {
		if(total==0)
			return 0;
		
		int  n = denomination.length;
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int t = 1; t <= total; t++) {
				if(denomination[i]<=t)
					dp[i][t] = dp[i][t-denomination[i]];
				
				if(i>0)
					dp[i][t]+=dp[i-1][t];
			}
		}
		
		return dp[n-1][total];
	}
	public static void main(String[] args) {
		int[] deno = new int[]{1,2,3};
		CountChange countChange = new CountChange();
		
		System.out.println(countChange.countChange(deno, 6));

	}

}
