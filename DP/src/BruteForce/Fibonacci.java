package BruteForce;

public class Fibonacci {

	public static int fib(int n)
	{
		if(n<2)
			return 1;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) {
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		
	}

}
