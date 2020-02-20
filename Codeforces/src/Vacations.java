import java.util.HashMap;
import java.util.Scanner;

public class Vacations
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        
        int pre = s.nextInt();
        int count=0;
        if(pre==0)
            count++;
        
        for(int i=0;i<n-1;i++)
        {
            int current = s.nextInt();
           if(pre==1 && current==1)
           {
               current=0;
               count++;
           }
           else if(pre==2 && current==2)
           {
               current=0;
               count++;
           }
           else if(pre==1 && current==3)
           {
               current=2;
           }
           else if(pre==2 && current==3)
           {
               current=1;
           }
           else if(current==0)
           {
               count++;
           }
           
        pre = current;
           
           
        }
        System.out.println( count );
        
    }

}
