import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TPrimes
{

    private static int SIZE=1000000;
    public static void main( String[] args )
    {
        Seive();
        Set<Long> set = new HashSet<Long>();
        
        for(int i=2;i<=SIZE;i++)
        {
            if(nums[i])
                set.add( (long)i*(long)i );
        }
        
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
           long num = s.nextLong();
           
           if(set.contains( num ))
               sb.append( "YES\n");
           else sb.append( "NO\n" );
           
        }
        System.out.println( sb);
       
    }

    static boolean[] nums= new boolean[SIZE+1];
    private static void Seive()
    {
        Arrays.fill( nums, true );
        
        nums[0] = false;
        nums[1] = false;
        
        for(int i=2;(i*i)<=SIZE;i++)
        {
            if(nums[i])
            {
                for(int j=i*2;j<=SIZE;j+=i)
                {
                    nums[j] = false;
                }
            }
        }
        
    }


}
