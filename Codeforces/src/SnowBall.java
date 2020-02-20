import java.util.Scanner;

public class SnowBall
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int sbW1 = s.nextInt();
        int sbH1 = s.nextInt();
        
        int[][] st = new int[2][2];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                st[i][j] = s.nextInt();
            }
        }
        
        for(int i=sbH1;i>=0;i--)
        {
            sbW1+=i;
            if( st[0][1]==i)
                sbW1-=st[0][0];
            
            if( st[1][1]==i)
                sbW1-=st[1][0];
            
            if(sbW1<0)
                sbW1=0;
        }
        
        System.out.println( sbW1 );

    }

}
