import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BeautifulMatrix
{

    public static void main( String[] args )
    {
        int[][] A = new int[5][5];
        Scanner scanner = new Scanner( System.in );
        for( int i = 0; i < 5; i++ )
        {
            String[] word = scanner.nextLine().split( " " );
            A[i] = Arrays.asList( word ).stream().mapToInt( Integer::parseInt ).toArray();
        }

        System.out.println( getMinMovoes( A ) );

    }

    private static int getMinMovoes( int[][] A )
    {
        int i=0,j=0;
        boolean is1Found = false;
        for( i=0;i<5;i++)
        {
            for( j=0;j<5;j++)
            {
                if(A[i][j]==1)
                {
                   
                    is1Found = true;
                    break;
                }
                
            }
            if(is1Found)
                break;
        }
        
        return Math.abs( i-2 )+Math.abs( j-2 );
    }

  
}
