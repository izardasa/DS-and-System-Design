package recursive;

public class MinSubsetSumDiff {
	
	public int minSubsetSumDiff(int[] A)
	{
		int n = A.length;
		if(n==0)
			return 0;
		
		return minSubsetSumDiffRecursive(A, 0, 0, 0);
	}

	private  int minSubsetSumDiffRecursive(int[] A, int currentIndex, int sum1, int sum2) {
		if(currentIndex == A.length)
			return Math.abs(sum1 - sum2);
		
		int diff1 = minSubsetSumDiffRecursive(A, currentIndex+1, sum1+A[currentIndex], sum2);
		int diff2 = minSubsetSumDiffRecursive(A, currentIndex+1, sum1, sum2+A[currentIndex]);
		
		return Integer.min(diff1, diff2);
		
	}

	public static void main(String[] args) {
		MinSubsetSumDiff m  = new MinSubsetSumDiff();
		System.out.println(m.minSubsetSumDiff(new int[]{1, 2, 3, 9}));
		System.out.println(m.minSubsetSumDiff(new int[]{1, 2, 7, 1, 5}));
		System.out.println(m.minSubsetSumDiff(new int[]{1, 3, 100, 4}));
		

	}

}
