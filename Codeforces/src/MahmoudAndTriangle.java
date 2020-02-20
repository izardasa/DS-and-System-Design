import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MahmoudAndTriangle
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
      int n = s.nextInt();
      int[] nums = new int[n];
      for(int i=0;i<n;i++)
          nums[i] = s.nextInt();
      
      Arrays.sort( nums );
      
      boolean found = false;
      for(int i=1;i<n-1;i++)
      {
          if(nums[i]+nums[i-1]>nums[i+1])
          {
              found= true;
              break;
          }
              
      }
      
      if(found)
          System.out.println( "YES" );
      else
          System.out.println( "NO" );
                      
    }
}
