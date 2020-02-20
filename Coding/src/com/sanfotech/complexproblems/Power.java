package com.sanfotech.complexproblems;
import java.util.Scanner;

class Power
{
    public static void main( String[] args )
    {

        Scanner s =new Scanner(System.in);
        double x = s.nextDouble();
        long n= s.nextLong();
        
        
        long pow = -n;
        long pow1= n;
        long sign = x>0?1:-1;
        double num = x>0?x:-x;
        double res = 1;
        while(pow>0)
        {
            if(pow%2!=0)
                res=res*num;
            
            pow>>=1;
            num=num*num;
        }
        
        if(n%2==0)
            sign=1;
        res =res*sign;
        
        if(n>0)
            System.out.println( (double)res ); 
        else
            System.out.println(  1/(double)res );
        
    }
}