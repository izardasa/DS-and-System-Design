package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GenerateParenthesis
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int noOfPairs = s.nextInt();
        
        List<String> result = new ArrayList();
        backtrack(result, "", 0, 0 , noOfPairs);
        
        for(String parenthesis: result)
            System.out.println( parenthesis );
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    private static void backtrack( List<String> result, String output_String, int opening, int closing, int noOfPairs )
    {
       if(output_String.length()==noOfPairs*2)
       {
           result.add( output_String );
           return;
       }
       
       if(opening<noOfPairs) backtrack( result, output_String+"(", opening+1, closing, noOfPairs );
       if(closing<opening) backtrack( result, output_String+")", opening, closing+1, noOfPairs );
        
    }
}
