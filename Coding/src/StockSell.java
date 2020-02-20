import java.util.ArrayList;
import java.util.List;


public class StockSell {

	class Interval
	{
		int buy;
		int sell;
	}
	
	public static void main(String[] args)
	{
		StockSell stockSell = new StockSell();
		stockSell.getMaxProfitBySellingStock(new int[]{5,6,10,50,15,20,80,3,2,1,86});
	}
	
	
	public void getMaxProfitBySellingStock(int[] A)
	{
		int n = A.length;
		if(n<2)
			return ;
		
		List<Interval> intervals = new ArrayList<Interval>();
 		int i=0;
		while(i<n)
		{
			Interval interval = new Interval();
			while(i<n-1 && A[i+1]<=A[i])
				i++;
			
			if(i==n-1)
				break;
			
			interval.buy = i++;
			
			while(i<n && A[i]>=A[i-1])
				i++;
			
			interval.sell = i-1;
			intervals.add(interval);
				
		}
		
		
		int count= intervals.size();
		if(count==0)
			System.out.println("No profit gained");
		else
		{
			for (int j = 0; j < count; j++) {
				System.out.println("buy "+intervals.get(j).buy+" Sell "+intervals.get(j).sell );
			}
		}
		
		
		
		
	}
	public static int getMaxProfitBySellingOnce(int[] A)
	{
		int n = A.length;
		if(n<2)
			return -1;
		
		int maxDiff = A[1]-A[0];
		int min = A[0];
		
		for (int i = 1; i < n; i++) {
			if(maxDiff<A[i]-min)
				maxDiff = A[i]-min;
			
			if(min>A[i])
				min=A[i];
		}
		
		return maxDiff;
	}
}
