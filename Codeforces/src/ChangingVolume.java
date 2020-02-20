import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ChangingVolume
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int t = s.nextInt();

        while( t-- > 0 )
        {
            int a = s.nextInt();
            int b = s.nextInt();

            int diff = Math.abs( a-b );
            
            int count=0;
            
            count+=diff/5;
            diff%=5;
            
            count+=diff/2;
            diff%=2;
            
            count+=diff;
            
            System.out.println( count );
        }
    }

}
