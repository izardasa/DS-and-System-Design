import java.util.Scanner;

public class Hulk
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int distance = s.nextInt();

        if( distance <= 5 )
            System.out.println( 1 );
        else
        {
            if( distance % 5 == 0 )
                System.out.println( distance / 5 );
            else
                System.out.println( ( distance / 5 ) + 1 );
        }

    }

}
