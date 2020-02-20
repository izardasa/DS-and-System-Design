package topdownwithmemorization;

public class EqualSubsetSum {

	public static boolean equalSubsetSum(int[] A)
	{
		int n = A.length;
		if(n<2)
			return false;
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=A[i];
		
		if(sum%2!=0)
			return false;
		
		Boolean[][] dp = new Boolean[n][sum/2+1];
		return equalSubsetSumRecursive(A, sum/2, dp,0);
		
	}
	private static Boolean equalSubsetSumRecursive(int[] A, int sum, Boolean[][] dp, int currentIndex) {
		if(sum==0)
			return true;
		
		if(currentIndex>= A.length )
			return false;
		
		if(dp[currentIndex][sum]==null)
		{
			if(A[currentIndex]<=sum)
			{
				if(equalSubsetSumRecursive(A, sum - A[currentIndex], dp, currentIndex+1))
				{
					dp[currentIndex][sum]=true;
					return true;
				}
			}
		}
		
		dp[currentIndex][sum] = equalSubsetSumRecursive(A, sum, dp, currentIndex+1);
		
		return dp[currentIndex][sum];
	}
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4 };
	    System.out.println(equalSubsetSum(num));
	    num = new int[] { 1, 1, 3, 4, 7 };
	    System.out.println(equalSubsetSum(num));
	    num = new int[] { 2, 3, 4, 6 };
	    System.out.println(equalSubsetSum(num));

	}

}
