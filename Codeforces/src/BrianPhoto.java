import java.util.Scanner;

public class BrianPhoto
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int m = s.nextInt();
        boolean color = false;
        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < m; j++ )
            {
                String str = s.next();
                if( str.equals( "C") || str.equals(  "Y") || str.equals( "M")  )
                {
                    color = true;
                    break;
                }

            }
            if( color )
                break;
        }

        if( color )
            System.out.println( "#Color" );
        else
            System.out.println( "#Black&White" );
    }
}