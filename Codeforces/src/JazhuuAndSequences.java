import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class JazhuuAndSequences
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int MOD = 1000000007;

        int x = s.nextInt();
        int y = s.nextInt();
        int[] res = {x,y,y-x,-x,-y,x-y};
        
        int ans = res[( s.nextInt()-1)%6]%MOD;
       
        if(ans<0)
            System.out.println( ans+MOD );
        else
            
            System.out.println( ans%MOD );
        
    }

}
