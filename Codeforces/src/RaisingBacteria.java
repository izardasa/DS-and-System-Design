import java.util.Scanner;

public class RaisingBacteria
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
       
        int n = s.nextInt();

        int count=0;
        while(n>0)
        {
        if((n&1)==1)
            count++;
        
        n>>=1;
        }
        System.out.println( count);
     
        
        
    }

}
