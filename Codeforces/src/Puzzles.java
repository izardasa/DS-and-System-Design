import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzles
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int index=0;
        int[] puzzles = new int[m];
        while(index<m)
        {
            puzzles[index++] = s.nextInt();
        }
                      

        int minCount=Integer.MAX_VALUE;
        int count=0;
        Arrays.sort( puzzles );
        for(int i=0;i<=m-n;i++)
        {
            int diff =puzzles[i+n-1]- puzzles[i]; 
            if(diff<minCount)
                minCount= diff;
        }
        
        if(minCount == Integer.MAX_VALUE)
            minCount = 0;
        System.out.println( minCount );
    }


}
