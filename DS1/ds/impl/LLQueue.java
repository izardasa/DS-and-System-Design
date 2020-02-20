package ds.impl;

import ds.model.LLNode;

public class LLQueue {

	private LLNode front;
	private LLNode rear;
	
	public LLQueue(){
		front = null;
		rear= null;
	}
	
	public static LLQueue createQueue()
	{
		return new LLQueue();
	}
	
	public void enqueue(int data){
		LLNode node = new LLNode(data);
		
		if(rear==null)
		{
			rear =  node; 
		}
		else
		{
			rear.setNext(node);
			rear = rear.getNext();
		}
		
		if(front==null)
			front = node;
		
	}
	
	public boolean isEmpty(){
		return front==null;
	}
	
	public int dequque()
	{
		int data =-1;
		if(front==null)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		else
		{
			data= front.getValue();
			front = front.getNext();
		}
		return data;
		
	}
}
