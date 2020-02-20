import java.math.BigDecimal;
import java.util.Scanner;

public class TernaryLogic
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int a = s.nextInt();
        int c = s.nextInt();
        StringBuilder at = decimalToTernary( a );
        StringBuilder ct = decimalToTernary( c );
        
        int atLen = at.length();
        int ctLen = ct.length();
        
        int diff = Math.abs( atLen- ctLen );
        StringBuilder zeros = new StringBuilder();
        for(int i=0;i<diff;i++)
            zeros.append( "0" );
        if(atLen > ctLen)
        {
            ct = zeros.append( ct );
        }
        else
        {
            at = zeros.append( at );
        }
        
        int tSize = ct.length();
        
        StringBuilder res = new StringBuilder();
        for(int i=tSize-1;i>=0;i--)
        {
            int cn =Integer.parseInt(String.valueOf( ct.charAt( i ) ) );
            int an = Integer.parseInt(String.valueOf(  at.charAt( i ) ));
            int r = cn-an;
            if(r<0)
                r=r+3;
            res.append(r  );
            
        }
        
        System.out.println(ternaryToDecimal( res.reverse()) );
    }
    
    private static long ternaryToDecimal(StringBuilder s)
    {
        BigDecimal number = new BigDecimal("0");
        
        int l = s.length();
        for(int i=0, pow = l-1;i<l;i++)
        {
            BigDecimal cn = new BigDecimal(String.valueOf( s.charAt( i ) ));
            number = number.add( cn.multiply(new BigDecimal( Math.pow( 3, pow-- ) )) );
        }
        
        return number.longValue();
        
    }
    private static StringBuilder decimalToTernary(int n)
    {
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            sb.append( n%3 );
            n=n/3;
        }
        
        return sb.reverse();
    }

}
