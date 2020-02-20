package topdownwithmemorization;



public class MinCoinChange {

	private int minCoinChange(int[] denomination, int total)
	{
		int n = denomination.length;
		if(n==0)
			return -1;
		
		Integer[][] dp = new Integer[n][total+1];
		int minCount = minCoinChange(denomination, total, dp, 0);
		return minCount == Integer.MAX_VALUE?-1:minCount;
	}
	private int minCoinChange(int[] denomination, int total, Integer[][] dp, int currentIndex) {
		if(total ==0)
			return 0;
		
		if(currentIndex>=denomination.length)
			return Integer.MAX_VALUE;
		
		if(dp[currentIndex][total]==null)
		{
			int total1= Integer.MAX_VALUE;
			if(denomination[currentIndex]<=total)
			{
				
				int res = minCoinChange(denomination, total-denomination[currentIndex],dp, currentIndex);
				if(res!= Integer.MAX_VALUE)
					total1 = res+1;
					
			}
			
			int total2 = minCoinChange(denomination, total,dp, currentIndex+1);
			
			dp[currentIndex][total] = Math.min(total1, total2);
		}
		
		return dp[currentIndex][total];
	}
	public static void main(String[] args) {
		int[] denomination = new int[]{1,2,3,4};
		MinCoinChange minCoinChange = new MinCoinChange();
		System.out.println(minCoinChange.minCoinChange(denomination, 9));

	}

}
