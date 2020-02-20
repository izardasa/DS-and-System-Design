package bottomupwithtabulation;



public class MinSubsetSumDiff {

	public int minSubsetSumDiff(int[] A) {
		int n = A.length;

		if (n == 0)
			return 0;

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int half = sum / 2;
		boolean[][] dp = new boolean[n][half + 1];
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int s = 1; s <= half; s++) {
			dp[0][s] = s==A[0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= half; s++) {
				if(dp[i-1][s])
					dp[i][s]= dp[i-1][s];
				else if(A[i]<=s)
					dp[i][s]= dp[i-1][s-A[i]];
			}
		}
		
		int sum1=0;
		for (int s = half; s >= 0; s--) {
			if(dp[n-1][s])
			{
				sum1= s;
				break;
			}
			
		}
		
		int sum2= sum-sum1;
		return Math.abs(sum1-sum2);
	}

	public int minSubsetSumDiffSpaceOrderS(int[] A) {
		int n = A.length;

		if (n == 0)
			return 0;

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int half = sum / 2;
		boolean[][] dp = new boolean[2][half + 1];
		
		for (int i = 0; i < 2; i++) {
			dp[i][0] = true;
		}

		for (int s = 1; s <= half; s++) {
			dp[0][s] = s==A[0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= half; s++) {
				if(dp[(i-1)%2][s])
					dp[i%2][s]= dp[(i-1)%2][s];
				else if(A[i]<=s)
					dp[i%2][s]= dp[(i-1)%2][s-A[i]];
			}
		}
		
		int sum1=0;
		for (int s = half; s >= 0; s--) {
			if(dp[1][s])
			{
				sum1= s;
				break;
			}
			
		}
		
		int sum2= sum-sum1;
		return Math.abs(sum1-sum2);
	}

	public int minSubsetSumDiffInOneD_DPArray(int[] A) {
		int n = A.length;

		if (n == 0)
			return 0;

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int half = sum / 2;
		boolean[] dp = new boolean[half + 1];
		
		dp[0] = true;

		for (int s = 1; s <= half; s++) {
			dp[s] = s==A[0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int s = half; s >= 1; s--) {
				if(dp[s])
					dp[s]= dp[s];
				else if(A[i]<=s)
					dp[s]= dp[s-A[i]];
			}
		}
		
		int sum1=0;
		for (int s = half; s >= 0; s--) {
			if(dp[s])
			{
				sum1= s;
				break;
			}
			
		}
		
		int sum2= sum-sum1;
		return Math.abs(sum1-sum2);
	}
	
	public static void main(String[] args) {

		MinSubsetSumDiff m  = new MinSubsetSumDiff();
		System.out.println(m.minSubsetSumDiffInOneD_DPArray(new int[]{1, 2, 3, 9}));
		System.out.println(m.minSubsetSumDiffInOneD_DPArray(new int[]{1, 2, 7, 1, 5}));
		System.out.println(m.minSubsetSumDiffInOneD_DPArray(new int[]{1, 3, 100, 4}));
	}

}
