import java.util.Arrays;
import java.util.Scanner;

public class Tower
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n =Integer.parseInt(  s.nextLine() );
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++)
        {
            nums[i] = s.nextInt();
        }

        
        Arrays.sort( nums );
        
        int maxHeight=1;
        int height=1;
        int uniques=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1])
            {
                height++;
                if(height>maxHeight)
                    maxHeight= height;
            }
            else
            {
                height=1;
                uniques++;
            }
        }
        
        System.out.println( maxHeight+" "+uniques );
        
    }

}
