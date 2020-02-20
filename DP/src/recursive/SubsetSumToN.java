package recursive;

public class SubsetSumToN {

	public boolean subsetSumIsK(int[] A, int K)
	{
		int n = A.length;
		if(n<1 && K>0)
			return  false;
		
		return subsetSumIsKRecursive(A, K,0);
	}
	private boolean subsetSumIsKRecursive(int[] A, int K, int currentIndex) {
		if(K==0)
			return true;
		
		if(currentIndex>=A.length)
			return false;
		if(A[currentIndex]<=K)
		{
			if(subsetSumIsKRecursive(A, K-A[currentIndex], currentIndex+1))
				return true;
		}
		
		return subsetSumIsKRecursive(A, K, currentIndex+1);

	}
	public static void main(String[] args) {
		SubsetSumToN s = new SubsetSumToN();
		System.out.println(s.subsetSumIsK(new int[]{1,2,3}, 6));
		System.out.println(s.subsetSumIsK(new int[]{1,2,7}, 10));
		System.out.println(s.subsetSumIsK(new int[]{1,3,4,8}, 12));

	}

}
