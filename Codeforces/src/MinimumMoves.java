import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumMoves
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int a = s.nextInt();
        List<Integer> aList = new ArrayList<Integer>();
        for( int i = 0; i < a; i++ )
        {
            aList.add( s.nextInt() );
        }

        int b = s.nextInt();
        List<Integer> bList = new ArrayList<Integer>();
        for( int i = 0; i < b; i++ )
        {
            bList.add( s.nextInt() );
        }

        System.out.println( minimumMoves( aList, bList ) );

    }

    public static int minimumMoves( List<Integer> a, List<Integer> m )
    {
        int countOperation = 0;

        int n = a.size();

        for( int i = 0; i < n; i++ )
        {
            int numA = a.get( i );
            int numM = m.get( i );

            while( numA > 0 )
            {
                countOperation += Math.abs( numA % 10 - numM % 10 );
                numA /= 10;
                numM /= 10;
            }
        }
        return countOperation;

    }
}
