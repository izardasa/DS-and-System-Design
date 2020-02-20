import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SendBoxToAlice
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();

        int[] nums = new int[n];
        
        int countOf1s = 0;
        for(int i=0;i<n;i++)
        {
            
            nums[i] = s.nextInt();
            if(nums[i]==1)
                countOf1s++;
            
        }
        
        int swapCount=0;
        boolean countStart= false;
        boolean paired= false;
        if(countOf1s%2!=0 || countOf1s==0)
        {
            System.out.println( -1 );
            return;
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                if(nums[i]==1 && !paired)
                {
                    countStart=true;
                    paired= true;
                }
                else if(nums[i]==1 && paired)
                {
                    paired = false;
                    countStart  =false;
                    swapCount++;
                }
                
                if(nums[i]==0 && countStart)
                    swapCount++;
                
                    
            }
        }
        
        System.out.println( swapCount );
        
        
        
        
    }

}
