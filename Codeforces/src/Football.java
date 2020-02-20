import java.util.HashMap;
import java.util.Scanner;

public class Football
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        String teamWon ="";
        int maxGoals = -1;
        while(n-->0)
        {
            String team = s.next();
            int num = 0;
            
            if(map.containsKey( team ))
            {
                num = map.get( team );
                map.put( team, num+1 );
            }
            else
            {
                map.put( team, 1 );
            }
            if(maxGoals<num)
            {
                maxGoals = num;
                teamWon = team;
            }
        }
        
        System.out.println( teamWon );
        
        
    }

}
