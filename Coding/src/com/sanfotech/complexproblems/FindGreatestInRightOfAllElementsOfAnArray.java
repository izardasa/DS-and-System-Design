package com.sanfotech.complexproblems;

import java.util.Scanner;

public class FindGreatestInRightOfAllElementsOfAnArray
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = s.nextInt();
        
        int[] greatest = new int[n];
        
        greatest[n-1]=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(greatest[i+1]<nums[i+1])
                greatest[i] = nums[i+1];
        }
        
        for(int i=0;i<n;i++)
            System.out.print( greatest[i]+" " );
    }

}