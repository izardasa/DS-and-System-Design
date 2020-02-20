import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CheapTravel
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int m =s.nextInt();
        int a = s.nextInt();
        int b= s.nextInt();
        
        int cost = 0;
        
        int rem  = n%m;
        int div = n/m;
        
        cost = div*b+rem*a;
        int cost1 = (div+1)*b;
        int cost2= n*a;
        
        int minCost =Math.min( Math.min( cost1, cost2 ),cost);
        System.out.println( minCost);
    }

}
