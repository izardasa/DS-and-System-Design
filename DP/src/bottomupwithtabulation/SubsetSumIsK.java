package bottomupwithtabulation;

import recursive.SubsetSumToN;

public class SubsetSumIsK {

	public boolean subsetSumIsK(int[] A, int K)
	{
		int n = A.length;
		if(n==0 && K==0)
			return true;
		
		if(n==0 && K!=0)
			return false;
		
		boolean[] dp = new boolean[K+1];
		return subsetSumIsKSpaceOrderN(A, K, dp);
		
	}
	private boolean subsetSumIsKSpaceOrderN(int[] A, int K, boolean[] dp) {
		int n = A.length;
			dp[0] = true;
		
		for (int k = 1; k < K; k++) {
			dp[k] = (A[0]==k);
		}
		
		for (int i = 1; i < n; i++) {
			for (int k = K; k >= 1; k--) {
					if(dp[k])
						dp[k]= dp[k];
					else if(A[i]<=k)
						dp[k] = dp[k-A[i]];
			}
		}
		
		return dp[K];
	}
	
	public static void main(String[] args) {
		SubsetSumToN s = new SubsetSumToN();
		System.out.println(s.subsetSumIsK(new int[]{1,2,3,4,5,6,7}, 53));
		System.out.println(s.subsetSumIsK(new int[]{1,2,7}, 3));
		System.out.println(s.subsetSumIsK(new int[]{1,3,4,8}, 131));


	}

}
