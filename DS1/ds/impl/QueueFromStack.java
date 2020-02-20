package ds.impl;

import java.util.Queue;

public class QueueFromStack {

	public ArrayStack stack1;
	public ArrayStack stack2;
	public QueueFromStack(ArrayStack stack1, ArrayStack stack2 ){
		this.stack1 = stack1;
		this.stack2 = stack2;
	}
	
	public void enqeue(int data)
	{
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		
		stack1.push(data);
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}
	
	public int dequeue()
	{
		if(stack1.isEmpty())
			System.out.println("Queue is empty.");
		
		return stack1.pop();
	}
}
