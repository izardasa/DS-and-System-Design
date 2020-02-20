import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ChatRoom
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        String str = s.next();

        int l = str.length();
        int hl = "hello".length();

        if( l < hl )
        {
            System.out.println( "NO" );
            return;
        }
        int i = 0;
        int j = 0;
        while( i < l && j < hl )
        {
            if(str.charAt( i )=="hello".charAt( j ))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(hl==j)
            System.out.println( "YES" );
        else
            System.out.println( "NO" );
      

    }

}
