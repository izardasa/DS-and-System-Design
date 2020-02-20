import java.util.Scanner;

public class ConstanzeMagzine
{

    static int[] fact = new int[ 100000 ];
    static int MOD = 1000000007;
    static
    {
        fact[0] = 1;

    }

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        String str = s.nextLine();
        int n = str.length();
        int t = 0;
        int count = 1;
        for( int i = 1; i < n; i++ )
        {
            char c = str.charAt( i );
            if( c == 'm' || c == 'w' )
            {
                t = 0;
                count = 0;
                break;
            }
            else if( ( c == 'n' && 'n' == str.charAt( i - 1 ) ) || ( c == 'u' && 'u' == str.charAt( i - 1 ) ) )
            {
                count++;
            }
            else if( ( str.charAt( i - 1 ) == 'u' && c != 'u' ) || ( str.charAt( i - 1 ) == 'n' && c != 'n' ) )
            {
                if( count > 1 )
                    t += getTotalPermutataions( count );
                count = 1;
            }

        }
        if( count >= 1 )
            t += getTotalPermutataions( count );
        if(count==0)
            t=0;
            
        System.out.println( t );
    }

    private static int getTotalPermutataions( int count )
    {
        int t = 0;
        for( int i = 0; i <= count / 2; i++ )
        {
            int ts = count - i;
            t += fact( ts ) / ( fact( i ) * fact( ts - i ) );
        }
        return t;
    }

    private static int fact( int n )
    {
        if( fact[n] != 0 )
            return fact[n];
        for( int i = 1; i <= n; i++ )
        {
            fact[i] = i * fact[i - 1];
            fact[i] = fact[i] % MOD;
        }
        return fact[n];
    }
}
