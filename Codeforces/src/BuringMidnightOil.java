import java.util.Scanner;

public class BuringMidnightOil
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int k = s.nextInt();
        
        
        System.out.println( getMinOfV(n, k) );

    }

    private static int getMinOfV( int n, int k )
    {
        int target =n;
        int low = 1;
        int high = n;
        int mid=0;
        if(n<=1)
            return 1;
        while(low<=high)
        {
            
            mid = (low+high)/2;
            int pow = 0;
            int v=0;
            while(true)
            {
                int numFraction =(int)(mid/Math.pow( k, pow++ )); 
                v+=(numFraction);
                
                if(numFraction==0)
                    break;
            }
           
            if(low==high && high ==mid && v<target)
            {
                mid= mid+1;
                break;
            }
            
            if(v==target)
                break;
            else if(v<target)
            {
                low = mid+1;
            }
            else
            {
                high =mid-1;
            }
            
           
        }
        
     
        
        return mid;
    }


}
