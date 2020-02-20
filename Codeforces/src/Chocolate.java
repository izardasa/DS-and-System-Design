import java.util.Scanner;

public class Chocolate
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n =Integer.parseInt(  s.nextLine() );

        long ways =1;
        long count=1;
        boolean started = false;
        for(int i=0;i<n;i++)
        {
            //System.out.println( s.nextInt() );
            int piece = s.nextInt();
          
            if(started && piece==0)
            {
                count++;
            }
            if(started && piece==1)
            {
                ways*=count;
                count=1;
            }
            if(piece==1)
            {
                started = true;
            }
            
        }
        
        if(started==false)
               ways=0;
        System.out.println( ways );

    }

}
