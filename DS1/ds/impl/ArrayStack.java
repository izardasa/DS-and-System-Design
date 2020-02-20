package ds.impl;

public class ArrayStack {

	int capacity;
	int top;
	private int[] array;

	public ArrayStack() {
		capacity = 1 << 3;
		array = new int[capacity];
		top = -1;
	}

	public void push(int number) {
		if (isFull()) 
			doubleArray();
		array[++top] = number;
	}

	public int pop() {
		if (isEmpty()) 
		{
			System.out.println("Stack is empty.");
			return -1;
		}

		return array[top--];

	}

	public int getSize() {
		return top+1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull(){
		return top==capacity-1;
	}
	
	private void doubleArray()
	{
		int[] newArray = new int[capacity*2];
		System.arraycopy(array, 0, newArray, 0, capacity);
		capacity*=2;
		array = newArray;
	}
	
	
}
