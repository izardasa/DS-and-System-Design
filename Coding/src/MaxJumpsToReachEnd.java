
public class MaxJumpsToReachEnd {

	private static int maxJumps(int[] jumps)
	{
		
		int maxReach = jumps[0];
		int steps = jumps[0];
		int jump = 0;
		for (int i = 1; i < jumps.length-1; i++) 
		{
			maxReach = Math.max(maxReach, jumps[i]+i);
			steps-=1;
			
			if(steps==0)
			{
				jump+=1;
				steps= maxReach- i;
			}
		}
		return jump+1;
	}
	public static void main(String[] args) {
		System.out.println(maxJumps(new int[] {3,4,2,1,2,3,7,1,1,1,3}));

	}

}
