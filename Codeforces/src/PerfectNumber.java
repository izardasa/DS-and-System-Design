import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PerfectNumber
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int index = 0;

        for( int i = 10; i < Integer.MAX_VALUE; i++ )
        {
            int temp = i;
            int sumOfDigits = 0;
            while( temp > 0 )
            {
                sumOfDigits += ( temp % 10 );
                temp /= 10;
            }

            if( sumOfDigits == 10 )
            {
                index++;
                if( index == n )
                {
                    System.out.println( i );
                    break;
                }
            }
        }

    }
}
