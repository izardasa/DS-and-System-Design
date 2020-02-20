import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Interval implements Comparable<Interval> {
	int startTime;
	int endTime;

	public Interval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;

	}

	@Override
	public int compareTo(Interval o) {
		// TODO Auto-generated method stub
		return this.startTime - o.startTime;
	}
}



public class OverlappingInterval {
	
	private static int findTotalDuration(List<Interval> intervals)
	{
		
		
		Interval previousInterval = intervals.get(0);
		int count=0;
		int latestTime=previousInterval.endTime;
		int totalDuation = previousInterval.endTime-previousInterval.startTime;
		for (Interval interval : intervals) 
		{
			if(count++==0)
				continue;
			
			if(previousInterval.endTime<=interval.startTime)
			{
				totalDuation +=(interval.endTime-interval.startTime);
				latestTime = interval.endTime;
			}
			
			else
			{
				if(latestTime<interval.endTime)
				{
					totalDuation += interval.endTime-latestTime;
					latestTime = interval.endTime;
					
				}
			}
			
			previousInterval = interval;
			
			
		}
		
		return totalDuation;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(2, 5));
		intervals.add(new Interval(5, 10));
		intervals.add(new Interval(12, 15));
		intervals.add(new Interval(11, 14));
		intervals.add(new Interval(2, 8));
		intervals.add(new Interval(1, 6));
		intervals.add(new Interval(2, 7));

		for (Interval interval : intervals) {
			System.out.println(interval.startTime + " : " + interval.endTime);
		}

		System.out.println("After sorting...");
		Collections.sort(intervals);

		for (Interval interval : intervals) {
			System.out.println(interval.startTime + " : " + interval.endTime);
		}
		
		System.out.println(findTotalDuration(intervals));
	}

}
