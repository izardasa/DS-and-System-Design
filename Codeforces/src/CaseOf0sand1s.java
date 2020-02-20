import java.util.HashMap;
import java.util.Scanner;

public class CaseOf0sand1s
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        
        String str = s.next();
        int zeros=0;
        int ones = 0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt( i )=='0')
                zeros++;
            else
                ones++;
        }
        
        System.out.println( Math.abs( zeros - ones ) );
    }

}
