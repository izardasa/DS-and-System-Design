import java.util.HashMap;
import java.util.Scanner;

public class BinaryStringMinimization
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int t = s.nextInt();

        while( t-- > 0 )
        {
            int n = s.nextInt();
            int k = s.nextInt();
            String S = s.next();
            char[] cs = S.toCharArray();

            int zPos = 0;
            int oPos = 0;
            while( k > 0 && oPos<(n-1))
            {
                for( int i = 0; i < n; i++ )
                {
                    if(cs[i]=='1')
                    {
                        oPos = i;
                        break;
                    }
                }
                for( int i = 0; i < n; i++ )
                {
                    if(cs[i]=='0' && oPos<i)
                    {
                        zPos = i;
                        break;
                    }
                }
                
                int diffPosition  = zPos-oPos;
                if(k>=diffPosition)
                {
                    char c = cs[zPos];
                    cs[zPos] = cs[oPos];
                    cs[oPos] = c;
                    k-=diffPosition;
                }
                else
                {
                    int index = zPos-k;
                    char c = cs[index];
                    cs[index] = cs[zPos];
                    cs[zPos]  = c;
                    k=0;
                }
                
            }
            
            System.out.println( cs );
        }

    }

}
