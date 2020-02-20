package bottomupwithtabulation;

public class EqualSubetSum {

	public static Boolean equalSubsetSum(int[] A)
	{
		int n =A.length;
		if(n<2)
			return false;
		
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
		}
		
		if(sum%2!=0)
			return false;
		
		sum=sum/2;
		boolean[][] dp = new boolean[n][sum+1];
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		
		for (int i = 1; i <= sum; i++) {
			dp[0][i] = (sum==A[0]);
		}
		
		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {
				if(dp[i-1][s])
				{
					dp[i][s] = dp[i-1][s];
				}
				else if(A[i]<=s)
				{
					dp[i][s] = dp[i-1][s-A[i]];
				}
			}
		}
		
		return dp[n-1][sum];
	}
	public static void main(String[] args) {
	    int[] num = {1, 2, 3, 4};
	    System.out.println(equalSubsetSum(num));
	    num = new int[]{1, 1, 3, 4, 7};
	    System.out.println(equalSubsetSum(num));
	    num = new int[]{2, 3, 4, 6};
	    System.out.println(equalSubsetSum(num));

	}

}
