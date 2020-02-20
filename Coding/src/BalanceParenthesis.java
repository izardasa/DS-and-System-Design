import java.util.Stack;

public class BalanceParenthesis {
	private static boolean isBalanced(String S)
	{
		Stack<Character> stack = new Stack();
		int n = S.length();
		for (int i = 0; i < n; i++) 
		{
			char c = S.charAt(i);
			if(stack.isEmpty() &&  (c==']' || c=='}' || c==')'))
				return false;
			if(c=='(' || c=='[' || c=='{')
				stack.push(c);
			else if(c==')' && stack.peek()=='(')
				stack.pop();
			else if(c=='}' && stack.peek()=='{')
				stack.pop();
			else if(c==']' && stack.peek()=='[')
				stack.pop();
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("{[{}]}[]{}"));

	}

}
