package recursive;

public class HouseThief {

	private int findMaxSteal(int[] wealth) {
		return findMaxSteal(wealth, 0);

	}

	private int findMaxSteal(int[] wealth, int currentIndex) {
		if (wealth.length <= currentIndex)
			return 0;

		int wealthFromCurrentHome = wealth[currentIndex] + findMaxSteal(wealth, currentIndex + 2);
		int wealthFromNextHome = findMaxSteal(wealth, currentIndex + 1);

		return Math.max( wealthFromCurrentHome , wealthFromNextHome);
	}

	public static void main(String[] args) {
		HouseThief houseThief = new HouseThief();
		System.out.println(houseThief.findMaxSteal(new int[] { 2, 5, 1, 3, 6, 2, 4 }));
		System.out.println(houseThief.findMaxSteal(new int[] { 2, 10, 14, 8, 1 }));
	}

}
