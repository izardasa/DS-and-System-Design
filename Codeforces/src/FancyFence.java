import java.util.ArrayList;
import java.util.Scanner;

public class FancyFence
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();

        ArrayList<Integer> angles = new ArrayList<Integer>();
        for( int i = 3; i <= 1000; i++ )
        {
            double angle = ( ( i - 2 ) * 180 ) / (double)i;

            if( angle - (int)angle == 0.0 )

                angles.add( (int)angle );

        }

        while( t-- > 0 )
        {
            int n = s.nextInt();
            if( angles.contains( n ) )
                System.out.println( "YES" );
            else
                System.out.println( "NO" );
        }
    }
}
