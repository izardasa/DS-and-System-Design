package bottomupwithtabulation;

public class MaxSquareSubMatrix {

	private static int findMaxSquareSubMatrixWith1s(int[][] A)
	{
		int row = A.length;
		int col = A[0].length;
		int[][] B= new int[row][col];
		int maxSquareSubMatrix = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(i==0 || j==0)
				B[i][j] = A[i][j];
			}
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if(A[i][j]==1)
				{
					B[i][j]= Math.min(Math.min(B[i-1][j], B[i][j-1]),B[i-1][j-1])+1;
					if(maxSquareSubMatrix<B[i][j])
						maxSquareSubMatrix = B[i][j];
				}
			}
		}
		
		return maxSquareSubMatrix;
	}
	public static void main(String[] args) {
		int[][] A = new int[][]{
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1}
		};
		
		System.out.println(findMaxSquareSubMatrixWith1s(A));

	}

}
