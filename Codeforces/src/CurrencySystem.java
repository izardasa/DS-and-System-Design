import java.util.Scanner;

public class CurrencySystem
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
       int n = s.nextInt();
       
       int min = Integer.MAX_VALUE;
       for(int i=0;i<n;i++)
       {
           int num = s.nextInt();
           if(min>num)
               min= num;
       }
       
       if(min==1)
           System.out.println( -1 );
       else
       {
           
           System.out.println(1 );
       }
            
    }
}