import ds.model.MyMap;

public class HashMapProblem {

	public static void main(String[] args) {
		MyMap<Integer,String> map = new MyMap<Integer,String>();
		map.put(10, "sanjay");
		map.put(20, "rajesh");
		map.put(30, "kishan");
		map.put(40, "ravi");
		map.put(50, "bhupesh");
		map.put(60, "yakub");
		map.put(20, "sanjana");
		map.put(80, "vandana");
		
		
		System.out.println(map.getSize());
		System.out.println(map.get(60));

	}

}
