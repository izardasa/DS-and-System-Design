import java.util.Scanner;

public class RestoreThreeNumbers
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int max = Integer.MIN_VALUE;
        int[] nums = new int[4];
        for(int i=0;i<4;i++)
        {
            nums[i] = s.nextInt();
            if(nums[i]>max)
                max= nums[i];
        }
        
        for(int i=0;i<4;i++)
        {
            if(nums[i]!=max)
                System.out.print( max-nums[i]+ " " );
        }
    }

}
