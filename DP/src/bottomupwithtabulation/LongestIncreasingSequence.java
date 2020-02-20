package bottomupwithtabulation;



public class LongestIncreasingSequence {

	private int LIS(int[] A)
	{
		int n = A.length;
		int[] dp = new int[n];
		
		dp[0]=1;
		int maxLength = 1;
		for (int i = 1; i < n; i++) {
			dp[i]=1;
			
			for (int j = 0; j < i; j++) {
				if(A[i]>A[j] && dp[i]>=dp[j])
				{
					dp[i] = 1+ dp[j];
					maxLength = Math.max(maxLength, dp[i]);
				}
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
		System.out.println(longestIncreasingSequence.LIS(new int[]{4,2,3,6,10,1,12}));
		System.out.println(longestIncreasingSequence.LIS(new int[]{-4,10,3,7,15}));
	}

}
