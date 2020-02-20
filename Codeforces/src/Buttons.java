import java.util.Scanner;

public class Buttons
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
       int n = s.nextInt();
       
       int index=1;
       int total = 0;
       while(index<n)
       {
           total +=(index*(n-index));
           index++;
       }
       
       total+=n;
       System.out.println( total );
            
    }
}