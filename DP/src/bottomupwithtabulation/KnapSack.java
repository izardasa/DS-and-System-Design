package bottomupwithtabulation;

public class KnapSack {

	public static int knapSack(int[] weight, int[] profit, int capacity)
	{
		int n = weight.length;
		
		if(capacity<=0 || profit.length==0 || weight.length!=profit.length)
			return 0;
		
		
		int[][] dp = new int[n][capacity+1];
		for(int i=0;i<n;i++)
			dp[i][0]=0;
		
		for(int i=1;i<=capacity;i++)
		{
			if(weight[0]<=i)
			dp[0][i] = profit[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int c=1;c<=capacity;c++)
			{
				int include =0;
				if(weight[i]<=c)
					include = profit[i]+dp[i-1][c-weight[i]];
				
				int exclude = dp[i-1][c];
				
				dp[i][c] = Integer.max(include, exclude);
			}
		}
		
		printSelectedElments(weight, profit, dp, capacity);
		return dp[n-1][capacity];
	}
	
	public static int knapSackSpaceComplexityO2c(int[] weight, int[] profit, int capacity)
	{
		int n = weight.length;
		
		if(capacity<=0 || profit.length==0 || weight.length!=profit.length)
			return 0;
		
		
		int[][] dp = new int[2][capacity+1];
		for(int i=0;i<2;i++)
			dp[i][0]=0;
		
		for(int i=1;i<=capacity;i++)
		{
			if(weight[0]<=i)
			dp[0][i] = profit[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int c=1;c<=capacity;c++)
			{
				int include =0;
				if(weight[i]<=c)
					include = profit[i]+dp[(i-1)%2][c-weight[i]];
				
				int exclude = dp[(i-1)%2][c];
				
				dp[i%2][c] = Integer.max(include, exclude);
			}
		}
		
		return dp[(n-1)%2][capacity];
	}
	
	public static int knapSackSpaceComplexityOc(int[] weight, int[] profit, int capacity)
	{
		int n = weight.length;
		
		if(capacity<=0 || profit.length==0 || weight.length!=profit.length)
			return 0;
		
		
		int[] dp = new int[capacity+1];
		
		dp[0]=0;
		for(int i=1;i<=capacity;i++)
		{
			if(weight[0]<=i)
			dp[i] = profit[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int c=1;c<=capacity;c++)
			{
				int include =0;
				if(weight[i]<=c)
					include = profit[i]+dp[c-weight[i]];
				
				int exclude = dp[c];
				
				dp[c] = Integer.max(include, exclude);
			}
		}
		
		return dp[capacity];
	}
	
	private static void printSelectedElments(int[] weight, int[] profit, int[][] dp, int capacity) {
		System.out.println("Selected Weights are");
		int n = weight.length;
		int totalProfit = dp[n-1][capacity];
		
		for(int i =weight.length-1;i>0;i--)
		{
			if(totalProfit!=dp[i-1][capacity])
			{
				System.out.println(weight[i]);
				totalProfit -= profit[i];
				capacity -= weight[i];
			}
		}
		
		if(totalProfit!=0)
		{
			System.out.println(weight[0]);
		}
		
	}
	public static void main(String[] args) {
		int[] weight = new int[]{1,2,3,5};
		int[] profit = new int[]{1,6,10,16};
		int capacity = 7;
		System.out.println(knapSackSpaceComplexityOc(weight, profit, capacity));

	}

}
