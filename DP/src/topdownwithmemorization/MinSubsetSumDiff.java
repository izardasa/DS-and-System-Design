package topdownwithmemorization;


public class MinSubsetSumDiff {

	public int minSubsetSumDiff(int[] A)
	{
		int n = A.length;
		
		if(n==0 )
			return 0;
		
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
		}
		Integer[][] dp = new Integer[n][sum+1];
		return minSubsetSumDiffMem(A, 0, 0, 0,dp);
		
		
	}
	private int minSubsetSumDiffMem(int[] A, int currentIndex, int sum1, int sum2, Integer[][] dp) {
		if(currentIndex==A.length)
			return Math.abs(sum1-sum2);
		
		if(dp[currentIndex][sum1]==null)
		{
			int diff1 = minSubsetSumDiffMem(A, currentIndex+1, sum1+A[currentIndex], sum2, dp);
			int diff2 = minSubsetSumDiffMem(A, currentIndex+1, sum1, sum2+A[currentIndex], dp);
			
			dp[currentIndex][sum1] = Math.min(diff1, diff2);
			
		}
		return dp[currentIndex][sum1];
	}
	public static void main(String[] args) {
		MinSubsetSumDiff m  = new MinSubsetSumDiff();
		System.out.println(m.minSubsetSumDiff(new int[]{1, 2, 3, 9}));
		System.out.println(m.minSubsetSumDiff(new int[]{1, 2, 7, 1, 5}));
		System.out.println(m.minSubsetSumDiff(new int[]{1, 3, 100, 4}));

	}

}
