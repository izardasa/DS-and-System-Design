import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BooksExchange
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int t = Integer.parseInt( scanner.nextLine() );
        ArrayList<Integer[]> res = new ArrayList<Integer[]>();
        while(t-->0)
        {
            int numberOfKids =Integer.parseInt( scanner.nextLine()) ;
            String[] kidsStr = scanner.nextLine().split(" " );
            int[] kids = Arrays.asList( kidsStr ).stream().mapToInt( Integer::parseInt ).toArray();
            res.add( getNoOfExchanges( kids ) );;
            
        }
        
        for(Integer[] exchanges: res)
        {
            for(Integer ex: exchanges)
            {
                System.out.println( ex );
            }
        }
        
    }

    private static Integer[] getNoOfExchanges( int[] kids )
    {
       Integer[] res = new Integer[kids.length];
       
       for(int i=0;i<kids.length;i++)
       {
           int index=1;
           int nextIndex = kids[i];
           while((i+1)!=nextIndex)
           {
               nextIndex = kids[nextIndex];
               index++;
           }
           res[i] = index;
       }
       return res;
    }


}
