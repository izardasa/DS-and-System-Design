import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QueueSushie
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

      int n = s.nextInt();
      int[] nums = new int[n];
      
      for(int i=0;i<n;i++)
          nums[i] = s.nextInt();
      
      Arrays.sort( nums );
      
      long sum=0;
      int numNotDisappointed = 0;
      
      for(int i=0;i<n;i++)
      {
          if(sum<=nums[i])
              numNotDisappointed++;
          
          sum+=(long)nums[i];
      }
      
      System.out.println( numNotDisappointed );

    }

}
