package recursive;

public class Fibonacci {

	private int fibonacci(int n )
	{
		if(n<2)
			return n;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.fibonacci(2));
		System.out.println(fibonacci.fibonacci(4));
		System.out.println(fibonacci.fibonacci(6));

	}

}
