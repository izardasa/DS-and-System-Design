import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongSubstraction
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        String word =  scanner.nextLine() ;
        
        System.out.println( getRemainingLetterCount(word) );
        
    }

    private static int getRemainingLetterCount( String word )
    {
       int n = word.length();
       int count=0;
       for(int i=0;i<n;i++)
       {
           if(word.charAt( i )=='a')
               count++;
       }
       
       if((n/2+1)>count)
           return 2*count-1;
       else return n;
           
    }

}
