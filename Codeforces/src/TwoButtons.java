import java.util.ArrayList;
import java.util.Scanner;

public class TwoButtons
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int m = s.nextInt();
        
        int count=0;
        
        if(m<=n)
            count=(n-m);
        else
        {
            while(n*2<m)
            {
                n=n*2;
                count++;
            }
            
            if(m%2!=0)
            {
                int halfM =m/2+1;
                int doubleN = 2*n;
                if(n-halfM>doubleN-m)
                {
                    count=count+(doubleN-m)+1;
                }
                else
                {
                    count=count+(n-halfM)+2;
                }
            }
            else
            {
                int halfM = m/2;
                int doubleN = 2*n;
                
                if(n-halfM>doubleN-m)
                {
                    count=count+(doubleN-m)+1;
                }
                else
                {
                    count=count+(n-halfM)+1;
                }
            }
           
               
        }
        
        System.out.println( count );
                        
    }
}
