package bottomupwithtabulation;

public class UnboundKnapSack {

	private int unboundKnapSack(int[] weight, int[] profit, int capacity)
	{
		if(weight.length!=profit.length || capacity<=0 || weight.length==0)
			return 0;
		
		int n = weight.length;
		int[][] dp = new int[n][capacity+1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			for (int c = 1; c <= capacity; c++) {
				int profit1=0,profit2=0;
				if(weight[i]<=c)
					profit1 = profit[i]+dp[i][c-weight[i]];
				
				if(i>0)
					profit2 = dp[i-1][c];
				
				dp[i][c] = Math.max(profit1, profit2);
			}
		}
		
		return dp[n-1][capacity];
	}
	public static void main(String[] args) {
		int[] weight = new int[]{1,2,3};
		int[] profit = new int[]{15,20,50};
		UnboundKnapSack ks= new UnboundKnapSack();
		System.out.println(ks.unboundKnapSack(weight, profit, 5));

	}

}
