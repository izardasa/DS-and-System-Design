
public class ConsecNumberSumToN {
	public static void main(String[] args) {
		int N = 154;
		int n =2;
		while(2*N+n-n*n>0)
		{
			float a =(float)(2*N+n-n*n)/(2*n);
			if(a-(int)a==0.0)
			{
				System.out.println(a+" upto "+n );
			}
			n++;
		}
		
	}
}
