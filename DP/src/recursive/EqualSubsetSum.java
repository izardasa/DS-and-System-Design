package recursive;

public class EqualSubsetSum {

	public static boolean hasTwoEqualSubsetSum(int[] A)
	{
		int n = A.length;
		if(n<2)
			return false;
		
		int sum  = 0;
		for(int i=0;i<n;i++)
			sum+=A[i];
		
		
		if(sum%2!=0)
			return false;
		
		return hasTwoSubsetSum(A, sum,0);
			
	}
	private static boolean hasTwoSubsetSum(int[] A, int half, int index) 
	{
		if(half==0)
			return true;
		
		if(index>=A.length )
			return false;
		
		if(A[index]<=half)
			if(hasTwoSubsetSum(A, half - A[index], index+1))
				return true;
		
		return hasTwoSubsetSum(A, half, index+1);
		
	}
	public static void main(String[] args) {
		System.out.println(hasTwoEqualSubsetSum(new int[]{2,3,4,6}));

	}

}
