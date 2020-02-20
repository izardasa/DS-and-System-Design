package recursive;

public class CountChange {

	private int countChange(int[] denominations, int total) {
		return countChange(denominations, total, 0);
	}

	private int countChange(int[] denominations, int total, int currentIndex) {
		if (total == 0)
			return 1;

		if (denominations.length == 0 || currentIndex >= denominations.length)
			return 0;

		int profit1 = 0;
		if (denominations[currentIndex] <= total) {
			profit1 = countChange(denominations, total - denominations[currentIndex], currentIndex);
		}

		int profit2 = countChange(denominations, total, currentIndex + 1);

		return profit1 + profit2;

	}

	public static void main(String[] args) {
		int[] denominations = new int[] { 1, 2, 3 };
		CountChange change = new CountChange();
		System.out.println(change.countChange(denominations, 6));
	}

}
