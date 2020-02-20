
public class FindSubArraySortIndex {
	
	private static int[] findSubArraySortIndex(int[] A)
	{
		int n = A.length;
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) 
		{
			if(isOutOfOrder(i,A))
			{
				minOutOfOrder = Integer.min(minOutOfOrder, A[i]);
				maxOutOfOrder = Integer.max(maxOutOfOrder, A[i]);
			}
			
		}
		if(minOutOfOrder==Integer.MAX_VALUE)
			return new int[] {-1,-1};
		
		int leftIndexPosition = 0;
		int rightIndexPosition = n-1;
		while(minOutOfOrder>A[leftIndexPosition])
			leftIndexPosition++;
		
		while(maxOutOfOrder<A[rightIndexPosition])
			rightIndexPosition--;
		
		return new int[] {leftIndexPosition,rightIndexPosition};
	}

	private static boolean isOutOfOrder(int i, int[] A) {
		if( i==0 )
			return  A[i]>A[i+1];
		
		if(i==A.length-1  )
			return A[i]<A[i-1];
		
		return A[i]>A[i+1] || A[i]<A[i-1];
	}

	public static void main(String[] args) {

	//	int[] res = findSubArraySortIndex(new int[] {1,2,4,7,10,11,7,6,12,7,16,18,19});
		int[] res = findSubArraySortIndex(new int[] {1,2,3});
		System.out.println(res[0]+" "+res[1]);
	}

}
