package bottomupwithtabulation;

import java.util.ArrayList;
import java.util.Arrays;

public class MinCutsToMakeAllSubstringOfStringPalindrome {
	

    public static void main(String[] args) {
        System.out.println( findMinCuts("lolalu") );
    }

    private static int findMinCuts( String s )
    {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0;i<n;i++)
            dp[i][i] = true;
        
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt( i )==s.charAt( i+1 ))
                dp[i][i+1] =  true;
        }
        
        for(int curLen =3;curLen<=n;curLen++)
        {
            for(int i=0;i<n-curLen+1;i++)
            {
                int j= i+curLen-1;
                if(s.charAt( i )==s.charAt( j ) && dp[i+1][j-1])
                    dp[i][j] = true;
                
            }
        }
            
            
        int[] cuts = new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(dp[0][i])
                cuts[i] = 0;
            else
            {
                int temp = Integer.MAX_VALUE;
                for(int j=0;j<i;j++)
                {
                    if(dp[j+1][i] && temp>cuts[j]+1)
                        temp= cuts[j]+1;
                }
                cuts[i] = temp;
            }
            
        }
        
        return cuts[n-1];

    }
    
}
