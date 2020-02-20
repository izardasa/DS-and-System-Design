import java.util.HashMap;
import java.util.Scanner;

public class Corman
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        

        int n = s.nextInt();
        int steps = s.nextInt();
        
        int count=0;
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
           nums[i] =s.nextInt();
        }
        
        for(int i=1;i<n;i++)
        {
            int sum = nums[i-1]+nums[i];
            int diff= steps-sum;
            if(diff>0)
            {
                count+=diff;
                nums[i]+=diff;
            }
        }
        
        System.out.println( count );
        for(int i=0;i<n;i++)
            System.out.print( nums[i]+" " );
            
    }

}
