import java.util.Arrays;
import java.util.Scanner;

public class MatrixTranspose {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());
		int[][] A = new int[rows][cols];
		
		System.out.println("Enter first matrix size");
		for (int i = 0; i < rows; i++) {
			String[] nums = scanner.nextLine().split(" ");
			A[i] = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Enter 2nd matrix size");
		int rowsB = Integer.parseInt(scanner.nextLine());
		int colsB = Integer.parseInt(scanner.nextLine());
		int[][] B = new int[rowsB][colsB];
		for (int i = 0; i < rowsB; i++) {
			String[] nums = scanner.nextLine().split(" ");
			B[i] = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
		}
		
		int[][] result  = multiplication(A, B);
		
		

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		/*int[][] AT = transpose(A);
		for (int i = 0; i < AT.length; i++) {
			for (int j = 0; j < AT[0].length; j++) {
				System.out.print(AT[i][j] + " ");
			}
			System.out.println();
		}*/
	}

	public static int[][] multiplication(int[][] A, int[][] B) {
		int aRow = A.length;
		int aCol = A[0].length;
		int bRow = B.length;
		int bCol = B[0].length;
		int sum=0;
		
		
		/*3X2  X  2X2 = 3X2
		 * 
		 * 1 2 3      3 4         1x3+2x5+3x5    1x4+2x5+3x6  a00xb00+a01xb10+a02xb20   a00xb01+a01xb11+a02xb21
		 * 4 5 6      4 5         4x3+5x4+6x5    4x4+5x5+6x6  a10xb00+a11xb10+a12xb20   a10xb01+a11xb11+a12xb21
		 * 7 8 9      5 6         7x3+8x4+9x5    7x4+8x5+9x6  a20xb00+a21xb10+a22xb20   a20xb01+a21xb11+a22xb21
		 */
		int[][] res = new int[aRow][bCol];
		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < bCol; j++) {
				for (int k = 0; k < aCol; k++) {
					sum+=A[i][k]*B[k][j];
					System.out.print(A[i][k]+"x"+B[k][j]+" \t");
				}
				res[i][j] = sum;
				sum=0;
			}
			
		}
		System.out.println();
		return res;
	}

	public static int[][] transpose(int[][] A) {
		int rows = A[0].length;
		int cols = A.length;
		int[][] AT = new int[rows][cols];

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				AT[j][i] = A[i][j];
			}
		}
		return AT;
	}

}
