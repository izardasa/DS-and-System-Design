package bottomupwithtabulation;



public class MinJumpsWithFee {
	
	private int minJumpsWithFee(int[] fee)
	{
		int n = fee.length;
		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=fee[0];
		dp[2]=fee[0];
		dp[3] = fee[0];
		for (int i = 3; i < n; i++) {
			dp[i+1] =Integer.min(Integer.min(fee[i]+dp[i],fee[i-1]+dp[i-1]),fee[i-2]+dp[i-2]); 
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		MinJumpsWithFee minJumpsWithFee = new MinJumpsWithFee();
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{1,5,4,5,4,5,1,1,1,3}));
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{2,3,4,5}));

	}

}
