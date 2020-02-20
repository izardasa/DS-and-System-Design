package bottomupwithtabulation;

public class MinCoinChange {

	private int minCoinChange(int[] denomination, int total)
	{
		int n = denomination.length;
		if(n==0)
			return 0;
		
		int[][] dp = new int[n][total+1];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= total; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			for (int t = 1; t <= total; t++) {
				int total1 = Integer.MAX_VALUE;
				if (denomination[i] <= t) 
				{
					int res = dp[i][t - denomination[i]];
					if (res != Integer.MAX_VALUE)
						total1 = res + 1;
				}

				int total2 = Integer.MAX_VALUE;

				if (i >= 1) {
					total2 = dp[i - 1][t];
				}

				dp[i][t] = Integer.min(total1, total2);
			}
		}
		return dp[n-1][total];
	}
	public static void main(String[] args) {
		MinCoinChange minCoinChange = new MinCoinChange();
		int[] denomination = new int[]{1,2,3,4,5,6,7};
		int total =706;
		System.out.println(minCoinChange.minCoinChange(denomination, total));
		

	}

}
