import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SendBoxToAlice2
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();

        int[] nums = new int[n];
        int max=0;
        int countOf1s = 0;
        long sum =0;
        for(int i=0;i<n;i++)
        {
            
            nums[i] = s.nextInt();
            sum+=nums[i];
            if(max<nums[i])
                max=nums[i];
        }

        if(sum==0 || sum==1)
        {
            System.out.println( -1 );
            return;
        }
        
        int i=2;
        int sc=0;
        int minSwap = Integer.MAX_VALUE;
        while(i*i<=sum)
        {
            if(sum%i==0)
            {
                int rem=nums[0]%i;
                sc+=rem;
                for(int k=1;k<n;k++)
                {
                    int currentNumber = nums[k];
                    currentNumber =rem+currentNumber;
                    rem = currentNumber%i;
                    sc+=rem;
                }
                
                if(rem==0)
                {
                   if(minSwap>sc)
                       minSwap=sc;
                }
                sc =0;
            }
            
            i++;
            
        }
        
        System.out.println( minSwap==Integer.MAX_VALUE?(sum-max):minSwap );
        
        
        
    }

}
