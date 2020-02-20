import java.util.Scanner;

public class SuperCentralPoint
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = Integer.parseInt( s.nextLine() );

        int[][][] points = new int[n][ 1 ][ 2 ];
        for( int i = 0; i < n; i++ )
        {
            String[] point = s.nextLine().split( " " );
            points[i][0][0] = Integer.parseInt( point[0] );
            points[i][0][1] = Integer.parseInt( point[1] );
        }
        System.out.println( getTotalSuperCentralPoints(points) );

    }

    private static int getTotalSuperCentralPoints( int[][][] points )
    {
        int n = points.length;
        boolean isLeftSmaller =false;
        boolean isRightGreater=false;
        boolean isUpperSmaller=false;
        boolean isLowerGreater=false;
        int count=0;
        for(int i=0;i<n;i++)
        {
            isLeftSmaller =false;
            isRightGreater=false;
            isUpperSmaller=false;
            isLowerGreater=false;
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    if(points[i][0][0]<points[j][0][0] && points[i][0][1]==points[j][0][1])
                        isRightGreater = true;
                    
                    if(points[i][0][0]>points[j][0][0] && points[i][0][1]==points[j][0][1])
                        isLeftSmaller = true;
                    
                    if(points[i][0][0]==points[j][0][0] && points[i][0][1]<points[j][0][1])
                        isLowerGreater = true;
                    
                    if(points[i][0][0]==points[j][0][0] && points[i][0][1]>points[j][0][1])
                        isUpperSmaller = true;
                        
                }
            }
            if(isRightGreater && isLeftSmaller && isLowerGreater && isUpperSmaller)
                count++;
        }
        return count;
    }

}
