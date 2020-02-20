import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestockingTheWarehouse
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        List<Integer> nums = new ArrayList<Integer>();
        for( int i = 0; i < n; i++ )
        {
            nums.add( s.nextInt() );

        }
        int target = s.nextInt();
        
        System.out.println( restock( nums, target ) );

    }

    public static int restock( List<Integer> itemCount, int target )
    {
        BigDecimal sum = new BigDecimal( 0 );
        for( int i : itemCount )
        {
            sum = sum.add( new BigDecimal( i ) );
            if(sum.longValue()>=(long)target)
                break;
        }

        long sumL = sum.longValue();
        return Math.abs( (int)( sumL - (long)target ) );

    }

}