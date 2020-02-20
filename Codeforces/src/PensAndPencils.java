import java.util.Scanner;

public class PensAndPencils
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int t = s.nextInt();

        while( t-- > 0 )
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            int k = s.nextInt();

            System.out.println( getNumberOfPensAndPencils( a, b, c, d, k ) );
        }

    }

    private static String getNumberOfPensAndPencils( int a, int b, int c, int d, int k )
    {
        int i = 0, j = 0;
        int totalLecturesCanBeCovered = 0;
        int totalPracticalsCanBeConvered = 0;
        while( true )
        {
            totalLecturesCanBeCovered = c * ++i;
            if( totalLecturesCanBeCovered >= a )
                break;
        }

        while( true )
        {
            totalPracticalsCanBeConvered = d * ++j;
            if( totalPracticalsCanBeConvered >= b )
                break;
        }

        if( i + j <= k )
            return i + " " + j;
        return "-1";

    }

}
