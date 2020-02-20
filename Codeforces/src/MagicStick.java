import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MagicStick
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int t = s.nextInt();
        while(t-->0)
        {
            int x = s.nextInt();
            int y = s.nextInt();
            
            System.out.println( yCanbeObtainedFromx(x,y) );
        }
    }

    private static String yCanbeObtainedFromx( int x, int y )
    {
        String res ="NO";
        if(x==1 && y==1)
            res = "YES";
        else if( x==1 && y>1)
            res = "NO";
        else if(x==2 && (y<=3))
            res= "YES";
        else if(x==2 && y>3)
            res= "NO";
        else if(x==3 && y>3)
            res = "NO";
        else if(x==3 && y<=3)
            res="YES";
        else if(x>3)
            res = "YES";
        
        return res;
    }

    
}
