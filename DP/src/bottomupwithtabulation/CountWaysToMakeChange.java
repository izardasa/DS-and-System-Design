package bottomupwithtabulation;

public class CountWaysToMakeChange {

	private static int countWaysToMakeChagne(int[] denom, int n) {

		int[] ways = new int[n + 1];

		ways[0] = 1;
		for (int j = 0; j < denom.length; j++)
		{
			for (int amount = 1; amount < ways.length; amount++) {
				if (amount >= denom[j])
					ways[amount] += ways[amount - denom[j]];

			}
		}
		return ways[n];
	}

	public static void main(String[] args) {
		System.out.println(countWaysToMakeChagne(new int[] { 1, 5, 10, 25 }, 10));

	}

}
