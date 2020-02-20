import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CompatibleNumbers
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        int[] nums = new int[ n ];
        for( int i = 0; i < n; i++ )
            nums[i] = scanner.nextInt();

        HashMap<Integer, Integer> res = getCompatibleNumbers( nums );

        for( int i = 0; i < n; i++ )
            System.out.print( res.get( nums[i] )+" " );
    }

    private static HashMap<Integer, Integer> getCompatibleNumbers( int[] nums )
    {
        LinkedHashMap<Integer, Integer> res = new LinkedHashMap<Integer, Integer>();

        for( int i = 0; i < nums.length; i++ )
        {
            for( int j = 0; j < nums.length; j++ )
            {
                if( ( nums[i] & nums[j] ) == 0 && i != j && !res.containsKey( nums[i] ) )
                {
                    res.put( nums[i], nums[j] );
                    // res.put( nums[j], nums[i] );
                    break;
                }

            }
            if( !res.containsKey( nums[i] ) )
                res.put( nums[i], -1 );
        }
        return res;
    }

}
