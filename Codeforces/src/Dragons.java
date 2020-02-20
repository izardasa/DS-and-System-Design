import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Dragons
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int S = s.nextInt();
        int n = s.nextInt();
        int[][] dragons = new int[n][2];
        boolean won = true;
        ArrayList<DragonPower> listPower = new ArrayList<>();
        while(n-->0)
        {
            listPower.add( new DragonPower(s.nextInt(), s.nextInt()) ); 
        }
        
        Collections.sort( listPower, (o1, o2)->o1.power-o2.power );
        
        for( DragonPower power : listPower)
        {
            if(S>power.power)
            {
                S+=power.winPoints;
            }
            else
            {
                won = false;
                break;
            }
            
        }
        
        if(won)
            System.out.println( "YES" );
        else
            System.out.println( "NO" );
    }
}
class DragonPower 
{
    int power;
    int winPoints;
    
    DragonPower(int power, int winPoints)
    {
        this.power = power;
        this.winPoints = winPoints;
    }


}
