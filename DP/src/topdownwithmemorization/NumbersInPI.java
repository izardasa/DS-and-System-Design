package topdownwithmemorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersInPI
{
    private static int getMinSpaces( String pi, ArrayList<Integer> numbers )
    {
        Set<Integer> numbersInPI = new HashSet<Integer>();
        for( Integer num : numbers )
            numbersInPI.add( num );

        Integer[] dp = new Integer[ pi.length() ];
        int minSpace = getMinSpaces( pi, numbersInPI, dp, 0 );
        
        return minSpace==Integer.MAX_VALUE?-1:minSpace;

    }

    private static int getMinSpaces( String pi, Set<Integer> numbersInPI, Integer[] dp, int currentIndex )
    {
        if( currentIndex == pi.length() )
            return -1;

        if( dp[currentIndex] != null )
            return dp[currentIndex];

        int minSpace = Integer.MAX_VALUE;
        for( int i = currentIndex; i < pi.length(); i++ )
        {
            if( numbersInPI.contains( Integer.parseInt( pi.substring( currentIndex, i + 1 ) ) ) )
            {
                int minSpacesInSuffix = getMinSpaces( pi, numbersInPI, dp, i+1 );
                minSpace = Integer.min( minSpace, minSpacesInSuffix+1 );
            }
        }

        dp[currentIndex] = minSpace;
        return dp[currentIndex];
    }

    public static void main( String[] args )
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add( 31 );
        list.add( 41 );
        list.add( 9 );
        list.add( 2 );
        list.add( 5 );
        list.add( 314159 );

        System.out.println( getMinSpaces( "3141592", list ) );
    }

}
