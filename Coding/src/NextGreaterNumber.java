import java.util.Stack;

public class NextGreaterNumber {

	private static void findNextGreaterNumber(int[] A)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(A[0]);
		for (int i = 1; i < A.length; i++) {
			int num = stack.peek();
			if(A[i]<=num)
			{
				stack.push(A[i]);
			}
			else
			{
				while(!stack.isEmpty() && A[i]>stack.peek())
				{
					System.out.println(stack.pop() +"->"+ A[i]);
				}
				
				stack.push(A[i]);
			}
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop() + " -> NULL");
		}
	}
	public static void main(String[] args) {
		findNextGreaterNumber(new int[]{10,20,30,40,39,38,37,36,35,50,56,10,90});

	}

}
