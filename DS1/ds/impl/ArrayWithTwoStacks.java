package ds.impl;

public class ArrayWithTwoStacks {
	int top1;
	int top2;
	int size;
	int[] array;

	public ArrayWithTwoStacks(int size) {
		top1 = -1;
		top2 = size;
		this.size = size;
		array = new int[size];
	}

	public void push(int stackId, int data) {
		if (1 == stackId) {
			if (isFull(stackId)) {
				System.out.println("Stack is full. Can't push");
				return;
			}

			array[++top1] = data;

		} else {
			if (isFull(stackId)) {
				System.out.println("Stack is full. Can't insert");
				return;
			}

			array[--top2] = data;
		}
	}

	public boolean isEmpty(int stackId) {
		if (1 == stackId)
			return top1 == -1;
		else
			return top2 == size;
	}

	public boolean isFull(int stackId) {
		if (1 == stackId) {
			if (top1 + 1 == top2)
				return true;
		} else {
			if (top2 - 1 == top1)
				return true;
		}
		return false;
	}

	public int pop(int stackId) {
		int data = Integer.MIN_VALUE;
		if (isEmpty(stackId)) {
			System.out.println("Stack is empty.");
		} else {
			if (1 == stackId) {
				data = array[top1--];
			} else {
				data = array[top2++];
			}
		}

		return data;
	}
	public int top(int stackId)
	{
		int data= Integer.MIN_VALUE;
		if(isEmpty(stackId))
		{
			System.out.println("Stack is empty");
			return data;
		}
		if(1==stackId)
		{
			data = array[top1];
		}
		else
		{
			data = array[top2];
		}
		
		return data;
	}
}
