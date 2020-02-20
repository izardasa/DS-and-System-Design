package recursive;

public class CountOfSubsetSum {

	public int countOfSubsetWithSumK(int[] A, int K) {
		int n = A.length;

		if (n == 0)
			return 0;

		return countOfSubsetWithSumK(A, K, 0);
	}

	private int countOfSubsetWithSumK(int[] A, int K, int currentIndex) {

		int n = A.length;
		if ( K == 0)
			return 1;

		if (n <= currentIndex )
			return 0;

		int includeCurElement = 0;
		if (K >= A[currentIndex])

			includeCurElement = countOfSubsetWithSumK(A, K - A[currentIndex], currentIndex + 1);

		int excludeCurElement = countOfSubsetWithSumK(A, K, currentIndex + 1);

		return includeCurElement + excludeCurElement;

	}

	public static void main(String[] args) {
		CountOfSubsetSum count = new CountOfSubsetSum();
		System.out.println(count.countOfSubsetWithSumK(new int[] { 1, 2, 7, 1, 5 }, 9));
		System.out.println(count.countOfSubsetWithSumK(new int[] {1, 5, 2, 3}, 5));
	}

}
