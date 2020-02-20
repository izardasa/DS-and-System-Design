
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CodeCompetition {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        char[] str1 = s.nextLine().toCharArray();         
        char[] str2 = s.nextLine().toCharArray();         
        int LCSlength=0;
        if(str1.length>0 && str2.length>0)
        {
          
         LCSlength = LCS(str1,str2);
         System.out.println(LCSlength); 
        }
        else
        System.out.println(LCSlength);
    }
    
    public static int LCS(char str1[],char str2[])
    {
        int m = str1.length;
        int n = str2.length;
        int[][] resArray = new int[m+1][n+1];
        int maxLength=0;
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    resArray[i][j]=0;
                else if(str1[i-1]==str2[j-1])
                {
                    resArray[i][j]=resArray[i-1][j-1]+1;
                    maxLength = Math.max(maxLength,resArray[i][j]);
                }
                else
                    resArray[i][j]=0;
            }
        }
        return maxLength;
    
    }
}
