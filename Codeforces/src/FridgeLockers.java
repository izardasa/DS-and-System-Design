import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FridgeLockers
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        
        while(t-->0)
        {
            int n= s.nextInt();
            int m = s.nextInt();
            int sum=0;
            List<Vertex> a = new ArrayList<Vertex>();
            for(int i=0;i<n;i++)
            {
                Vertex v= new Vertex();
                v.weight = s.nextInt();
                v.index = i+1;
                sum+=v.weight;
                a.add( v );
            }
            
            Collections.sort( a,(o1,o2)->o1.weight-o2.weight );
            
            if(n<=2 || n>m)
            {
                System.out.println( -1 );
                continue;
            }
            else 
            {
                int sumOfTwoWeights = a.get( 0 ).weight+a.get(1).weight;
                int minCost = 2*(sum)+(m-n)*sumOfTwoWeights;
                System.out.println( minCost );
                for(int i=1;i<n;i++)
                    System.out.println( a.get( i-1 ).index+" "+a.get( i ).index );
                
                System.out.println( a.get( 0 ).index+" "+a.get( n-1 ).index );
                for(int i=0;i<m-n;i++)
                    System.out.println( a.get( 0 ).index+" "+a.get( 1 ).index );
                    
            }
        }
    }


}

class Vertex 
{
    int index;
    int weight;
}