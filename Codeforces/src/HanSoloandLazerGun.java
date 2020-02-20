import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HanSoloandLazerGun
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        Trooper han = new Trooper( s.nextInt(), s.nextInt() );
        
        Trooper[] troopers = new Trooper[n];
        boolean[] destroyed = new boolean[n];
        for(int i=0;i<n;i++)
        {
            troopers[i] = new Trooper(s.nextInt(), s.nextInt());
        }
        
        
        int firedCount=0;
        
        for(int i=0;i<n-1;i++)
        {
            boolean fired = false;
            for(int j=i+1;j<n;j++)
            {
                int x1 = troopers[i].x;
                int y1 = troopers[i].y;
                int x2 = han.x;
                int y2 = han.y;
                int x3 = troopers[j].x;
                int y3 = troopers[j].y;
                
                if((x3-x1)*(y2-y1) ==  (x2-x1)*(y3-y1) && destroyed[j]==false)
                {
                    destroyed[j]=true;
                    fired= true;
                }
            }
            
            if(fired==false && destroyed[i]==false)
                firedCount++;
            
            if(fired)
                firedCount++;
            
            destroyed[i] = true;
        }
        
        for(int i=0;i<n;i++)
        {
            if(destroyed[i]==false)
                firedCount++;
        }
        
        System.out.println( firedCount );
    }

}

class Trooper
{
    int x;
    int y;
    
    public Trooper(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

