package com.sanfotech.sorting;

public class Sorting
{

    public static void main( String[] args )
    {
        int A[] = new int[]{ 15, 2, 3, 1, 9, 5, 7, 8, 6 };
        int B[] = new int[]{ 15, 14, 12, 10, 6, 3, 2 };
        // mergeSort(A, 0, A.length - 1,new int[A.length]);

        System.out.println(  quickSearchKsmallest( B ,7));
//        for( int i = 0; i < B.length; i++ )
//        {
//            System.out.println( B[i] );
//        }

    }

    public static int quickSearchKsmallest( int[] A, int k )
    {
        int pos = k - 1;
        return quickSearchHelper( A, 0, A.length - 1, pos );

    }

    private static int quickSearchHelper( int[] A, int startIndex, int endIndex, int pos )
    {
        while( true )
        {
            int pivotIndex = startIndex;
            int leftIndex = pivotIndex + 1;
            int rightIndex = endIndex;

            while( leftIndex <= rightIndex )
            {
                if( A[pivotIndex] < A[leftIndex] && A[pivotIndex] > A[rightIndex] )
                    swap( leftIndex, rightIndex, A );

                if( A[pivotIndex] >= A[leftIndex] )
                    leftIndex++;

                if( A[pivotIndex] <= A[rightIndex] )
                    rightIndex--;
            }

            swap( pivotIndex, rightIndex, A );

            if(pos == rightIndex)
                return A[rightIndex];
            
            else if(rightIndex<pos)
                startIndex = rightIndex+1;
            
            else
                endIndex = rightIndex-1;
                
        }
    }

    public static void quickSortPivotLeft( int[] A )
    {
        quickSortHelper( A, 0, A.length - 1 );

    }

    private static void quickSortHelper( int[] A, int startIndex, int endIndex )
    {
        if( startIndex >= endIndex )
            return;

        int pivotIndex = startIndex;
        int leftIndex = pivotIndex + 1;
        int rightIndex = endIndex;

        while( leftIndex <= rightIndex )
        {
            if( A[pivotIndex] < A[leftIndex] && A[pivotIndex] > A[rightIndex] )
                swap( leftIndex, rightIndex, A );

            if( A[pivotIndex] >= A[leftIndex] )
                leftIndex++;

            if( A[pivotIndex] <= A[rightIndex] )
                rightIndex--;
        }

        swap( pivotIndex, rightIndex, A );

        boolean isLeftSubArraySmaller = rightIndex - 1 - startIndex < endIndex - ( rightIndex - 1 );

        if( isLeftSubArraySmaller )
        {
            quickSortHelper( A, startIndex, rightIndex - 1 );
            quickSortHelper( A, rightIndex + 1, endIndex );
        }
        else
        {
            quickSortHelper( A, rightIndex + 1, endIndex );
            quickSortHelper( A, startIndex, rightIndex - 1 );

        }
    }

    private static void swap( int pivotIndex, int rightIndex, int[] A )
    {
        int temp = A[pivotIndex];
        A[pivotIndex] = A[rightIndex];
        A[rightIndex] = temp;

    }

    public static void selectionSort( int[] array )
    {
        for( int i = 0; i < array.length - 1; i++ )
        {
            int smallestNumber = array[i];
            int smallestNumberIndex = i;
            for( int j = i + 1; j < array.length; j++ )
            {
                if( smallestNumber > array[j] )
                {
                    smallestNumber = array[j];
                    smallestNumberIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallestNumberIndex];
            array[smallestNumberIndex] = temp;

        }
    }

    public static void mergeSort( int[] array, int leftStart, int rightEnd, int[] temp )
    {
        if( leftStart >= rightEnd )
            return;

        int middle = ( rightEnd + leftStart ) / 2;
        mergeSort( array, leftStart, middle, temp );
        mergeSort( array, middle + 1, rightEnd, temp );
        mergeHalves( array, leftStart, rightEnd, temp );
    }

    private static void mergeHalves( int[] array, int leftStart, int rightEnd, int[] temp )
    {
        int leftEnd = ( leftStart + rightEnd ) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while( left <= leftEnd && right <= rightEnd )
        {
            if( array[left] < array[right] )
                temp[index++] = array[left++];
            else
                temp[index++] = array[right++];
        }

        while( left <= leftEnd )
            temp[index++] = array[left++];

        while( right <= rightEnd )
            temp[index++] = array[right++];

        System.arraycopy( temp, leftStart, array, leftStart, size );
    }

    public static void quickSort( int[] A, int left, int right )
    {
        if( left >= right )
            return;

        int pivot = A[( left + right ) / 2];
        int index = partition( A, left, right, pivot );
        quickSort( A, left, index - 1 );
        quickSort( A, index, right );
    }

    private static int partition( int[] A, int left, int right, int pivot )
    {
        while( left <= right )
        {
            while( A[left] < pivot )
                left++;
            while( A[right] > pivot )
                right--;

            if( left <= right )
            {
                int temp = A[left];
                A[left++] = A[right];
                A[right--] = temp;
            }
        }
        return left;
    }

}
