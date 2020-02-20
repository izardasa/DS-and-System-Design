import java.util.Scanner;

public class Keyboard
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        String seq = "qwertyuiopasdfghjkl;zxcvbnm,./";
        String d = s.next();
        String word = s.next();
        StringBuilder sb= new StringBuilder();
        int n = word.length();
        if(d.equals( "R"))
        {
            for(int i=0;i<n;i++)
            {
               int index =  seq.indexOf(  word.charAt( i ));
               sb.append( seq.charAt( index-1 ) );
            }
        }
        if(d.equals( "L"))
        {
            for(int i=0;i<n;i++)
            {
               int index =  seq.indexOf(  word.charAt( i ));
               sb.append( seq.charAt( index+1 ) );
            }
        }
        
        System.out.println( sb );
            
    }
}