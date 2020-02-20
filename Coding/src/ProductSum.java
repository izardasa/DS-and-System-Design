import java.util.ArrayList;
import java.util.List;

public class ProductSum {

	private static int findProductSum(ArrayList<Object> list)
	{
		return findProductSumHelper(list, 1);
		
	}
	private static int findProductSumHelper(ArrayList<Object> list, int multiplier) {
		
		int sum=0;
		int n = list.size();
		for(int i=0;i<n;i++)
		{
			if(list.get(i) instanceof List)
				sum+=findProductSumHelper((ArrayList)list.get(i), multiplier+1);
			else
				sum+=(int)list.get(i);
			
			
		}
		return sum*multiplier;
	}
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		ArrayList<Object> list1 = new ArrayList<>();
		list1.add(7);
		list1.add(-1);
		list.add(list1);
		list.add(3);
		ArrayList<Object> list2 = new ArrayList<>();
		list2.add(6);
		list2.add(4);
		ArrayList<Object> list3 = new ArrayList<>();
		list3.add(-13);
		list3.add(8);
		list2.add(list3);
		list.add(list2);
		System.out.println(findProductSum(list));
	}

}
