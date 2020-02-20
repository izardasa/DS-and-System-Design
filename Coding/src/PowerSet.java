import java.util.ArrayList;

public class PowerSet {

	public static ArrayList<ArrayList<Integer>> powerSet(int[] A)
	{
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> emptyList = new ArrayList<Integer>();
		powerSet.add(emptyList);
		
		for (int i = 0; i < A.length; i++) 
		{
			int n = powerSet.size();
			for (int j = 0; j < n; j++)
			{
				ArrayList<Integer> newList = new ArrayList<>(powerSet.get(j));
				newList.add(A[i]);
				powerSet.add(newList);
			}
		}
		return powerSet;
	}
	public static void main(String[] args) {

		System.out.println(powerSet(new int[] {1,2,3,4,5}));
	}

}
