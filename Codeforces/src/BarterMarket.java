import java.math.BigDecimal;
import java.util.Scanner;

public class BarterMarket
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int books = s.nextInt();
        int cons = s.nextInt();
        int coinsNeeded = s.nextInt();
        int coinsOffered = s.nextInt();
        System.out.println( barterMarket(books, cons, coinsNeeded, coinsOffered) );
       
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
