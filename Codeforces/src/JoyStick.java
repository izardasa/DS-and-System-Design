import java.util.HashMap;
import java.util.Scanner;

public class JoyStick
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        

        int a = s.nextInt();
        int b = s.nextInt();
        
        int time=0;
        while(a>0 && b>0)
        {
            if(a==1 && b==1)
                break;
            
            if(a==1 || a==2)
            {
                a+=1;
                b-=2;
            }
            else if(b==1 || b==2)
            {
                b+=1;
                a-=2;
            }
            else
            {
                if(a>b)
                {
                    b+=1;
                    a-=2;
                }
                else
                {
                    a+=1;
                    b-=2;
                }
            }
            time++;
            
            
        }
        System.out.println( time );
        
    }

}
