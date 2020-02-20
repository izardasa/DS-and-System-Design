package recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTriplets {

	private static int findTriplets(List<Integer> list, int k)
	{
		Integer[] A = (Integer[])list.toArray(new Integer[list.size()]);
		Map<String,Integer> map = new HashMap<String,Integer>();
		return findTriplets(A, k, 0, 0,0,map);
	}
	private static int findTriplets(Integer[] A, int k, int currentIndex, int sum, int count,Map<String, Integer> map) {
		if(count==3 && sum<=k)
			return 1;
		
		 
		if(currentIndex>=A.length || count>3)
			return 0;
		
		int include = 0;
		int exclude=0;
		String key = currentIndex+"|"+count;
		if(map.get(key)==null)
		{
		 include = findTriplets(A, k,currentIndex+1, sum+A[currentIndex],count+1,map);
		 exclude = findTriplets(A, k,currentIndex+1, sum,count,map);
		 map.put(key, include+exclude);
		}
		return map.get(key);
		
	}
	public static void main(String[] args) {
		FindTriplets triplets = new FindTriplets();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(findTriplets(list, 8));

	}

}
