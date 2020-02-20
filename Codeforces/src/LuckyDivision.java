import java.util.Scanner;

public class LuckyDivision
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int[] luckyNumbers= {4,7,47,74,747,774,477,744,474,447,444,777};
        int n = s.nextInt();

        boolean found= false;
       for(int i=0;i<luckyNumbers.length;i++)
       {
           if(n%luckyNumbers[i]==0)
           {
               found= true;
               break;
           }
       }
       
       if(found)
           System.out.println( "YES" );
       else
           System.out.println( "NO" );

    }


}
