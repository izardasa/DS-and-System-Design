import java.util.HashMap;
import java.util.Scanner;

public class FlippingGame
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] nums = new int[ n ];
        boolean allOnes = true;
        for( int i = 0; i < n; i++ )
        {
            nums[i] = s.nextInt();
            if(nums[i]!=1)
                allOnes = false;
        }
        
        if( allOnes )
        {
            System.out.println( n-1 );
            return;
        }
        else
        {
            int[] temp = new int[ n ];
            for( int i = 0; i < n; i++ )
            {
                temp[i] = 1 == nums[i] ? -1 : 1;
            }

            int[] res = new int[ n ];
            res[0] = temp[0] == -1 ? 0 : 1;
            int maxIndex = 0;
            int maxValue = Integer.MIN_VALUE;
            for( int i = 1; i < n; i++ )
            {
                if( temp[i] < temp[i] + res[i - 1] )
                    res[i] = temp[i] + res[i - 1];
                else
                    res[i] = temp[i] > 0 ? temp[i] : 0;

                if( maxValue <= res[i] )
                {
                    maxValue = res[i];
                    maxIndex = i;
                }
            }

            int minIndex = n - 1;
            boolean zeroFound = false;
            for( int i = maxIndex; i >= 0; i-- )
            {
                if( res[i] == 0 )
                {
                    minIndex = i;
                    zeroFound = true;
                    break;
                }
            }

            if( !zeroFound )
                minIndex = -1;

            for( int i = minIndex + 1; i <= maxIndex; i++ )
            {
                nums[i] = nums[i] == 0 ? 1 : 0;
            }

            int count = 0;
            for( int i = 0; i < n; i++ )
            {
                if( nums[i] == 1 )
                    count++;
            }
            System.out.println( count );
        }
    }

}
