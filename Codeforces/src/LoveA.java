import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoveA
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int n =  scanner.nextInt() ;
        int k = scanner.nextInt();
        
        System.out.println( getCount(n,k) );
        
    }

    private static int getCount( int n, int k )
    {
        while(k-->0)
        {
            if(n%10==0)
            {
                n/=10;
            }
            else
            {
                n--;
            }
        }
        return n;
    }



}
