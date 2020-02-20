import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MikeAndPalindrome
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        String word = s.next();
        
        int n = word.length();
        int count=0;
        int mid = n/2;
        int l=0,r=0;
        if(n%2==0)
        {
            l = mid-1;
            r= mid;
            
        }
        else
        {
            l =mid-1;
            r= mid+1;
        }
        
        while(l>=0 && r<n)
        {
            if(word.charAt( l-- )!=word.charAt( r++ ))
            {
                count++;
                
                if(count==2)
                    break;
            }
        }
        
        if(n%2!=0 && count==0)
            count=1;
        
        if(count==1 )
            System.out.println( "YES" );
        else
            System.out.println( "NO" );
    }
}
