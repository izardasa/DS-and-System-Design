import java.util.HashMap;

import ds.impl.Heap;

public class Search {

	public static void main(String[] args) {

		/*int n = 1000;
		int[] A = new int[1000];
		for (int i = 0; i < 500; i++) {
			Random rand = new Random();

			A[i] = -rand.nextInt(100000);
		}
		for (int i = 500; i < n; i++) {
			Random rand = new Random();

			A[i] = rand.nextInt(100000);
		}

		Heap h = new Heap(n, 0);
		h.heapSort(A, n);
		for (int i = 0; i < n; i++)
			System.out.println(A[i] + "   ");

		System.out.println(findFirstPositiveIntegerFromArray(A));*/
		
		//System.out.println(findLastOccurenceOfANumber(new int[]{1,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,5},4));
//		int[][]  A= {
//				{1,0,0,0,0},
//				{6,7,8,9,0},
//				{11,12,13,0,0},
//				{16,17,0,0,0},
//				{0,0,0,0,0}
//				
//		};
//		separate012(new int[]{0,0,0,1,1,1,2,2,2,2,0,0,0,1,1,1,2});
	

//		System.out.println(getMaxProfitInSharesBySelling2Times(new int[]{10,20,30,40,5,50}));
//		System.out.println(getMaxProfitInSharesBySelling2Times(new int[]{10,20,30,40,20,60,80}));
		System.out.println(findMinIntegerforMaxProductPartition(new long[]{1,2,3,4,5,6,1,1,1,1,2,3,10000}));
	}
	
	public static int findMinIntegerforMaxProductPartition(long[] numbers)
	{
		int n = numbers.length;
		
		if(n==1)
			return 0;
		
		int minIndex =0;
		long maxProductDiff = Long.MAX_VALUE;
		for(int i=0;i<n-1;i++)
		{
			long productFirstArray=1;
			
			for(int j=0;j<=i;j++)
			{
				productFirstArray = productFirstArray*numbers[j];
			}
			
			long productSecondArray=1;
			for(int j=i+1;j<n;j++)
			{
				productSecondArray = productSecondArray*numbers[j];
			}
			if(Math.abs(productFirstArray-productSecondArray)<maxProductDiff)
			{
				maxProductDiff = Math.abs(productFirstArray-productSecondArray);
				minIndex = i;
				
			}
		}
		return minIndex+1;
	}
	public static int getMaxProfitInSharesBySelling2Times(int[] price)
	{
		int n= price.length;
		int[] profit = new int[n];
		
		int maxPrice = price[n-1];
		int minPrice = price[0];
		
		
		for(int i = n-2;i>=0;i--)
		{
			if(price[i]>maxPrice)
				maxPrice = price[i];
			
			profit[i] = Integer.max(profit[i+1], maxPrice - price[i]);
		}
		
		for(int i=1;i<n;i++)
		{
			if(price[i]<minPrice)
				minPrice = price[i];
			
			profit[i] = Integer.max(profit[i-1], profit[i]+(price[i]-minPrice));
		}
		
		return profit[n-1];
	}
	
