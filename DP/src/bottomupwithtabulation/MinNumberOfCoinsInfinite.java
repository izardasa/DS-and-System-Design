package bottomupwithtabulation;

public class MinNumberOfCoinsInfinite {

	private static int minNumberOfCoins(int[] denoms, int sum)
	{
		int[] amount = new int[sum+1];
		for (int i = 0; i < amount.length; i++) {
			amount[i]=Integer.MAX_VALUE;
		}
		amount[0]=0;
		
		for (int i = 0; i < denoms.length; i++) {
			for (int j = 1; j < amount.length; j++) {
				if(denoms[i]<=j)
					amount[j] = Math.min(amount[j], 1+amount[j-denoms[i]]);
			}
		}
		return amount[sum]!=Integer.MAX_VALUE?amount[sum]:-1;
	}
	public static void main(String[] args) {
		System.out.println(minNumberOfCoins(new int[] {1,2,4}, 6));
	}

}
