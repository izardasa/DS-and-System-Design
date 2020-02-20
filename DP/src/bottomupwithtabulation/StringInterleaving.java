package bottomupwithtabulation;

import javax.sound.midi.MidiChannel;

public class StringInterleaving
{

    private static boolean isStringInterleaving( String A, String B, String S )
    {
        if( ( A.length() + B.length() ) != S.length() )
            return false;
        boolean[][] dp = new boolean[ A.length() + 1 ][ B.length() + 1 ];

        for( int mIndex = 0; mIndex <= A.length(); mIndex++ )
        {
            for( int nIndex = 0; nIndex <= B.length(); nIndex++ )
            {
                if( mIndex == 0 && nIndex == 0 )
                {
                    dp[mIndex][nIndex] = true;
                    continue;
                }
                else if( mIndex == 0 && B.charAt( nIndex - 1 ) == S.charAt( mIndex + nIndex - 1 ) )
                {
                    dp[mIndex][nIndex] = dp[mIndex][nIndex - 1];
                }
                else if( nIndex == 0 && A.charAt( mIndex - 1 ) == S.charAt( nIndex + mIndex - 1 ) )
                {
                    dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
                }
                else if( mIndex >0 && A.charAt( mIndex - 1 ) == S.charAt( mIndex + nIndex - 1 ) )
                {
                    dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
                }
                else if( nIndex >0 && B.charAt( nIndex - 1 ) == S.charAt( mIndex + nIndex - 1 ) )
                {
                    dp[mIndex][nIndex] = dp[mIndex][nIndex - 1];
                }

            }
        }

        return dp[A.length()][B.length()];

    }

    public static void main( String[] args )
    {
        System.out.println( isStringInterleaving( "abc", "def", "defbac" ) );
        System.out.println( isStringInterleaving( "abc", "def", "defabc" ) );
    }

}
