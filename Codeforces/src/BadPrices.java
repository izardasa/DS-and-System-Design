import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BadPrices
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = s.nextInt();
            
            System.out.println( countOfBadPrice(nums) );
        }
    }

    private static int countOfBadPrice( int[] nums )
    {
        int count=0;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
