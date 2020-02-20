package bottomupwithtabulation;

import topdownwithmemorization.CountOfSubsetSum;

public class countOfSubsetSum {

	public int countOfSubsetWithSumK(int[] A, int K)
	{
		int n = A.length;
		if(n==0)
			return 0;
		
		int[][] dp = new int[n][K+1];
		return countOfSubsetWithSumKTabular(A, K, dp);
	}
	private int countOfSubsetWithSumKTabular(int[] A, int K, int[][] dp) {
		
		for (int i = 0; i < A.length; i++) {
			dp[i][0] = 1;
		}
		for (int s = 1; s <= K; s++) {
			dp[0][s] = A[0]==s?1:0;
		}
		
		for (int i = 1; i < A.length; i++) {
			for (int s = 1; s <=K; s++) {
				dp[i][s] = dp[i-1][s];
				
				if(A[i]<=s)
					dp[i][s]+=dp[i-1][s-A[i]];
			}
			
		}
		
		return dp[A.length-1][K];
	}
	public static void main(String[] args) {
		countOfSubsetSum count = new countOfSubsetSum();
		System.out.println(count.countOfSubsetWithSumK(new int[] { 1, 2, 7, 1, 5 }, 9));
		System.out.println(count.countOfSubsetWithSumK(new int[] {1, 5, 2, 3,4,6}, 6));
	}

}
