package bottomupwithtabulation;

public class Fibonacci {

	public static int fib(int n) {
		int[] F = new int[n + 1];

		F[0] = 0;
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = F[i - 1] + F[i - 2];
		}
		return F[n];
	}

	public static int fibSpaceOptimized(int n) {

		if (n < 2)
			return n;
		
		int a =0, b=1;
		
		for (int i = 2; i <= n; i++) {
			int temp = a+b;
			a=b;
			b=temp;
		}
		
		return b;
	}

	public static void main(String[] args) {

		System.out.println(fibSpaceOptimized(1));
		System.out.println(fibSpaceOptimized(2));
		System.out.println(fibSpaceOptimized(3));
		System.out.println(fibSpaceOptimized(4));
		System.out.println(fibSpaceOptimized(5));
		System.out.println(fibSpaceOptimized(6));
		System.out.println(fibSpaceOptimized(7));

	}

}
