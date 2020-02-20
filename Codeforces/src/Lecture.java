import java.util.HashMap;
import java.util.Scanner;

public class Lecture
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int m = s.nextInt();
        HashMap<String, String> map = new HashMap<String, String>();

        while( m-- > 0 )
        {
            map.put( s.next(), s.next() );
        }

        String[] word = new String[ n ];
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < n; i++ )
        {
           String key = s.next();
           String value = map.get( key );
           if(key.length()<=value.length())
               sb.append( key +" ");
           else
               sb.append( value+" " );
        }
        
        System.out.println( sb );

    }
}