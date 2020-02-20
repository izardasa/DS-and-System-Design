import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DrazilAndFactorial
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        int n = s.nextInt();
        String num = s.next();
        int[] nums = {1,1,2,3,322,5,53,7,7222,7332};
        
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Character> list  = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(num.charAt(i)-48==0 || num.charAt( i)-48==1 ) 
            continue;
            
            final char[] ca = String.valueOf( nums[num.charAt( i )-48]).toCharArray();
            for(char c: ca)
            list.add(c);
        }
        
        
        
        Collections.sort( list,(c1,c2)-> c2-c1 );
        
        for(char c: list)
            System.out.print( c );
    }

}
