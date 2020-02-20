package topdownwithmemorization;

public class LongestRepeatingSubsequence
{

    
    public static int LRS(String str)
    {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return LRS(str, dp, 0, 0 );
    }
    private static int LRS( String str, Integer[][] dp, int i, int j )
    {
        if(i==str.length() || j==str.length())
            return 0;
        
        if(dp[i][j]==null)
        {
            if(i!=j && str.charAt( i )==str.charAt( j ))
                dp[i][j] = 1+LRS(str, dp, i+1,j+1);
            else
            {
                int l1 = LRS(str, dp, i+1,j);
                int l2 = LRS(str, dp, i, j+1);
                
                dp[i][j] = Math.max( l1, l2 );
            }
        }
        return dp[i][j];
    }
    public static void main( String[] args )
    {
        System.out.println(LRS( "tomorrow") );
        System.out.println(LRS( "aadbbcec") );
        System.out.println(LRS( "aaaaa") );
    }

}
