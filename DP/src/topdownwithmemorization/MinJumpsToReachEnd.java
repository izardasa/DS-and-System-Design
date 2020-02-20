package topdownwithmemorization;

public class MinJumpsToReachEnd {

	private int minJumps(int[] jumps)
	{
		int n = jumps.length;

		int[] dp = new int[n];
		return minJumps(jumps, dp,0);
		
	}
	private int  minJumps(int[] jumps, int[] dp, int currentIndex) {
		if(currentIndex == jumps.length-1)
			return 0;
		
		if(jumps[currentIndex]==0)
			return Integer.MAX_VALUE;
		
		if(dp[currentIndex]==0)
		{
			int start = currentIndex+1;
			int end = currentIndex+ jumps[currentIndex];
			int totalJumps = Integer.MAX_VALUE;;
			while(start<=end && start<jumps.length)
			{
				int minJumps = minJumps(jumps,dp,start++);
				if(minJumps!=Integer.MAX_VALUE)
					totalJumps = Math.min(totalJumps, minJumps+1);
			}
			
			dp[currentIndex] = totalJumps;
		}
		
		return dp[currentIndex];
	}
	public static void main(String[] args) {
		MinJumpsToReachEnd minJumpsToReachEnd = new MinJumpsToReachEnd();
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{2,1,1,1,4}));
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{2,1,3,1,4}));
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{1,1,3,6,9,3,0,1,3}));

	}

}
