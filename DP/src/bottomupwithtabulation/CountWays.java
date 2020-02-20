package bottomupwithtabulation;

public class CountWays {

	private int countWays(int n)
	{
		
		
		int[] dp = new int[n+1];
		dp[0]= 1;
		dp[1]=1;
		dp[2]=2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}
	
	private int countWaysSpaceOptimized(int n)
	{
		if(n<2)
			return 1;
		if(n==2)
			return 2;
		int a=1,b=1,c=2;
		for (int i = 3; i <= n; i++) {
			int temp = a+b+c;
			a=b;
			b=c;
			c=temp;
		}
		
		return c;
	}
	public static void main(String[] args) {
		CountWays countWays = new CountWays();
		System.out.println(countWays.countWaysSpaceOptimized(3));
		System.out.println(countWays.countWaysSpaceOptimized(4));
		System.out.println(countWays.countWaysSpaceOptimized(5));


	}

}
