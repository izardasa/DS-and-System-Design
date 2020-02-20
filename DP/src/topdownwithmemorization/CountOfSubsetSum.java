package topdownwithmemorization;


public class CountOfSubsetSum {

	public int countOfSubsetWithSumK(int[] A, int K)
	{
		int n = A.length;
		if(n==0)
			return 0;
		
		Integer[][] dp = new Integer[n][K+1];
		return countOfSubsetWithSumKRecursive(A, K, dp, 0);
	}
	private int  countOfSubsetWithSumKRecursive(int[] A, int K, Integer[][] dp, int currentIndex) {
		
		if(K==0)
			return 1;
		if(A.length==currentIndex)
			return 0;
		
		if(dp[currentIndex][K]==null)
		{
			int sum1 =0;
			if(K>=A[currentIndex])
				sum1 = countOfSubsetWithSumKRecursive(A, K-A[currentIndex], dp, currentIndex+1);
					
			int sum2 = countOfSubsetWithSumKRecursive(A, K, dp, currentIndex+1);
			
			dp[currentIndex][K] = sum1+sum2;
		}
		
		return dp[currentIndex][K];
	}
	public static void main(String[] args) {
		CountOfSubsetSum count = new CountOfSubsetSum();
		System.out.println(count.countOfSubsetWithSumK(new int[] { 1, 2, 7, 1, 5 }, 9));
		System.out.println(count.countOfSubsetWithSumK(new int[] {1, 5, 2, 3}, 5));

	}

}
