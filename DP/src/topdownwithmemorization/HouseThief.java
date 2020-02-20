package topdownwithmemorization;



public class HouseThief {

	private int maxSteal(int[] wealth)
	{
		int[] dp = new int[wealth.length];
		return maxSteal(wealth,dp,0);
	}
	private int maxSteal(int[] wealth, int[] dp, int currentIndex) {
		if(currentIndex>=wealth.length)
			return 0;
		
		if(dp[currentIndex]==0)
		{
			int takeCurrentHome = wealth[currentIndex]+ maxSteal(wealth,dp,currentIndex+2);
			int skipCurrentHome = maxSteal(wealth, dp, currentIndex+1);
			dp[currentIndex] = Math.max(takeCurrentHome, skipCurrentHome);
		}
		return dp[currentIndex];
	}
	public static void main(String[] args) {
		HouseThief houseThief = new HouseThief();
		System.out.println(houseThief.maxSteal(new int[] { 2, 5, 1, 3, 6, 2, 4 }));
		System.out.println(houseThief.maxSteal(new int[] { 2, 10, 14, 8, 1 }));
	}

}
