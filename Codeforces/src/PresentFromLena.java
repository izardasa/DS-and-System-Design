import java.util.Scanner;

public class PresentFromLena
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        int l = n, r = n;
        
        for( int i = 0; i <= 2 * n; i++ )
        {
            int index=1;

            for( int j = 0; j <= 2 * n; j++ )
            {

                if( j == l && (i==0 || i==2*n) )
                    System.out.print(0);
                else if(j==l)
                    System.out.print(0+" ");
                else if(j==r)
                    System.out.print( 0 );
                else if(j>l && j<r)
                {
                    System.out.print( index+" " );
                    if(j<n)
                        index++;
                    else
                        index--;
                }
                else if(j<n)
                    System.out.print( "  " );
                
                
            }
            if( i < n )
            {
                l--;
                r++;
            }
            else
            {
                l++;
                r--;
            }
            System.out.println();
        }
    }

}