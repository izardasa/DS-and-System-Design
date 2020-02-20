package topdownwithmemorization;

public class CountWays {

	private int countWays(int n)
	{
		
		int[] dp = new int[n+1];
		return countWays(n,dp);
	}
	private int countWays(int n, int[] dp) {
		if(n==0 || n==1)
			return 1;
		if(n==2)
			return 2;
		
		if(dp[n]==0)
		{
			dp[n] = countWays(n-1,dp)+countWays(n-2,dp)+countWays(n-3, dp);
		}
		
		return dp[n];
		
	}
	public static void main(String[] args) {
		CountWays countWays = new CountWays();
		System.out.println(countWays.countWays(3));
		System.out.println(countWays.countWays(4));
		System.out.println(countWays.countWays(5));


	}

}
