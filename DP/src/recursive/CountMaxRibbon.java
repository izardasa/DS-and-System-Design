package recursive;

public class CountMaxRibbon {

	private int countMaxRibbon(int[] ribbon, int totalLength)
	{
		int n = ribbon.length;
		if(n==0 || totalLength<=0)
			return -1;
		
		int res = countMaxRibbon(ribbon, totalLength,0);
        return res == Integer.MIN_VALUE?-1:res;		
		
	}
	private int countMaxRibbon(int[] ribbon, int totalLength, int currentIndex) {
		if(totalLength==0)
			return 0;
		
		if(currentIndex>=ribbon.length)
			return Integer.MIN_VALUE;
		
		int count1 = Integer.MIN_VALUE;
		if(ribbon[currentIndex]<=totalLength)
		{
			int res = Integer.MIN_VALUE;
			res = countMaxRibbon(ribbon, totalLength-ribbon[currentIndex],currentIndex);
			if(res!=Integer.MIN_VALUE)
				count1 = res+1;
					
		}
		
		int count2 = countMaxRibbon(ribbon, totalLength,currentIndex+1);
		
		return Math.max(count1, count2);
		
	}
	public static void main(String[] args) {
		CountMaxRibbon countMaxRibbon = new CountMaxRibbon();
		 
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3,5}, 5));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{2,3}, 7));
		System.out.println(countMaxRibbon.countMaxRibbon(new int[]{3,5,7}, 21));
		 
	}

}
