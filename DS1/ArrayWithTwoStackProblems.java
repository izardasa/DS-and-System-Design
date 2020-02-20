import ds.impl.ArrayWithTwoStacks;

public class ArrayWithTwoStackProblems {

	public static void main(String[] args) {
		ArrayWithTwoStacks stack = new ArrayWithTwoStacks(10);
		stack.push(1, 10);
		stack.push(1, 20);
		stack.push(1, 30);
		stack.push(1, 40);

		stack.push(2, 100);
		stack.push(2, 200);
		stack.push(2, 300);
		stack.push(2, 400);
		
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.top(2));
		System.out.println(stack.pop(2));
	}

}
