package ds.impl;

import ds.model.LLNode;

public class LLStack {
	LLNode head;

	public void push(int n) {
		LLNode node = new LLNode(n);
		if (head == null)
			head = node;
		else {
			node.setNext(head);
			head = node;
		}
	}

	public int pop() 
	{
		int data = -1;
		if (head != null) {

			data = head.getValue();
			head = head.getNext();
		} else {
			System.out.println("No elements found.");
		}
		return data;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int getSize(){
		int count=0;
		LLNode temp = head;
		while(temp!=null)
		{
			temp= temp.getNext();
			count++;
		}
		return count;
	}

}
