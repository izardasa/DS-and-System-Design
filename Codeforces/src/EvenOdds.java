import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EvenOdds
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long index = s.nextLong();

        
        long mid = n%2!=0?n/2+1:n/2;
        if(mid>=index)
            System.out.println( 2*index-1 );
        else
            System.out.println( 2*(index -mid ));
        
    }

}
