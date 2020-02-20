package recursive;

public class MinJumpsWithFee {

	private int minJumpsWithFee(int[] fee)
	{
		int n = fee.length;
		if(n==0)
			return 0;
		
		return minJumpsWithFee(fee,0);
	}
	private int minJumpsWithFee(int[] fee, int currentIndex) {
		
		if(currentIndex>=fee.length)
			return 0;
		int take1Step = minJumpsWithFee(fee,currentIndex+1);
		int take2Step = minJumpsWithFee(fee,currentIndex+2);
		int take3Step = minJumpsWithFee(fee,currentIndex+3);
		
		return fee[currentIndex]+ Integer.min( Integer.min(take2Step, take3Step),take1Step);
		
	}
	public static void main(String[] args) {
		MinJumpsWithFee minJumpsWithFee = new MinJumpsWithFee();
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{1,2,5,2,1,2}));
		System.out.println(minJumpsWithFee.minJumpsWithFee(new int[]{2,3,4,5}));

	}

}
