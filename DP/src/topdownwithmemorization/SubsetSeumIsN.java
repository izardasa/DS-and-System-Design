package topdownwithmemorization;

import recursive.SubsetSumToN;

public class SubsetSeumIsN {

	public boolean subsetSumIsN(int[] A, int K)
	{
		int n = A.length;
		
		if(n==0 && K==0 )
			return false;
		
		if(n==0 && K!=0 )
			return false;
		
		Boolean[][] dp = new Boolean[n][K+1];
		return subsetSumIsNRecursive(A, K, dp, 0);
	}
	private boolean subsetSumIsNRecursive(int[] A, int K, Boolean[][] dp, int currentIndex) {
		int n = A.length;
		
		if(K==0)
			return true;
		
		if(currentIndex>=n)
			return false;
		
		if (dp[currentIndex][K] != null) {
			if (A[currentIndex] <= K) {
				if (subsetSumIsNRecursive(A, K - A[currentIndex], dp, currentIndex + 1)) {
					dp[currentIndex][K] = true;
					return true;
				}
			}
			dp[currentIndex][K] = subsetSumIsNRecursive(A, K, dp, currentIndex+1);
		}
		
		return dp[currentIndex][K];
		
		
	}
	public static void main(String[] args) {
		SubsetSumToN s = new SubsetSumToN();
		System.out.println(s.subsetSumIsK(new int[]{1,2,3}, 7));
		System.out.println(s.subsetSumIsK(new int[]{1,2,7}, 4));
		System.out.println(s.subsetSumIsK(new int[]{1,3,4,8}, 2));

	}

}