	public static void separate012(int[] A)
	{
		int n = A.length;
		
		if(n<3)
			return;
		
		int low=0,mid=0;
		int high = n-1;
		while(mid<=high)
		{
			switch(A[mid])
			{
			case 0:
				int temp = A[mid];
				A[mid++]= A[low];
				A[low++]= temp;
				break;
				
			case 1:
				mid++;
				break;
				
			case 2:
				temp = A[mid];
				A[mid]= A[high];
				A[high--] = temp;
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.print(A[i]+" ");
	}
	
	public static void separateEvenOddInArray(int[] A)
	{
		int N = A.length;
		if(N<=1)
			return;
		
		int left=0;
		int right = N-1;
		while(left<right)
		{
			while(A[left]%2==0 && left<right)
				left++;
			
			while(A[right]%2!=0 && left<right)
				right--;
			
			if(left<right)
			{
				int temp = A[left];
				A[left++]= A[right];
				A[right--]= temp;
			}
				
			
		}
		for(int i=0;i<N;i++)
		System.out.println(A[i]);
			
	}
	public static int countMax0sInARowIn2DArray(int[][] A)
	{
		int M = A.length;
		int N = A[0].length;
		
		int row = 0;
		int col = N-1;
		int zeroCount=0;
		while(col>=0 && row<N)
		{
			if(A[row][col]==0)
			{
				col--;
				zeroCount++;	
			}
			else
			{
				row++;
			}
		}
		
		return zeroCount;
	}
	
	public static int findElementinSortedRotatedArray(int[] A, int start, int end, int key)
	{
		int len = A.length;
		if(len==0)
			return -1;
		
		int pivot = findPivotIndex(A, start, end);
		if(A[pivot]==key)
			return pivot;
		if(key>=A[0])
			return binarySearch(A, 0, pivot-1,key);
		else
			return binarySearch(A, pivot+1, len-1,key);
	}
	private static int binarySearch(int[] A, int low, int high, int key) {
		while(low<=high)
		{
			
			
			int mid = low+(high-low)/2;
			if(A[mid]==key)
				return mid;
			if(A[mid]>key)
				high = mid-1;
			else
				low = mid+1;
			
		}
		
		return -1;
	}

	public static int findPivotIndex(int A[], int start, int end)
	{
		if(start==end)
			return start;
		
		if(start==end-1)
		{
			if(A[start]>=A[end])
				return start;
			return end;
		}
		else
		{
		int mid = start+(end-start)/2;
		if(A[mid]>=A[start])
			return findPivotIndex(A, mid, end);
		else
			return findPivotIndex(A, start, mid);
		}
	}
	
	public static int findLastOccurenceOfANumber(int[] A, int number)
	{
		int length = A.length;
		if(length==0)
			return -1;
		
		int low = 0;
		int high = length-1;
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(low==high && A[low]==number)
				return low;
			if(A[mid]==number && A[mid]<A[mid+1])
				return mid;
			
			if(A[mid]>number)
			{
				high = mid-1;
			}
			else
			{
				low = mid+1;
			}
				
			
		}
		return -1;
	}
	
	public static boolean findElementIn2DSortedArray(int[][] A, int number)
	{
		int M = A.length;
		int N = A[0].length;
		
		int row= M-1;
		int col= 0;
		
		int countScan=0;
		
		while(row>=0)
		{
			if(number==A[row][col])
			{
				System.out.println(number+" found at ("+row+","+col+") in "+countScan+" scan.");
				return true;
			}
			if(number>A[row][col])
			{
				for(col = 0;col<N;col++)
				{
					++countScan;
					if(number==A[row][col])
					{
						System.out.println(number+" found at ("+row+","+col+") in "+countScan+" scan.");
						return true;
					}		
					
				}
			}
			else
			{
				countScan++;
				col=0;
				row--;
			}
		}
		System.out.println(number +" not found in the matrix.");
		return false;
		
	}
	public static int findFirstOccurenceOfANumber(int[] A, int number)
	{
		int length = A.length;
		if(length==0)
			return -1;
		
		int low = 0;
		int high = length-1;
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(low==high && A[low]==number)
				return low;
			if(A[mid]==number && A[mid-1]<A[mid])
				return mid;
			
			if(A[mid]>=number)
			{
				high = mid-1;
			}
			else
			{
				low = mid+1;
			}
				
			
		}
		return -1;
	}

	public static int findFirstPositiveIntegerFromArray(int[] A) {

		int i = 1;
		int k = 0;
		for (i = 1; i < 31; i++) {
			k = 1 << i;
			if (A[k] > 0)
				break;
		}
		System.out.println((k >> 1)+ "  "+ k);
		return findFirstPositiveIntegerFromArrayUtil(A, (k >> 1), k);
	}

