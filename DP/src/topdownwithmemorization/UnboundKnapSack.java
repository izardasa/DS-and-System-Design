package topdownwithmemorization;

public class UnboundKnapSack {

	private int unboundKnapSack(int[] weight, int[] profit, int capacity)
	{
		Integer[][] dp = new Integer[weight.length][capacity+1];
		return unboundKnapSack(weight, profit, capacity,dp, 0);
	}
	
	private int unboundKnapSack(int[] weight, int[] profit, int capacity, Integer[][] dp, int currentIndex) {
		if(weight.length != profit.length || capacity<=0 || weight.length==0 || currentIndex>=weight.length)
			return 0;
		
		if(dp[currentIndex][capacity]==null)
		{
			int profit1 = 0;
			
			if(weight[currentIndex]<=capacity)
				profit1 = profit[currentIndex]+unboundKnapSack(weight, profit, capacity-weight[currentIndex],dp, currentIndex);
			
			int profit2 = unboundKnapSack(weight, profit, capacity, dp, currentIndex+1);
			
			dp[currentIndex][capacity] = Integer.max(profit1,profit2);
		}
		
		return dp[currentIndex][capacity];
	}
	
	public static void main(String[] args) {
		int[] weight = new int[]{1,2,3};
		int[] profit = new int[]{15,20,50};
	UnboundKnapSack knapSack = new UnboundKnapSack();
	System.out.println(knapSack.unboundKnapSack(weight, profit, 5));

	}

}
