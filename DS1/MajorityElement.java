
public class MajorityElement {

	private static int findMajorityElement(int[] A) {
		int n = A.length;

		int count = 1;
		int majNumber = A[0];
		for (int i = 1; i < n; i++) {
			if (majNumber == A[i]) {
				count++;
			} else {
				if (count == 0) {
					count++;
					majNumber = A[i];
				} else {
					count--;
				}
			}
		}

		return majNumber;

	}

	public static void main(String[] args) {
		System.out.println(findMajorityElement(new int[] { 1, 1, 1, 2, 3, 1,1,4, 2,8 ,9}));
	}

}
