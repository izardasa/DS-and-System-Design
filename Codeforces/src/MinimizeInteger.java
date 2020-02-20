import java.util.ArrayList;
import java.util.Scanner;

public class MinimizeInteger
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = Integer.parseInt( s.nextLine() );

        while( t-- > 0 )
        {
            System.out.println( findMinInteger( s.nextLine() ) );
        }
    }

    private static String findMinInteger( String num )
    {
        int n = num.length();
        int r = n;
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
        {
            int digit = num.charAt( i )-48;
            if(digit%2==0)
                even.add( digit );
            else
                odd.add( digit );
        }
        
        int evenL = even.size();
        int oddL = odd.size();
        
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        while(i<evenL && j<oddL)
        {
            if(even.get( i )<odd.get( j ))
            {
                sb.append( even.get( i++ ) );
            }
            else
            {
                sb.append( odd.get( j++ ) );
            }
        }
        

        while(i<evenL)
            sb.append( even.get( i++ ) );
        
        while(j<oddL)
            sb.append( odd.get( j++ ) );
        return  sb.toString() ;
    }

}