	public static int findFirstPositiveIntegerFromArrayUtil(int[] A, int first, int last) {

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (A[mid] == 0)
				return A[mid];
			if (A[first] == A[last] && A[last] > 0)
				return A[last];

			if (A[mid - 1] < 0 && A[mid] > 0)
				return A[mid];
			else if (A[mid - 1] < 0 && A[mid] < 0)
				first = mid + 1;
			else if (A[mid - 1] > 0 && A[mid] > 0)
				last = mid - 1;
			else
				return Integer.MIN_VALUE;

		}
		return -1;

	}

	public static int findMidPointInBitonousSequence(int[] A) {
		int n = A.length;
		if (n < 1)
			return -1;

		int first = 0, last = n - 1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (A[first] == A[last])
				return A[first];

			if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1])
				return A[mid];
			else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1])
				last = mid - 1;
			else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
				first = mid + 1;
			else
				return -1;
		}
		return -1;
	}

	public static void threeNumbersSumK(int[] A, int K) {
		int n = A.length;
		if (n < 3)
			return;

		Heap.heapSort(A, n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1, k = n - 1; j < k;) {
				int temp = A[i] + A[j] + A[k];
				if (temp == K) {
					System.out.println(A[i] + " + " + A[j] + "+" + A[k] + " = " + temp);
					return;
				}
				if (temp > K)
					k--;
				else
					j++;
			}
		}
		System.out.println("No sum found which is equal to " + K);
	}

	public static void sumClosesToZeroNLogN(int[] A) {
		int positiveClosest = Integer.MAX_VALUE;
		int negativeClosest = Integer.MIN_VALUE;

		int n = A.length;
		Heap h = new Heap(n, 0);
		Heap.heapSort(A, n);

		int i = 0, j = n - 1;
		while (i < j) {
			int temp = A[i] + A[j];
			if (temp > 0) {
				if (temp < positiveClosest) {
					positiveClosest = temp;

				}
				j--;
			} else if (temp < 0) {
				if (temp > negativeClosest)
					negativeClosest = temp;

				i++;
			} else
				System.out.println(A[i] + " + " + A[j] + " = " + temp);

			int closest = Math.abs(negativeClosest) > positiveClosest ? positiveClosest : negativeClosest;
			System.out.println(A[i] + " + " + A[j] + " = " + closest);
		}

	}

	public static int findMaxRepeatingNumberFrom0ToN_1(int[] A) {

		int n = A.length;
		if (n == 0)
			return -1;
		for (int i = 0; i < n; i++) {
			A[A[i] % n] += n;
		}

		int max = -1;
		int mi = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] / n > max) {
				max = A[i] / n;
				mi = i;
			}
		}
		System.out.println(mi + " repeated " + max + " times");
		return mi;
	}

	public static void find2NumbersWithSumK(int K, int[] A) {
		int n = A.length;
		Heap.heapSort(A, n);
		for (int i = 0, j = n - 1; i < j;) {
			int temp = A[i] + A[j];
			if (K == temp) {
				System.out.println(A[i] + " + " + A[j] + " = " + K);
				return;
			}
			if (temp < K)
				i++;
			else
				j--;
		}
		return;
	}

	public static void sumClosestToZero(int[] A) {
		int n = A.length;
		if (n < 2)
			return;
		int minSum = A[0] + A[1];
		int min_i = 0;
		int min_j = 0;
		for (int i = 0; i < n - 1; i++) {
			int sum = 0;
			for (int j = i + 1; j < n; j++) {
				sum = A[i] + A[j];
				if (Math.abs(minSum) > Math.abs(sum)) {
					minSum = sum;
					min_i = i;
					min_j = j;
				}
			}
		}

		System.out.println(A[min_i] + " + " + A[min_j] + " = " + minSum);
	}

	public static void find2NumbersWithSumKInMap(int K, int[] A) {
		int n = A.length;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(i, A[i]);

		}

		for (int i = 0; i < n; i++) {
			if (map.containsValue(K - A[i])) {
				System.out.println(A[i] + " + " + (K - A[i]) + " = " + K);
			}

		}
		return;
	}

}
