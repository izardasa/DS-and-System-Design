package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JobSequencing
{

    public static void main( String[] args )
    {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        ArrayList<Job> jobs = new ArrayList<Job>();
        while(n-->0)
        {
            jobs.add( new Job(s.next(),s.nextInt(),s.nextInt()) );
        }
        
        Collections.sort( jobs, (j1,j2)-> j2.profit-j1.profit );
        
        int day=1;
        for(Job job: jobs)
        {
            if(job.deadline-day>=0)
            {
                System.out.println( job.jobId );
                day++;
            }
        }
        
    }

}

class Job
{
    public String jobId;
    public int deadline;
    public int profit;
    
    public Job( String jobId, int deadline, int profit )
    {
        super();
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
    
        
}
