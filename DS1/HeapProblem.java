import java.util.Scanner;

import ds.impl.Heap;

public class HeapProblem {

	public static void main(String[] args) {
		int[] A = new int[]{1,3,-1,-3,5,3,6,7};
		int w=3;
		int[] B = new int[A.length-w+1];
		
		for(int i=0;i<A.length-w+1;i++)
		{
			int max=-1;	
			for(int j=i;j<i+w;j++)
			{
				if(A[j]>max)
					max=A[j];
			}
			B[i] = max;
		}

		for(int i =0;i<B.length;i++)
		System.out.println(B[i]);
	}
	
	public void findMax2FromBillions()
	{
		int i=10;
		int count=1;
		int max1=-1;
		int max2=-1;
		int[] A= new int[10];
		while(i!=-1)
		{
			
			A[count-1] = i;
			if(count==10)
			{
				Heap h = new Heap(A.length,0);
				Heap.buildHeap(h, A, A.length);
				max1 = h.deleteMax();
				max2 = h.deleteMax();
				
				A[0] = max1;
				A[1] = max2;
				count=2;
			}
			Scanner scan = new Scanner(System.in);
			i  =Integer.valueOf(scan.nextLine());
			count++;
		}
		
		System.out.println("Max1 = "+max1+" Max2 = " +max2);
	}
	
	public void maxPairs()
	{
		int[] A = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		Heap h = new Heap(A.length, 0);
		Heap.buildHeap(h, A, A.length);

		int[] B = new int[] { 104, 39, 28, 47, 56, 25, 54, 23, 82, 91 };

		Heap h1 = new Heap(B.length, 0);
		Heap.buildHeap(h1, B, B.length);
		
		for(int i=0;i<B.length;i++)
		System.out.println(h.deleteMax()+" - "+h1.deleteMax());
		
	}

}
