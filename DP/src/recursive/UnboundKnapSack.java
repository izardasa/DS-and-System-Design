package recursive;

public class UnboundKnapSack {

	private int unboundKnapSack( int[] weight, int[] profit, int capacity )
	{
		return unboundKnapSack( weight, profit, capacity, 0);
		
		
	}
	private int unboundKnapSack( int[] weight, int[] profit, int capacity, int currentIndex) {
		if(capacity<=0 || currentIndex >= weight.length || weight.length != profit.length || profit.length==0)
			return 0;
		
		int profit1= 0;
		if(capacity>=weight[currentIndex])
		{
			profit1 = profit[currentIndex]+ unboundKnapSack( weight, profit, capacity-weight[currentIndex],currentIndex);
		}
		
		int profit2 = unboundKnapSack( weight, profit, capacity, currentIndex+1);
		
		return Integer.max(profit1, profit2);
	}
	public static void main(String[] args) {
		int[] profit = new int[]{15,20,50};
		int[] weight = new int[]{1,2,3};
		UnboundKnapSack knapSack = new UnboundKnapSack();
		System.out.println(knapSack.unboundKnapSack( weight, profit, 5));

	}

}
