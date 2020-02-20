
public class MyStack {
	int[] arrayStack;
	String[] minMaxStack;
	int currentIndex=0;
	int capacity ;
	int min = Integer.MAX_VALUE;
	int max =Integer.MIN_VALUE;
	public MyStack(int size) {
		capacity = size;
		arrayStack = new int[size];
		minMaxStack = new String[size];
	}

	public void push(int item)
	{
		if(currentIndex==capacity)
		{
			System.out.println("Stack is full. You cannot insert more elements.");
			return;
		}
		else
		{
		arrayStack[currentIndex] = item;
		}
		
		if(min>item)
			min = item;
		if(max<item)
			max =item;
		
		minMaxStack[currentIndex] = min+":"+max;
		currentIndex++;
	}
	
	public int pop()
	{
		int item ;
		if(currentIndex==-1)
		{
			System.out.println("Stack is empty and you cannot pop more elements.");
			return Integer.MIN_VALUE;
		}
		else
		{
			item = arrayStack[--currentIndex];
		}
		return item;
	}
	
	public int peek()
	{
		if(currentIndex==-1)
		{
			System.out.println("Stack is empty. Peek option is not allowed until we have some element is the stack");
			return Integer.MIN_VALUE;
		}
		return arrayStack[currentIndex-1];
	}
	
	public int max()
	{
		if(currentIndex==-1)
		{
			System.out.println("Stack is empty. Max otion is not allowed when stack is empty.");
			return Integer.MIN_VALUE;
		}
		
		String minmax = minMaxStack[currentIndex-1];
		return Integer.parseInt(minmax.split(":")[1]);
	}
	
	public int min()
	{
		if(currentIndex==-1)
		{
			System.out.println("Stack is empty. Min otion is not allowed when stack is empty.");
			return Integer.MIN_VALUE;
		}
		
		String minmax = minMaxStack[currentIndex-1];
		return Integer.parseInt(minmax.split(":")[0]);
	}
	public static void main(String[] args) {

		MyStack stack = new MyStack(5);
		stack.push(5);
		stack.push(2);
		stack.push(7);
		stack.push(40);
		stack.push(30);
		System.out.println(stack.peek());
		System.out.println(stack.max());
		System.out.println(stack.min());
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.max());
		System.out.println(stack.min());
	
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.max());
		System.out.println(stack.min());
	
	}

}
