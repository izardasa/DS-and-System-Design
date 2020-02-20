import java.util.HashMap;
import java.util.Scanner;

public class PaymentWithoutChange
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int t= s.nextInt();
        
        while(t-->0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            int S = s.nextInt();
            
            boolean found= false;
            for(int i=1;i<=a;i++)
            {
                int diff = S- i*n;
                
                if(diff<=b && diff>0)
                {
                    found = true;
                    break;
                }
            }
            
            if(found)
                System.out.println( "YES" );
            else
                System.out.println( "NO" );
        }
        
    }

}
