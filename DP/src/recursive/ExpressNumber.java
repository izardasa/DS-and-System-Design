package recursive;

public class ExpressNumber {

	private int countWays(int n)
	{
		if(n<=2)
			return 1;
		if(n==3)
			return 2;
		
		return countWays(n-1)+countWays(n-3)+countWays(n-4);
		
	}
	public static void main(String[] args) {
		ExpressNumber expressNumber = new ExpressNumber();
		System.out.println(expressNumber.countWays(4));
		System.out.println(expressNumber.countWays(5));

	}

}
