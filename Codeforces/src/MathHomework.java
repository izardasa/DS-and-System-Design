import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class MathHomework
{

    public static void main( String[] args ) throws IOException
    {
        Scanner s = new Scanner( System.in );
        int threshold = s.nextInt();
        int n = s.nextInt();
        List<Integer> aList = new ArrayList<Integer>();

        for( int i = 0; i < n; i++ )
            aList.add( s.nextInt() );

        System.out.println( minNum( threshold, aList ) );

    }

    public static int minNum( int threshold, List<Integer> points )
    {
        int minPoint = points.get( 0 );
        int maxPoint = points.get( 0 );
        int count = 1;

        int i = 0;
        int n = points.size();

        while( i < n )
        {
            int diff = maxPoint - minPoint;
            if( threshold <= diff )
                return count;

            if( threshold > diff && i+1<n && (points.get( i + 1 )-minPoint) >= threshold )
            {
                return ++count;
            }

            if( i + 2 < n )
            {
                maxPoint = points.get( i + 2 );
                i += 2;
                count++;
            }
            else
            {
                return n;
            }
        }

        return count;

    }

}