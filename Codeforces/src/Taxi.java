import java.util.HashMap;
import java.util.Scanner;

public class Taxi
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        map.put( 1, 0 );
        map.put( 2, 0 );
        map.put( 3, 0 );

        for( int i = 0; i < n; i++ )
        {
            int num = s.nextInt();
            if( num == 4 )
                count++;
            else
            {
                int value = map.get( num );
                map.put( num, value + 1 );
            }
        }

        int min = minGroups( map, count );
        System.out.println( min );
    }

    private static int minGroups( HashMap<Integer, Integer> map, int count )
    {
        int threes = map.get( 3 );
        int twos = map.get( 2 );
        int ones = map.get( 1 );
        
        if(twos!=0)
        {
        count+=twos/2;
        twos%=2;
        }
        
        count+=( threes>ones)?ones:threes;
        
        if(threes>ones)
        {
            threes = threes-ones;
            ones=0;
            
        }
        else
        {
            ones = ones-threes;
            threes = 0;
            
        }
        
        
        if(threes!=0)
        {
            count+=(threes+twos);
            threes=0;
            twos=0;
        }
        if(ones!=0 || twos!=0)
        {
            int t = ones+twos*2; 
            if(t%4!=0)
                count+=(t/4)+1;
            else
                count+=(t/4);
        }
        return count;
    }

}