package bottomupwithtabulation;

import java.util.HashSet;
import java.util.Set;

public class MaxCountIncreasingSubset {
	
	private static int getMaxCount(int[] A)
	{
		Set<Integer> set = new HashSet<Integer>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			set.add(A[i]);
		}
		
		int maxCount=0;
		for (int i = 0; i < n; i++) {
			int num = A[i];
			if(!set.contains(num-1))
			{
				while(set.contains(num))
					num++;
				
				if(maxCount<num-A[i])
					maxCount=num-A[i];
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		System.out.println(getMaxCount(new int[]{13,1,10,15,4,7,3,2}));

	}

}
