import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ThreatreQuare
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int m = s.nextInt();
        int a = s.nextInt();
        
        int count = n/a;
        if(n%a!=0)
            count+=1;
        
        int count1 = m/a;
        if(m%a!=0)
            count1+=1;
        
        System.out.println( (long)count*(long)count1 );

    }

}
