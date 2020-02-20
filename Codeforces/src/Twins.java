import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Twins
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        int[] coins = new int[ n ];
        int index = 0;
        int sum = 0;
        while( index < n )
        {
            int coin = scanner.nextInt();
            coins[index++] = coin;
            sum += coin;

        }
        Arrays.sort( coins );
        int minCoins =0;
        int minCoinsSum=0;
        for( int i = coins.length-1; i >=0 ; i-- )
        {
            minCoins++;
            minCoinsSum+=coins[i];
            if(minCoinsSum>(sum/2))
            {
                
                break;
            }
            
                
        }

        System.out.println( minCoins );
    }


}
