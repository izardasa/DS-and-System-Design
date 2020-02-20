package recursive;

public class MinCoinChange {

	public int minCoinChange(int[] denomination, int total)
	{
		int n = denomination.length;
		if(n==0)
			return 0;
		
		int minCoins =  minCoinChange(denomination, total, 0);
		return minCoins== Integer.MAX_VALUE?-1:minCoins;
	}

	private int minCoinChange(int[] denomination, int total, int currentIndex) {
		if(total ==0)
			return 0;
		
		if(currentIndex>=denomination.length)
			return Integer.MAX_VALUE;
		
		int count1 = Integer.MAX_VALUE;
		if(denomination[currentIndex]<=total)
		{
			int res =  minCoinChange(denomination, total-denomination[currentIndex],currentIndex);
			if(res!= Integer.MAX_VALUE )
				count1 = res+1;
			
		}
		
		int count2 = minCoinChange(denomination, total, currentIndex+1);
		
		return Integer.min(count1, count2);
	}

	public static void main(String[] args) {
		int[] denomination = new int[]{1,2,3,4};
		MinCoinChange minCoinChange = new MinCoinChange();
		System.out.println(minCoinChange.minCoinChange(denomination, 102));

	}

}
