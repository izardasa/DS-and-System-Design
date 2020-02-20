import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NextRound
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int k = s.nextInt();
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++)
            nums[i] = s.nextInt();
        
        int index = getLastOccurence(nums,k-1);
        int count=0;
        for(int i=index;i>=0;i--)
        {
            if(nums[i]>0)
                count++;
        }
        System.out.println( count );
    }

    private static int getLastOccurence( int[] nums , int n)
    {
       int left = 0;
       int a = nums[n];
       int right = nums.length-1;
       int mid=0;
       while(left<=right)
       {
           mid=(left+right)/2;
           if(nums[mid]==a && mid+1<nums.length && nums[mid+1]<a)
           {
               return mid;
           }
           
           if(nums[mid]>=a )
           {
               left=mid+1;
           }
           else
           {
               right=mid-1;
           }
           
           
       }
       
       return mid;
    }

}
