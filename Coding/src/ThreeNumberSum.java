import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {

	private static ArrayList<Integer[]> findTriplets(int[] array, int k) {
		Arrays.sort(array);
		int n = array.length;
		ArrayList<Integer[]> triplets = new ArrayList<>();
		for (int i = 0; i < array.length-2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int sum =array[i] + array[left] + array[right] ;
				if ( sum== k)
				{
					triplets.add(new Integer[] { array[i], array[left], array[right] });
					left++;
					right--;
				} else if (sum < k)
					left++;
				else
					right--;
			}
		}
		return triplets;
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> result = findTriplets(new int[] {0,0,0,0}, 0);
		for(Integer[] triplet : result)
		{
			System.out.println(triplet[0]+","+triplet[1]+","+triplet[2]);
		}
			

	}

}
