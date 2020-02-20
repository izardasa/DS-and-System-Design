package bottomupwithtabulation;


public class HouseTheif {

	private int findMaxSteal(int[] wealth)
	{
		int[] dp= new int[wealth.length+1];
		
		dp[0] = 0;
		dp[1] = wealth[0];
		
		for (int i = 1; i < wealth.length; i++) {
			dp[i+1] = Math.max(dp[i], wealth[i]+dp[i-1]);
		}
		
		return dp[wealth.length];
	
	}
	
	private int findMaxStealSpaceOptimized(int[] wealth)
	{
		
		int n1 = 0;
		int n2 = wealth[0];
		
		for (int i = 1; i < wealth.length; i++) {
			int temp = Math.max(wealth[i]+n1, n2);
			n1= n2;
			n2= temp;
		}
		
		return n2;
	}
	public static void main(String[] args) {
		HouseTheif houseThief = new HouseTheif();
		System.out.println(houseThief.findMaxStealSpaceOptimized(new int[] { 2, 5, 1, 3, 6, 2, 4 }));
		System.out.println(houseThief.findMaxStealSpaceOptimized(new int[] { 2, 10, 14, 8, 1 }));
	}

}
