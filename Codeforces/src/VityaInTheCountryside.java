import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class VityaInTheCountryside
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int secLast = 0;
        int last = 0;
        for( int i = 0; i < n; i++ )
        {
            int num = s.nextInt();
            if( i == ( n - 2 ) )
                secLast = num;

            if( i == ( n - 1 ) )
                last = num;
        }

        
        if(n==1 && last==15)
            System.out.println( "DOWN" );
        else if(n==1 && last==0)
            System.out.println( "UP" );
        else if( n == 1 && last!=15)
            System.out.println( -1 );
        else
        {
            if(last==15)
                System.out.println( "DOWN" );
            else if(last==0)
                System.out.println( "UP" );
            else
            {
                if(last>secLast)
                    System.out.println( "UP" );
                else
                    System.out.println( "DOWN" );
            }

        }
    }
}
