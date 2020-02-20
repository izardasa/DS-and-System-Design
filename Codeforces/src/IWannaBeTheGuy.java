import java.util.HashSet;
import java.util.Scanner;

public class IWannaBeTheGuy
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();

        HashSet<Integer> set = new HashSet<Integer>();
        int p = s.nextInt();
        for( int i = 0; i < p; i++ )
            set.add( s.nextInt() );
        int q = s.nextInt();
        for( int i = 0; i < q; i++ )
            set.add( s.nextInt() );

        if( set.size() == t )
            System.out.println( "I become the guy." );
        else
            System.out.println( "Oh, my keyboard!" );

    }

}
