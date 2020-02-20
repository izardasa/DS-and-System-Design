package topdownwithmemorization;

public class ExpressNumber {

	private int countWays(int n) {

		int[] dp = new int[n + 1];
		return countWays(n, dp);
	}

	private int countWays(int n, int[] dp) {
		if (n <= 2)
			return 1;
		if (n == 3)
			return 2;

		if (dp[n] == 0) {
			dp[n]=countWays(n-1,dp)+countWays(n-3,dp)+countWays(n-4,dp);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		ExpressNumber expressNumber= new ExpressNumber();
		System.out.println(expressNumber.countWays(4));
		System.out.println(expressNumber.countWays(5));

	}

}
