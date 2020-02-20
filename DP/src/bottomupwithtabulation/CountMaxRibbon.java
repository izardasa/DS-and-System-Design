package bottomupwithtabulation;



public class CountMaxRibbon {

	private int countMaxRibbon(int[] ribbon, int totalLength)
	{
		int n = ribbon.length;
		if(n==0 || totalLength<=0)
			return -1;

		int[][] dp = new int[n][totalLength+1];
		
		for (int i = 0; i < n; i++) {
			for (int t = 0; t <= totalLength; t++) {
				dp[i][t] = Integer.MIN_VALUE;
			}
		}
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int t = 1; t <= totalLength; t++) {
				int count1 = Integer.MIN_VALUE;
				if(ribbon[i]<=t)
				{
					int res = dp[i][t-ribbon[i]];
					if(res!=Integer.MIN_VALUE)
						count1 = res+1;
				}
				int count2 = Integer.MIN_VALUE;
				if(i>=1)
				{
					count2= dp[i-1][t];
				}
				
				dp[i][t] = Math.max(count1, count2);
			}
		}
		return dp[n-1][totalLength];
				
	}
	public static void main(String[] args) {
		CountMaxRibbon countMaxRibbon = new CountMaxRibbon();
		 
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3,5}, 5));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3}, 7));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{3,5,7}, 21));

	}

}
