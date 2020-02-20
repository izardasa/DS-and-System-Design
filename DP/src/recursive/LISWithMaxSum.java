package recursive;

public class LISWithMaxSum {

	private int LIS(int[] A) {
		return LIS(A, -1, 0, 0);
	}

	private int LIS(int[] A, int preIndex, int currentIndex, int sum) {
		if (A.length == currentIndex)
			return sum;

		int s1 = 0;
		if (preIndex == -1 || A[currentIndex] > A[preIndex])
			s1 = LIS(A, currentIndex, currentIndex + 1, sum + A[currentIndex]);

		int s2 = LIS(A, preIndex, currentIndex + 1, sum);

		return Math.max(s1, s2);
	}

	public static void main(String[] args) {
		LISWithMaxSum lisWithMaxSum = new LISWithMaxSum();
		System.out.println(lisWithMaxSum.LIS(new int[] { 4, 1, 2, 6, 10, 1, 12,30 }));
		System.out.println(lisWithMaxSum.LIS(new int[]{-4,10,-3,7,15}));
		
	}

}
