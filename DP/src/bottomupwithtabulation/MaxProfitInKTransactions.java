package bottomupwithtabulation;

public class MaxProfitInKTransactions {

	private static int maxProfitInKTransactions(int[] price, int k)
	{
		int maxSumSoFar = Integer.MIN_VALUE;
		int[][] profit = new int[k+1][price.length];
		
		for(int t=1;t<k+1;t++)
		{
			
			for(int d=1;d<price.length;d++ )
			{
				maxSumSoFar = Math.max(maxSumSoFar, -price[d-1]+profit[t-1][d-1]);
				profit[t][d] = Math.max(profit[t][d-1],price[d]+ maxSumSoFar);
				
			}
		}
		
		return profit[k][price.length-1];
		
	}
	
	private static int maxProfitInKTransactionsSpaceOrderN(int[] price, int k)
	{
		int maxSumSoFar = Integer.MIN_VALUE;
		int[][] profit = new int[2][price.length];
		
		for(int t=1;t<k+1;t++)
		{
			
			for(int d=1;d<price.length;d++ )
			{
				maxSumSoFar = Math.max(maxSumSoFar, -price[d-1]+profit[(t-1)%2][d-1]);
				profit[t%2][d] = Math.max(profit[t%2][d-1],price[d]+ maxSumSoFar);
				
			}
		}
		
		return profit[1][price.length-1];
		
	}
	public static void main(String[] args) {
		System.out.println(maxProfitInKTransactions(new int[] {10, 15,9,30,8,18,26}, 3));

	}

}
