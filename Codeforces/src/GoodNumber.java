import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GoodNumber
{

    public static void main( String[] args )
    {
        // System.out.println( Long.MAX_VALUE );
        // getMinNumberIn3Pow(1000000000000000000L);
      
        
        Scanner scanner = new Scanner( System.in );
        int t = Integer.parseInt( scanner.nextLine() );
        ArrayList<BigDecimal> res = new ArrayList<BigDecimal>();
        while( t-- > 0 )
        {
            long number = Long.parseLong( scanner.nextLine() );
            res.add( getGoodNumber( number ) );

        }

        for( BigDecimal goodNumber : res )
        {
            System.out.println( goodNumber );
        }

    }

    private static BigDecimal getGoodNumber( long num )
    {
        StringBuilder ternary = new StringBuilder();
        long current = num;
        while( current > 0L )
        {
            ternary.append( current % 3L );
            current /= 3L;
        }

        return getGreaterWith3Base( ternary, num );

    }

    private static BigDecimal getGreaterWith3Base( StringBuilder num, long originalNum )
    {
        num.reverse();
        BigDecimal number = new BigDecimal( "0" );
        int size = num.length();

        int index;
        boolean twoFound = false;
        for( index = 0; index < size; index++ )
        {
            if( num.charAt( index ) == '2' )
            {
                twoFound = true;
                break;
            }
        }

        if( !twoFound )
            return new BigDecimal( originalNum );

        
        int maxIndex =0;
        boolean changed = false;
        for( int i = index-1; i >= 0; i--)
        {
            if( num.charAt( i ) == '0' )
            {
                num.setCharAt( i, '1' );
                maxIndex =i;
                changed = true;
                break;
            }
        }

        for(int i=maxIndex+1;i<size;i++)
            num.setCharAt(  i, '0' );
            
        if( !changed )
        {
            return getXPowY( 3, size );
        }
        else
        {
            for( int i = 0,j=size-1; i <size; i++ )
            {
                number = number.add( new BigDecimal(String.valueOf( num.charAt( i ) )).multiply( getXPowY( 3, j-- ) ) );

            }
        }
        return number;
    }

    private static BigDecimal getXPowY( int x, int y )
    {
        BigDecimal num1 = new BigDecimal( x );

        BigDecimal res = new BigDecimal( 1 );
    
        
        while(y>0)
        {
            if(y%2!=0)
                res =res.multiply( num1 );
            
            num1 = num1.multiply( num1 );
            y=y/2;
        }
        return res;
    }

}
