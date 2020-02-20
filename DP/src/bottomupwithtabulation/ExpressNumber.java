package bottomupwithtabulation;



public class ExpressNumber {
	
	private int countWays(int n)
	{
		int[] dp = new int[n+1];
		
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		dp[3]=2;
		for (int i = 4; i <=n; i++) {
			dp[i] =  dp[i-1]+dp[i-3]+dp[i-4];
		}
				return dp[n];
		
	}

	public static void main(String[] args) {
		ExpressNumber expressNumber= new ExpressNumber();
		System.out.println(expressNumber.countWays(4));
		System.out.println(expressNumber.countWays(5));
	}

}
