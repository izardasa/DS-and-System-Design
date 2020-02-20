package bottomupwithtabulation;



public class MinJumpsToReachEnd {
	
	private int minJumps(int[] jumps)
	{
		int n = jumps.length;
		int[] dp = new int[n];
		
		for (int i = 1; i < n; i++) {
			dp[i]= Integer.MAX_VALUE;
		}
		
		for (int start = 0; start < n; start++) {
			for (int end = start+1; end <= start+ jumps[start]  && end < n ; end++) {
				dp[end] = Integer.min(dp[end], dp[start]+1);
			}
			
		}
		
		return dp[n-1];
	}

	public static void main(String[] args) {
		MinJumpsToReachEnd minJumpsToReachEnd = new MinJumpsToReachEnd();
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{2,1,1,1,4}));
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{2,1,3,1,4}));
		System.out.println( minJumpsToReachEnd.minJumps(new int[]{1,1,3,6,9,3,0,1,3}));

	}

}
