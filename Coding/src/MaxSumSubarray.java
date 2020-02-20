
public class MaxSumSubarray {

	private static int findMaxSumSubarray(int[] A) {
		int n = A.length;
		int[] res = new int[n];

		res[0] = A[0] > 0 ? A[0] : 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] + A[i] < 0 ? 0 : res[i - 1] + A[i];
			if (max < res[i])
				max = res[i];
		}

		return max;
	}

	private static int findMaxSumSubarrayBySanjay(int[] A) {
		int n = A.length;

		int sum = A[0] > 0 ? A[0] : 0;
		int max = A[0];
		int maxSoFar = sum;
		for (int i = 1; i < n; i++) {
			sum = sum + A[i] < 0 ? 0 : sum + A[i];
			if (maxSoFar < sum)
				maxSoFar = sum;

			if (max < A[i])
				max = A[i];
		}

		return max < 0 ? max : maxSoFar;
	}

	private static int findMaxSumSubarrayByKadane(int[] A) {
		int n = A.length;

		int maxEndingHere = A[0];
		int maxSumSofar = A[0];
		for (int i = 1; i < n; i++) {
			maxEndingHere = maxEndingHere + A[i] > A[i] ? maxEndingHere + A[i] : A[i];
			if (maxSumSofar < maxEndingHere)
				maxSumSofar = maxEndingHere;
		}

		return maxSumSofar;
	}

	public static void main(String[] args) {

		System.out
				.println(findMaxSumSubarrayByKadane(new int[] { 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 }));
		System.out.println(findMaxSumSubarrayByKadane(
				new int[] { -3, -5, -9, -1, -3, -2, -3, -4, -7, -2, -9, -6, -3, -1, -5, -4 }));
	}

}

//1 -3 5 2 7 -8 -2 2
//1  0 5 7 14 6  4 6
