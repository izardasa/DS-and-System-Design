import java.util.HashMap;
import java.util.Scanner;

public class ABAndChess
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put( "Q", 9 );
        map.put( "R", 5 );
        map.put( "B", 3 );
        map.put( "N", 3 );
        map.put( "P", 1 );
        map.put( "K", 0 );
        map.put( ".", 0 );

        int white = 0;
        int black = 0;
        for( int i = 0; i < 8; i++ )
        {
            String str = s.nextLine();
            for(int j=0;j<8;j++)
            {
                char c =str.charAt( j ); 
                if(c>=97 && c<=122)
                {
                    black+= map.get( String.valueOf( c ).toUpperCase() );
                }
                else
                {
                    white+=map.get( String.valueOf( c ) );
                }
                    
            }

        }
        
        if(white>black)
            System.out.println( "White" );
        else if(white<black)
            System.out.println( "Black" );
        else
            System.out.println( "Draw" );
        
        
    }

}
