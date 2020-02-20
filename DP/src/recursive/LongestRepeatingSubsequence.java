package recursive;

public class LongestRepeatingSubsequence
{

    public static int LRULength(String str)
    {
        return LRULengthHelper(str,0,0);
    }
    private static int LRULengthHelper( String str, int i, int j )
    {
       if(i==str.length() || j==str.length())
           return 0;
       
       if(i!=j && str.charAt( i )==str.charAt( j ))
           return 1+LRULengthHelper( str, i+1, j+1 );
       
       int l1 = LRULengthHelper( str, i+1, j );
       int l2 = LRULengthHelper( str, i, j+1 );
       
       return Math.max( l1, l2 );
    }
    public static void main( String[] args )
    {
        
        System.out.println(LRULength( "tomorrow") );
        System.out.println(LRULength( "aadbbcec") );
        System.out.println(LRULength( "aaaaa") );

    }

}
