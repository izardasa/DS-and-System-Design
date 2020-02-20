import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MathProblem
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
       int t = s.nextInt();
       while(t-->0)
       {
           int n = s.nextInt();
           List<Segment> segments = new ArrayList<Segment>();
           
           for(int i=0;i<n;i++)
           {
               Segment segment = new Segment();
               segment.start = s.nextInt();
               segment.end = s.nextInt();
               segments.add( segment );
           }
           
           Collections.sort( segments, (o1,o2)->o1.start-o2.start );
           
           int minEndTime = segments.get( 0 ).end;
           int maxStartTime = segments.get( 0 ).start;
           for(Segment seg : segments)
           {
               if(minEndTime>seg.end)
                   minEndTime= seg.end;
               
               if(maxStartTime<seg.start)
                   maxStartTime = seg.start;
           }
           if(n>1)
           System.out.println( (maxStartTime - minEndTime)>0?(maxStartTime - minEndTime):0);
           else
               System.out.println( 0 );
           
       }
                       
       
    }

    public static int barterMarket(int comicBooks, int coins, int coinsNeeded, int coinsOffered) {

        BigDecimal comicBooksB = new BigDecimal(comicBooks);
        BigDecimal coinsB = new BigDecimal(coins);
        BigDecimal coinsNeededB = new BigDecimal(coinsNeeded);
        BigDecimal coinsOfferedB = new BigDecimal(coinsOffered);
        long num =  comicBooksB.multiply( coinsOfferedB).add( coinsB).longValue();
        long den =      coinsOfferedB.add( coinsNeededB).longValue();
        
        return (int)(num/den);
        }
}
class Segment
{
    int start;
    int end;
}