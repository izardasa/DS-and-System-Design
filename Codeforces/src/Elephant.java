import java.util.Scanner;

public class Elephant
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        String prefix = "I hate";
        String suffix = " it";
        
        StringBuilder midStr = new StringBuilder();
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
                midStr.append( " that I love" );
            else
                midStr.append( " that I hate" );
        }
        
        System.out.println( prefix + midStr+suffix );

    }

}
