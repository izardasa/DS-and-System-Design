package topdownwithmemorization;



public class CountMaxRibbon {

	private int countMaxRibbon(int[] ribbon, int totalLength)
	{
		int n = ribbon.length;
		if(n==0 || totalLength<=0)
			return -1;
		
		Integer[][] dp = new Integer[n][totalLength+1];
		int res = countMaxRibbon(ribbon, totalLength,dp,0);
		
		return res==Integer.MIN_VALUE?-1:res;
				
			
	}
	private int countMaxRibbon(int[] ribbon, int totalLength,Integer[][] dp, int currentIndex) {
		if(totalLength==0)
			return 0;
		if(currentIndex>=ribbon.length)
			return Integer.MIN_VALUE;
		
		if(dp[currentIndex][totalLength]==null)
		{
			int count1 = Integer.MIN_VALUE;
			if(ribbon[currentIndex]<=totalLength)
			{
				int res = countMaxRibbon(ribbon, totalLength-ribbon[currentIndex], dp,currentIndex);
				if(res!=Integer.MIN_VALUE)
					count1 = res+1;
			}
			
			int count2 = countMaxRibbon(ribbon, totalLength, dp, currentIndex+1);
			
			dp[currentIndex][totalLength] = Math.max(count1, count2);
		}
		
		return dp[currentIndex][totalLength];
	}
	public static void main(String[] args) {
		CountMaxRibbon countMaxRibbon = new CountMaxRibbon();
		 
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3,5}, 5));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3}, 7));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{3,5,7}, 21));

	}

}
