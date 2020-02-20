package ds.impl;

import java.security.PermissionCollection;

public class Heap {

	public int[] array = null;
	int count;
	int capacity;
	int type;

	public Heap(int size, int type) {
		this.capacity = size;
		this.type = type;
		this.array = new int[size];
		count = 0;
	}

	public int parent(int i) {
		if (i <= 0 || i == this.count)
			return -1;
		return (i - 1) / 2;
	}

	public int leftChild(int i) {
		int leftChild = 2 * i + 1;
		if (leftChild <= 0 || leftChild >= this.count)
			return -1;
		return leftChild;
	}

	public int rightChild(int i) {
		int rightChild = 2 * i + 2;
		if (rightChild <= 0 || rightChild >= this.count)
			return -1;
		return rightChild;
	}

	public void percolateDown(int n) {
		int max = -1;
		int leftChild = leftChild(n);
		int rightChild = rightChild(n);
		
		if(leftChild==-1 && rightChild==-1)
			return;
		if (leftChild != -1 && array[leftChild] > array[n])
			max = leftChild;
		else
			max = n;

		if (rightChild != -1 && array[rightChild] > array[max])
			max = rightChild;

		if(max==n)
			return;
		if (max != -1) {
			int temp = array[n];
			array[n] = array[max];
			array[max] = temp;
			percolateDown(max);
		}

	}

	public int deleteMax() {
		if (count <= 0)
			return -1;
		int temp = array[0];
		array[0] = array[count - 1];
		count--;
		percolateDown(0);
		return temp;
	}

	public void insert(int data) {
		if (count == capacity)
			resizeHeap();
		count++;
		int i = count - 1;

		while (i >= 0 && data > array[(i - 1) / 2]) {
			array[i] = array[(i - 1) / 2];
			i = (i - 1) / 2;

		}
		array[i] = data;
	}

	public void resizeHeap() {
		int[] old_array = new int[capacity];

		System.arraycopy(array, 0, old_array, 0, count - 1);
		array = new int[capacity * 2];
		if (array == null) {
			System.out.println("Memory not enough.");
		}

		for (int i = 0; i < count; i++) {
			array[i] = old_array[i];
		}
		capacity = capacity * 2;
		old_array = null;
	}

	public void destroy() {
		count = 0;
		array = null;
	}

	public static void buildHeap(Heap h, int[] A, int n) {
		if (h == null)
			return;
		if (h.capacity < n)
			h.resizeHeap();

		for (int i = 0; i < n; i++) {
			h.array[i] = A[i];
		}
		
		h.count = n;

		for (int i = (n - 1) / 2; i >= 0; i--) {
			h.percolateDown(i);
		}
	}

	public static void heapSort(int[] A, int n) {
		Heap h = new Heap(n, 0);
		int temp ;
		buildHeap(h, A, n);

		int old_size = h.count;
		
		for (int i = n - 1; i >= 0; i--) 
		{
			temp = h.array[0];
			h.array[0] = h.array[h.count - 1];
			h.array[h.count - 1] = temp;

			h.count--;
			h.percolateDown(0);
			
		}
		h.count =old_size;
		
		for(int i=0;i<n;i++)
		{
			A[i]=h.array[i];
		}
	}
}
