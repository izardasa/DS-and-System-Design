package recursive;

public class KanpSack {

	public static int knapSack(int weight[], int profit[], int capacity, int index)
	{
		if(capacity<=0 || index >= weight.length)
			return 0;
		
		int include = 0;
		
		if(weight[index]<=capacity)
		include = profit[index] + knapSack(weight, profit, capacity - weight[index], index+1);
		int exclude = knapSack(weight, profit, capacity , index+1);
		
		return Integer.max(include, exclude);
	}
	public static void main(String[] args) {
		int[] weight = new int[]{2,3,1,4};
		int[] profit = new int[]{4,5,3,7};
		int capacity = 7;
		System.out.println(knapSack(weight, profit, capacity, 0));

	}

}
