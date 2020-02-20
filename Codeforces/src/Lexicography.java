import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lexicography
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int l = s.nextInt();
        int k = s.nextInt();
        
        String word = s.next();
        char[] wordCA = word.toCharArray();
        Arrays.sort( wordCA );
        
        String newWord = new String(wordCA);
        
        String indexedString = newWord.substring( k-1,k+l-1 );
        StringBuilder sb = new StringBuilder(newWord);
        sb.replace( k-1, k+l-1, "" );
        System.out.println( sb );
        
    }


}
