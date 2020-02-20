package bottomupwithtabulation;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxStacking {
	
	private static ArrayList<Integer[]> diskStacking(ArrayList<Integer[]> disks)
	{
		disks.sort((disk1,disk2) -> disk1[2].compareTo(disk2[2]));
		int n = disks.size();
		int[] height = new int[n];
		for (int i = 0; i < n; i++) 
		{
			height[i] = disks.get(i)[2];
			
		}
		int[] sequence = new int[n];
		Arrays.fill(sequence, Integer.MIN_VALUE);
		int maxIndex =0;
		
		for (int i = 1; i < n; i++) 
		{
			Integer[] currentDisk = disks.get(i);
			for (int j = 0; j < i; j++) 
			{
				Integer[] anotherDisk = disks.get(j);
				if(isValidDisk(anotherDisk, currentDisk) && currentDisk[2]+height[j]>height[i])
				{
					height[i] = currentDisk[2]+height[j];
					sequence[i]=j;
					
				}
				
			}
			if(height[i]>height[maxIndex])
				maxIndex =i;
			
		}
		return buildSequnece(disks, sequence, maxIndex);
	}
	private static ArrayList<Integer[]> buildSequnece(ArrayList<Integer[]> disks, int[] sequence, int maxIndex) {
		ArrayList<Integer[]> sequenceList = new ArrayList<Integer[]>();
		while(maxIndex!=Integer.MIN_VALUE)
		{
			sequenceList.add(disks.get(maxIndex));
			maxIndex = sequence[maxIndex];
			
		}
		return sequenceList;
	}
	private static boolean isValidDisk(Integer[] anotherDisk, Integer[] currentDisk)
	{
		return anotherDisk[0]<currentDisk[0] && anotherDisk[1]<currentDisk[1] && anotherDisk[2]<currentDisk[2];
				
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> disks = new ArrayList<Integer[]>();
		disks.add(new Integer[] {2,2,1});
		disks.add(new Integer[] {2,1,2});
		disks.add(new Integer[] {3,2,3});
		disks.add(new Integer[] {2,3,4});
		disks.add(new Integer[] {4,4,5});
		disks.add(new Integer[] {2,2,3});
		ArrayList<Integer[]> res = diskStacking(disks);
		for(Integer[] disk : res)
			System.out.println(disk[0]+" "+disk[1]+" "+disk[2]);

	}

}
