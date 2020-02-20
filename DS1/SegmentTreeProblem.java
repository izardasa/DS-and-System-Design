import java.util.Arrays;
import java.util.Scanner;

import ds.impl.SegmentTree;

public class SegmentTreeProblem
{

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int t = Integer.parseInt(in[0]);
        String[] arr = s.nextLine().split( " " );
        int[] A  = Arrays.asList(arr).stream().mapToInt(Integer::parseInt).toArray();
        SegmentTree.buildTree(A);
        StringBuilder sb= new StringBuilder();
        while(t-->0)
        {
            String[] input = s.nextLine().split(" ");
            int l = Integer.parseInt(input[1])-1;
            int r = Integer.parseInt(input[2])-1;
            if( input[0].equals( "u"))
                SegmentTree.update(l,r);
            else
                sb.append( SegmentTree.query(l,r+1)+"\n");
        }
        
        

    }

}
