package bottomupwithtabulation;

public class FindTargetSubsetCount {

	public int findTargetSubsetCount(int[] A, int num) {
		int n = A.length;
		if (n < 1)
			return 0;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i];
		}

		if ((sum + num) % 2 == 1)
			return 0;
		return findTargetSubsetCountTabularSpaceOs(A, (sum + num) / 2);
	}

	private int findTargetSubsetCountTabular(int[] A, int sum) {

		int n = A.length;

		int[][] dp = new int[n][sum + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int s = 1; s <= sum; s++) {
			dp[0][s] = A[0] == s ? 1 : 0;
		}

		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {
				dp[i][s] = dp[i - 1][s];

				if (A[i] <= s)
					dp[i][s] += dp[i - 1][s - A[i]];
			}

		}

		return dp[n - 1][sum];
	}

	private int findTargetSubsetCountTabularSpaceOs(int[] A, int sum) {

		int n = A.length;

		int[] dp = new int[sum + 1];

		dp[0] = 1;

		for (int s = 1; s <= sum; s++) {
			dp[s] = A[0] == s ? 1 : 0;
		}

		for (int i = 1; i < n; i++) {
			for (int s = sum; s >= 1; s--) {

				if (A[i] <= s)
					dp[s] += dp[s - A[i]];
			}

		}

		return dp[sum];
	}

	public static void main(String[] args) {
		FindTargetSubsetCount count = new FindTargetSubsetCount();
		System.out.println(count.findTargetSubsetCount(new int[] { 1, 1, 2, 3 }, 1));
		System.out.println(count.findTargetSubsetCount(new int[] { 1, 2, 7, 1 }, 9));
	}

}
