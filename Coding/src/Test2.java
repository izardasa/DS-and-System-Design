import java.util.Arrays;
import java.util.Scanner;


public class Test2
{
    
    public static int getNoOfTeams(int[] skills)
    {
        Arrays.sort( skills );
        for( int i = 1; i < skills.length; i++ )
        {
            if(Math.abs( skills[i]-skills[i-1])==1)
                return 2;
        }
        return 1;
    }

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        int t = Integer.parseInt( scanner.nextLine() );
        
        while(t-->0)
        {
            int n =Integer.parseInt( scanner.nextLine()) ;
            String[] skillsStr = scanner.nextLine().split(" " );
            int[] skills = Arrays.asList( skillsStr ).stream().mapToInt( Integer::parseInt ).toArray();
            System.out.println( getNoOfTeams( skills ) );;
            
        }
    }

    }
