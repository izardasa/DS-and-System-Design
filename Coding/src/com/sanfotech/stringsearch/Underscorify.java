package com.sanfotech.stringsearch;

import java.util.ArrayList;

public class Underscorify {
	
	private static ArrayList<Integer[]> getLocations(String S, String subString)
	{
		int n = S.length();
		ArrayList<Integer[]> locations = new ArrayList<Integer[]>();
		for (int i = 0; i < n; i++) 
		{
			int position = S.indexOf(subString,i);
			int slength = subString.length();
			if(position!=-1)
			{
				locations.add(new Integer[]{position,position+slength});
			}
			else
				break;
			
		}
		return locations;
	}
	
	private static ArrayList<Integer[]> collapseLocations(ArrayList<Integer[]> locations)
	{
		int n = locations.size();
		if(n==0)
			return null;
		
		ArrayList<Integer[]> newLocations = new ArrayList<Integer[]>();
		int index =0;
		newLocations.add(locations.get(0));
		for (int i=1;i<n;i++) 
		{
			Integer[] currentLocation = locations.get(i);
			Integer[] previousLocation = newLocations.get(index);
			if(previousLocation[1]>=currentLocation[0])
			{
				previousLocation[1] = currentLocation[1];
			}
			else
			{
			newLocations.add(currentLocation);
			index++;
			}
		}
		return newLocations;
	}
	

	public static String scorify(String S,String subString)
	{
		ArrayList<Integer[]> locations = getLocations(S, subString);
		ArrayList<Integer[]> collapseIndex = collapseLocations(locations);
		StringBuilder sb = new StringBuilder("");
		
		int n = S.length();
		ArrayList<Integer> index  = new ArrayList<>();
		
		for (Integer[] cindex: collapseIndex) 
		{
			index.add(cindex[0]);
			index.add(cindex[1]);
		}
		
		int inc =0;
		int underscorePostion = index.get(inc++);
		
		for (int i = 0; i < n; i++) {
			if(i==underscorePostion)
			{
				sb.append("-");
				if(inc<index.size())
				underscorePostion = index.get(inc++);
			}
			sb.append(S.charAt(i));
		}
		return sb.toString();
	}
	public static void main(String[] args) {

		System.out.println(scorify("testthis is a testtest to see if testestest it works", "test"));
	}

}
