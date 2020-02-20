package recursive;

public class MinJumpToReachEnd {

	private int minJumps(int[] jumps)
	{
		int n = jumps.length;
		if(n==0)
			return 0;
		
		return minJumps(jumps, 0);
	}
	private int minJumps(int[] jumps, int currentIndex) {
		
		if(currentIndex == jumps.length-1)
			return 0;
		
		if(jumps[currentIndex]==0)
			return Integer.MAX_VALUE;
		
		int start = currentIndex+1;
		int end = currentIndex+jumps[currentIndex];
		
		int totalJumps = Integer.MAX_VALUE;
		while(start<=end && start<jumps.length)
		{
			int minJump = minJumps(jumps, start++);
			if(minJump != Integer.MAX_VALUE)
				totalJumps = Integer.min(totalJumps, minJump+1);
		}
		
		return totalJumps;
	}
	public static void main(String[] args) {
		
		MinJumpToReachEnd minJumpToReachEnd = new MinJumpToReachEnd();
		System.out.println( minJumpToReachEnd.minJumps(new int[]{2,1,1,1,4}));
		System.out.println( minJumpToReachEnd.minJumps(new int[]{1,1,3,6,9,3,0,1,3}));
		

	}

}
