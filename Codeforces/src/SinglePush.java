import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SinglePush
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] a = new int[ n ];

        for( int i = 0; i < n; i++ )
            a[i] = s.nextInt();

        findNumberOfEvents( a, n );

    }

    private static void findNumberOfEvents( int[] a, int n )
    {

        HashMap<Integer, Character> map = new HashMap<Integer, Character>();

        int count = 1;
        int days = 0;
        int daysIndex = 0;
        int preIndex=0;
        
        if(n%2!=0)
        {
            System.out.println( "-1" );
            return;
        }
        ArrayList<Integer> dayList = new ArrayList<Integer>();
        for( int i = 0; i < n; i++ )
        {
            if( a[i] > 0 )
            {
                if( map.containsKey( a[i] ) )
                {
                    char c = map.get( a[i] );
                    if( c == 'O' )
                    {
                        days = -1;
                        break;
                    }
                    else
                    {
                        for( int key : map.keySet() )
                        {
                            if( map.get( key ) != 'C' )
                            {
                                days = -1;
                                break;
                            }
                        }
                        map.put( a[i], 'O' );
                        count++;
                        dayList.add( i-preIndex );
                        preIndex=i;
                    }
                }
                else
                {
                    map.put( a[i], 'O' );
                }
            }
            else
            {
                if( !map.containsKey( Math.abs( a[i] ) ) )
                {
                    days = -1;
                    break;
                }
                else
                {
                    if( map.get( Math.abs( a[i] ) ) == 'C' )
                    {
                        days = -1;
                        break;
                    }
                    else
                    {
                        map.put( Math.abs( a[i] ), 'C' );
                    }
                }
            }

        }
        if( days == -1 )
            System.out.println( "-1" );
        else
        {
            
            for(int k : map.keySet())
            {
                if(map.get( k )=='O')
                {
                    System.out.println( "-1" );
                    return;
                }
            }
            
            dayList.add( n-preIndex );
            System.out.println( count );
            StringBuffer  sb = new StringBuffer();
            
            for(Integer num : dayList)
                sb.append( num+" " );
            
            System.out.print( sb.deleteCharAt( sb.length()-1 ) );

        }

    }

}
