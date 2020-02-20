package topdownwithmemorization;

import java.util.HashMap;
import java.util.Map;



public class LISWithMaxSum {

	private int LIS(int[] A)
	{
		Map<String,Integer> dp = new HashMap<String,Integer>();
		return LIS(A,-1,0,0,dp);
		
	}
	
	private int LIS(int[] A, int preIndex, int currentIndex, int sum, Map<String, Integer> dp) {
		if(currentIndex==A.length)
			return sum;
		
		String key = preIndex+"-"+currentIndex+"-"+sum;
		if(dp.get(key)==null)
		{
			int s1 = sum;
			if(preIndex==-1 || A[preIndex]<A[currentIndex])
				s1= LIS(A, currentIndex, currentIndex+1, sum+A[currentIndex], dp);
			
			int s2 = LIS(A, preIndex, currentIndex+1, sum, dp);
			
			dp.put(key, Math.max(s1, s2));
		}
		
		return dp.get(key);
	}

	public static void main(String[] args) {
		LISWithMaxSum lisWithMaxSum = new LISWithMaxSum();
		System.out.println(lisWithMaxSum.LIS(new int[] { 4, 1, 2, 6, 10, 1, 12,30 }));
		System.out.println(lisWithMaxSum.LIS(new int[]{-4,10,-3,7,15}));
	}

}
