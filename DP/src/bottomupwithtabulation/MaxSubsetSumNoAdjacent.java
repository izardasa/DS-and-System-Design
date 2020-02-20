package bottomupwithtabulation;

public class MaxSubsetSumNoAdjacent {

	//Time O(n) || Space O(n)
	private static int maxSubsetSum(int[] A)
	{
		int n = A.length;
		int[] result = new int[n];
		
		result[0] = A[0];
		result[1] = A[0]>A[1]?A[0]:A[1];
		
		for (int i = 2; i < n; i++) {
			result[i] =Math.max(result[i-1],A[i]+result[i-2]);
		}
		return result[n-1];
				
	}
	
	private static int maxSubsetSumWithSpaceO1(int[] A)
	{
		int seond = A[0];
		int first= A[0]>A[1]?A[0]:A[1];
		
		for (int i = 2; i < A.length; i++) {
			
			int current = Math.max(first, A[i]+seond);
			seond = first;
			first = current;
		}
		return first;
	}
	public static void main(String[] args) {
		System.out.println(maxSubsetSumWithSpaceO1(new int[] {7,10,12,7,9,14}));
	}

}
