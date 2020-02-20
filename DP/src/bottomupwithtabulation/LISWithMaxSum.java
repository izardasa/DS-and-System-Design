package bottomupwithtabulation;

public class LISWithMaxSum {

	private int LISSum(int[] A) {
		int n = A.length;

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = A[i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] < dp[j] + A[i])
					dp[i] = dp[j] + A[i];

			}
		}

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			maxSum = Integer.max(maxSum, dp[i]);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		LISWithMaxSum lisWithMaxSum = new LISWithMaxSum();
		System.out.println(lisWithMaxSum.LISSum(new int[] { 4, 1, 2, 6, 10, 1, 12 }));
	}

}
