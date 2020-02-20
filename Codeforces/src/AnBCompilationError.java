import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnBCompilationError
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int[] firstSet = new int[n];
        for(int i=0;i<n;i++)
            firstSet[i] = s.nextInt();
        Arrays.sort( firstSet );
        
     
        int[] secondSet = new int[n-1];
        for(int i=0;i<n-1;i++)
            secondSet[i] = s.nextInt();
        
        Arrays.sort( secondSet );
        
        
        
        int[] thirdSet = new int[n-2];
        for(int i=0;i<n-2;i++)
            thirdSet[i] = s.nextInt();
        
        Arrays.sort( thirdSet );
        
        boolean diffFound =false;
        for(int i=0;i<n-1;i++)
        {
            if(firstSet[i]!=secondSet[i])
            {
                System.out.println( firstSet[i] );
                diffFound = true;
                break;
            }
        }
        
        if(!diffFound)
            System.out.println( firstSet[n-1] );
        
        diffFound= false;
        
        for(int i=0;i<n-2;i++)
        {
            if(secondSet[i]!=thirdSet[i])
            {
                System.out.println( secondSet[i] );
                diffFound = true;
                break;
            }
        }
        
        if(!diffFound)
        System.out.println( secondSet[n-2] );
    }

}
