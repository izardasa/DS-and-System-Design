package topdownwithmemorization;



public class MinJumpsWithFee {

	private int minJumpsWithFee(int[] fee)
	{
		int n = fee.length;
		
		int[] dp = new int[n];
		return minJumpsWithFee(fee,0,dp);
	}
	private int minJumpsWithFee(int[] fee, int currentIndex, int[] dp) {
		if(currentIndex>=fee.length)
			return 0;
		
		if(dp[currentIndex]==0)
		{
			dp[currentIndex] =fee[currentIndex]+ Math.min(Math.min(minJumpsWithFee(fee,currentIndex+1,dp), minJumpsWithFee(fee,currentIndex+2,dp)),minJumpsWithFee(fee,currentIndex+3,dp));
		}
		
		return dp[currentIndex];
	}
	public static void main(String[] args) {
		MinJumpsWithFee minJumpsWithFee = new MinJumpsWithFee();
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{1,2,5,2,1,2}));
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{2,3,4,5}));

	}

}
