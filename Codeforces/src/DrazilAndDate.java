import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DrazilAndDate
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int a = s.nextInt();
        int b = s.nextInt();
        int S = s.nextInt();
        
        int steps = Math.abs( a )+Math.abs( b );
        if(S<steps)
            System.out.println( "No" );
        else if((steps-S)%2==0)
            System.out.println( "Yes" );
        else
            System.out.println( "No" );
        
    }
}
