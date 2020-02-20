import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WaterMelon
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n= s.nextInt();
        
        if(n%2==0 && n>2)
            System.out.println( "YES" );
        else 
            System.out.println( "NO" );
        

    }

}
