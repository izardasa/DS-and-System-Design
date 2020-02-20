import java.util.HashSet;
import java.util.Set;

public class FindPairsOfNumberWithTheGivenSum {
	public static void findPairs(int[] A, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			int d = k - A[i];
			if (set.contains(A[i]))
				System.out.println(A[i] + "," + d);
			else
				set.add(d);

		}
	}

	public static void main(String[] args) {
		findPairs(new int[] { 1, 2, 3, 4,0, 5, 6, 7 }, 7);
	}
}
