package ds.impl;

public class ArrayQueue {

	private int front;
	private int rear;
	private int[] array;
	private int capacity;

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		rear = -1;
		front = -1;
		array = new int[capacity];
	}

	public ArrayQueue createQueue(int capacity) {
		return new ArrayQueue(capacity);
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return ((rear + 1) % capacity) == front;
	}

	public int size() {
		return (capacity - front + rear + 1) % capacity;
	}

	public void enQueue(int data) {
		if (isFull()) {
			resizeQueue();
		}

		rear = (rear + 1) % capacity;
		array[rear] = data;

		if (front == -1)
			front = rear;

	}
	
	public void resizeQueue()
	{
		int[] oldArray = array;
		int initialCapcity = capacity;
		array = new int[capacity*2];
		capacity*=2;
	
		for(int i=0;i<oldArray.length;i++)
			array[i] = oldArray[i];
		
		if(rear<front)
		{
			for(int i=0;i<front;i++)
			{
				array[i+initialCapcity] = array[i];
				array[i] = 0;
			}
			
			rear = rear+initialCapcity;
		}
	}

	public int deQueue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty. Can't dequeue.");
			return data;
		}

		data = array[front];
		if (front == rear) {
			front = rear = -1;
		} else {
			front = (front + 1) % capacity;
		}
		
		return data;
	}

}
