import java.util.HashMap;
import java.util.Scanner;

public class SweetProblem
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while( t-- > 0 )
        {
            int[] A = new int[ 3 ];
            for( int i = 0; i < 3; i++ )
            {
                A[i] = s.nextInt();
            }

            int highest = A[0];
            int secondHighest = Integer.MIN_VALUE;
            int thirdHighest = Integer.MIN_VALUE;
            for( int i = 1; i < 3; i++ )
            {
                if( A[i] > highest )
                {
                    thirdHighest = secondHighest;
                    secondHighest = highest;
                    highest = A[i];
                }
                else if( A[i] > secondHighest )
                {
                    thirdHighest = secondHighest;
                    secondHighest = A[i];
                }
                else
                    thirdHighest = A[i];
            }
            
           // System.out.println( highest+" "+secondHighest+" "+thirdHighest );

            int count = 0;

            if(highest>=secondHighest+thirdHighest)
                count+=(secondHighest+thirdHighest);
            else
            {
                int diffFirstSecond = highest-secondHighest;
                count+=diffFirstSecond;
                
                highest -= diffFirstSecond;
                thirdHighest-=diffFirstSecond;
                
                int diffSecondThird = secondHighest- thirdHighest;
                count+=diffSecondThird;
                
                highest-=diffSecondThird;
                secondHighest-=diffSecondThird;
                
                System.out.println( highest+" "+secondHighest+" "+thirdHighest );
                count+=(2*highest)-1;
                
            }
            System.out.println( count );

        }

    }

}
