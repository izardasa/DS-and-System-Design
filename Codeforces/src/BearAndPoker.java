import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BearAndPoker
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int numWithoutFactors = 0;

        int num = s.nextInt();

        while( num % 2 == 0 )
        {
            num = num / 2;
        }

        while( num % 3 == 0 )
        {
            num = num / 3;
        }

        numWithoutFactors = num;
        boolean bidsCanBeEqual = true;
        for( int i = 1; i < n; i++ )
        {

            int currentNum = s.nextInt();

            while( currentNum % 2 == 0 )
            {
                currentNum = currentNum / 2;
            }

            while( currentNum % 3 == 0 )
            {
                currentNum = currentNum / 3;
            }

            if( numWithoutFactors != currentNum )
            {
                System.out.println( "NO" );
                bidsCanBeEqual = false;
                break;

            }
        }

        if( bidsCanBeEqual )
            System.out.println( "YES" );

    }

}
