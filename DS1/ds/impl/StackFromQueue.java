package ds.impl;

public class StackFromQueue {
	ArrayQueue q1; ArrayQueue q2;
	int size;
	public StackFromQueue(ArrayQueue q1, ArrayQueue q2) 
	{
	this.q1 = q1;
	this.q2 = q2;
	size=0;
	}
	
	public int size()
	{
		return size;
	}
	
	public void push(int data)
	{
		size++;
		q2.enQueue(data);
		
		while(!q1.isEmpty())
		{
			q2.enQueue(q1.deQueue());
		}
		
		ArrayQueue q = q1;
		q1= q2;
		q2= q;
	}
	
	public int pop()
	{
		int data =-1;
		if(q1.isEmpty())
		{
			System.out.println("stack is empty");
			return data;
		}
		
		data = q1.deQueue();
		size--;
		
		return data;
	}
}
