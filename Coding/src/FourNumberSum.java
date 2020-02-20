import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourNumberSum {

	private static Set<Integer[]> findQuadruplets(int[] A, int k)
	{
		Map<Integer, Integer[]> uniquePairs= new HashMap<Integer, Integer[]>();
		Set<Integer[]> quadruplets = new HashSet<Integer[]>();
		
		int n = A.length;
		for (int i = 1; i < n-1; i++) 
		{
			for (int j = i+1; j < n; j++) 
			{
				int currentSum = A[i]+A[j];
				int diff = k - currentSum;
				
				if(uniquePairs.containsKey(diff))
				{
					
					Integer[] requiredSum =uniquePairs.get(diff);
					quadruplets.add(new Integer[] {A[i],A[j],requiredSum[0],requiredSum[1]});
				}
			}

			for (int m = 0; m < i; m++) 
			{
				int currentSum = A[i]+A[m];
				if(!uniquePairs.containsKey(currentSum))
				{
					uniquePairs.put(currentSum, new Integer[] {A[i],A[m]});
				}
			}
		
		}
		
		return quadruplets;
	}
	public static void main(String[] args) {
		Set<Integer[]> res = findQuadruplets(new int[] {7,6,4,-1,1,2}, 16);
		for(Integer[] quad: res)
		{
			System.out.println(quad[0]+","+quad[1]+","+quad[2]+","+quad[3]);
		}

	}

}
