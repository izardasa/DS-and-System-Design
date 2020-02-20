package recursive;

public class LongestIncreasingSequence {

	private int LIS(int[] A)
	{
		return LIS(A, 0, -1);
	}
	private int LIS(int[] A, int currentIndex, int previousIndex) {
		if(currentIndex==A.length)
			return 0;
		
		int c1 =0;
		if(previousIndex==-1 || A[previousIndex]<A[currentIndex])
			c1= 1+LIS(A, currentIndex+1, previousIndex+1);
		
		int c2= LIS(A, currentIndex+1, previousIndex);
		
		return Math.max(c1, c2);
	}
	public static void main(String[] args) {
		LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
		System.out.println(longestIncreasingSequence.LIS(new int[]{4,2,3,6,10,1,12}));
		System.out.println(longestIncreasingSequence.LIS(new int[]{-4,10,3,7,15}));

	}

}
