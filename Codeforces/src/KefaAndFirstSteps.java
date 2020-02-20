import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KefaAndFirstSteps
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] seq = new int[n];
        int index=0;
        while(index<n)
        {
            seq[index++] = s.nextInt();
        }
                      
        int seqLen = 1;
        int maxSeqLen =1;
        for(int i=1;i<n;i++)
        {
            if(seq[i]>=seq[i-1])
            {
                seqLen++;
                if(seqLen>maxSeqLen)
                    maxSeqLen = seqLen;
            }
            else
            {
                seqLen=1;
            }
        }
        
        System.out.println( maxSeqLen );
    }


}
