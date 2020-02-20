import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = s.nextInt();
       
        
        Arrays.sort( nums );
        for(int i=0;i<n;i++)
            System.out.print( nums[i] +" ");
    }

}
