import java.util.HashMap;
import java.util.Scanner;

public class OlesyaAndRodian
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        
        int n = s.nextInt();
        int t = s.nextInt();
        
        if(n==1 && t==10)
            System.out.println( -1 );
        else if(n>1 && t==10)
        {
            for(int i=0;i<n-1;i++)
            System.out.print( 1 );
            System.out.print( 0 );
        }
        else
        {
            for(int i=0;i<n;i++)
            System.out.print( t );
        }            
        
    }

}
