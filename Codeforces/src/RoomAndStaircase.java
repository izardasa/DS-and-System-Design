import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class RoomAndStaircase
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int t = Integer.parseInt( scanner.nextLine());
        ArrayList<Integer> res = new ArrayList<Integer>();
        while( t-- > 0 )
        {
            int n =Integer.parseInt( scanner.nextLine());
            String rooms = scanner.nextLine();

            res.add( getTotalMoves( rooms ) );
        }

        for( Integer count : res )
        {
            System.out.println( count );
        }

    }

    private static int getTotalMoves( String rooms )
    {
        int maxDistanceOfStaircase = 0;
        int n = rooms.length();
        int count = 0;
        for( int i = 0; i < n; i++ )
        {
            if( rooms.charAt( i ) == '1' )
                count=i+1;
        }

        if( count > maxDistanceOfStaircase )
            maxDistanceOfStaircase = count;

        count = 0;
        for( int i = n - 1; i >= 0; i-- )
        {
            if( rooms.charAt( i ) == '1' )
                count=n-i;
        }

        if( count > maxDistanceOfStaircase )
            maxDistanceOfStaircase = count;

        if( maxDistanceOfStaircase == 0 )
            return n;
        else
            return maxDistanceOfStaircase * 2;
    }

}
