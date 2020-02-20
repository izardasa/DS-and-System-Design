package topdownwithmemorization;

public class CountChange {

	private int countChange(int[] denomination, int total)
	{
		if(denomination.length==0)
			return 0;
		
		Integer[][] dp = new Integer[denomination.length][total+1]; 
		return countChange(denomination, total,dp,0);
		
	}
	private int countChange(int[] denomination, int total, Integer[][] dp, int currentIndex) {
		
		if(total==0)
		return 1;
		
		if(currentIndex>=denomination.length || denomination.length==0 || total<0)
			return 0;
		
		if(dp[currentIndex][total]==null)
		{
			int profit1 = 0;
			if(denomination[currentIndex]<=total)
			{
				profit1 = countChange(denomination, total-denomination[currentIndex],dp, currentIndex);
			}
			
			int profit2 = countChange(denomination, total, dp, currentIndex+1);
			
			dp[currentIndex][total] = profit1+profit2;
		}
		
		return dp[currentIndex][total];
	}
	public static void main(String[] args) {
		CountChange countChange = new CountChange();
		int[] denomination = new int[]{1,2,3};
		System.out.println(countChange.countChange(denomination, 6));

	}

}
