
public class MatrixPrintDiagonal {

	private static void printDiagonal(int[][] A)
	{
		int trow = A.length;
		int tcol = A[0].length;
		
		for (int k = 0; k < trow; k++) {
			for (int row = k, col = 0; col < tcol && row>=0; row--, col++) {
				System.out.print(A[row][col]+" ");
			}
			System.out.println();
		}
		
		for (int k = 1; k < tcol; k++) {
			for (int col = k, row=trow-1; col<tcol && row>=0; row--,col++) {
				System.out.print(A[row][col]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] A= new int[][]{
			{1,2,3,4,10},
			{5,6,7,8,20},
			{9,10,11,12,30},
			{13,14,15,16,40},
			{17,18,19,20,50},
			{21,22,23,24,60},
			{25,26,27,28,70},
		};

		printDiagonal(A);
	}

}
