import java.util.ArrayList;
import java.util.List;

public class Test {
	 static int birthday(List<Integer> s, int d, int m) {
	        int n = s.size();
	        int sum=0;
	        int count=0;
	        int mCount=0;
	          if(m==1 && s.get(0)==d && n==1)
	                count++;
	        for(int i=0;i<n-1;i++)
	        {
	            sum=0;
	            mCount=1;
	          
	            for(int j=i+1;j<n;j++)
	            {
	                sum+=s.get(i);
	                mCount++;
	                if(sum==d && mCount==m)
	                {
	                    count++;
	                }
	            }
	        }
	        return count;

	    }



	public static void main(String[] args) {
	    
	    double a= 10.05;
	    
	    int b = (int)a;
	    System.out.println(a+" "+ b );
		List list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(2);
		
		System.out.println(birthday(list,3,2));
	}

}
