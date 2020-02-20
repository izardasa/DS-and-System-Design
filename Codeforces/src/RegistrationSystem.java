import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RegistrationSystem
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int t= s.nextInt();
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        while(t-->0)
        {
            
            getName( s.next(),map) ;
        }
    }

    private static void getName( String name ,HashMap<String,Integer> map)
    {
        if(!map.containsKey( name ))
        {
           map.put( name, 0 );
           System.out.println( "OK" );
        }
        else
        {
            int value = map.get( name );
            value = value+1;
            System.out.println( name+value );
            map.put( name, value );
        }
        
    }


}
