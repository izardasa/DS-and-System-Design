import java.util.HashMap;
import java.util.Map;

public class FindRageWithMaxNumbers {

	private static void findRange(int[] nums)
	{
		Map<Integer, Boolean> numsIncluded = new HashMap<>();
		
		int n = nums.length;
		int maxRangeLength = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			numsIncluded.put(nums[i], false);
		}
		
		for (int i = 0; i < n; i++) {
			int left = nums[i]-1;
			int right = nums[i]+1;
			int range=0;
			
			if(numsIncluded.containsKey(nums[i]) && numsIncluded.get(nums[i]))
				continue;
			
			range++;
			
			while(numsIncluded.containsKey(left) && !numsIncluded.get(left))
			{
				left = left-1;
				range++;
			}
			
			while(numsIncluded.containsKey(right) && !numsIncluded.get(right))
			{
				right = right+1;
				range++;
			}
			
			if(range>=maxRangeLength)
			{
				maxRangeLength = range;
				 min = left+1;
				 max =right-1;
			}
			
		}
		System.out.println("Min :" +min+" max = "+max+" rangeLength ="+maxRangeLength);
		

	}
	
	public static void main(String[] args) {
		findRange(new int[] {1,13,3,0,15,5,2,4,107,12,6,14,16,17,18});

	}

}
