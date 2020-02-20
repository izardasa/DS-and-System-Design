package topdownwithmemorization;

public class KnapSack {

	public static int knapSack(int[] weight, int[] profit, int capacity)
	{
		int[][] dp = new int[profit.length][capacity+1];
		return knapSackRecursive(weight, profit, capacity, 0, dp);
	}
	private static int knapSackRecursive(int[] weight, int[] profit, int capacity, int index, int[][] dp) {
		if(index<0 || weight.length<=index)
			return 0;
		
		if(dp[index][capacity]!=0)
			return dp[index][capacity];
		
		int include = 0;
		if(weight[index]<=capacity)
			include = profit[index] + knapSackRecursive(weight, profit, capacity - weight[index], index+1, dp);
		
		int exclude = knapSackRecursive(weight, profit, capacity, index+1, dp);
		
		dp[index][capacity] = Integer.max(include, exclude);
		
		return dp[index][capacity];
		
	}
	public static void main(String[] args) {
		int[] weight = new int[]{1,2,3,5};
		int[] profit = new int[]{1,6,10,16};
		int capacity = 7;
		System.out.println(knapSack(weight, profit, capacity));

	}

}
