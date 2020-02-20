package recursive;

public class CountWays {
	
	private int countWays(int n)
	{
		if(n==0)
			return 1;
		
		if(n==1)
			return 1;
		
		if(n==2)
			return 2;
		
		
		return countWays(n-1)+countWays(n-2)+countWays(n-3);
	}

	public static void main(String[] args) {
		
		CountWays countWays = new CountWays();
		System.out.println(countWays.countWays(3));
		System.out.println(countWays.countWays(4));
		System.out.println(countWays.countWays(5));

	}

}
