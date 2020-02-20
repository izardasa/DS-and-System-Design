package topdownwithmemorization;

public class Fibonacci {

	public static int fib(int n) {
		int[] F = new int[n + 1];

		return calculateFibRecursive(F, n);
	}

	public static int calculateFibRecursive(int[] dp, int n) {
		if (n < 2)
			return n;

		if (dp[n] != 0)
			return dp[n];

		dp[n] = calculateFibRecursive(dp, n - 1) + calculateFibRecursive(dp, n - 2);
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
	}

}
