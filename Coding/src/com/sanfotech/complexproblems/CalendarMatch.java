package com.sanfotech.complexproblems;

import java.util.ArrayList;

public class CalendarMatch
{

    private ArrayList<String> getCalendarMatchingTime( ArrayList<String> calendar1, String dailyBounds1,
        ArrayList<String> calendar2, String dailyBounds2, int meetingDuration )
    {
        ArrayList<String> updatedCalendar1 = getUpdatedCalendar(calendar1, dailyBounds1);
        ArrayList<String> updatedCalendar2 = getUpdatedCalendar(calendar2, dailyBounds2);
        
        ArrayList<String> mergedCalendar = getMergedCalendar(updatedCalendar1, updatedCalendar2);
        ArrayList<Meeting> flattenCalendar = getFlattenCalendar(mergedCalendar);
        return getMatchingMeeting(flattenCalendar, meetingDuration);

    }

    private ArrayList<String> getMatchingMeeting( ArrayList<Meeting> flattenCalendar, int meetingDuration )
    {
        int startTime = flattenCalendar.get( 0 ).endTime;
        int sizeOfFlattenCalandar = flattenCalendar.size();
        ArrayList<String> matchingTime = new ArrayList<>();
        for( int i = 1; i < sizeOfFlattenCalandar; i++ )
        {
            int endTime  = flattenCalendar.get( i ).startTime;
            int currentDuration = endTime - startTime;
            if(currentDuration>=meetingDuration)
            {
                matchingTime.add( convertMinuteToTime(startTime, endTime) );
            }
            startTime = flattenCalendar.get( i ).endTime;
            
        }
        return matchingTime;
    }
    
    

    private ArrayList<Meeting> getFlattenCalendar( ArrayList<String> mergedCalendar )
    {
        ArrayList<Meeting> flattenCalendar = new ArrayList<Meeting>();
        flattenCalendar.add(new Meeting( mergedCalendar.get(0) ));
        int sizeOfMergedCalendar = mergedCalendar.size();
        
        for( int i = 1; i <sizeOfMergedCalendar; i++ )
        {
            String currentTime = mergedCalendar.get( i );
            Meeting previousMeetingTime = flattenCalendar.get( flattenCalendar.size()-1 );
            int prevoiusEndTime =previousMeetingTime.endTime;
            int previousStartTime = previousMeetingTime.startTime;
            int currentEndTime = convertTimeToMinute(currentTime.split( "-" )[1]);
            int currentStartTime = convertTimeToMinute( currentTime.split( "-" )[0] );
            
            if(prevoiusEndTime>=currentStartTime)
            {
                prevoiusEndTime =Math.max( currentEndTime,prevoiusEndTime);
                previousMeetingTime.endTime = prevoiusEndTime;
            }
            else
            {
                flattenCalendar.add( new Meeting(currentTime) );
            }
        }
        return flattenCalendar;
    }

    private ArrayList<String> getMergedCalendar( ArrayList<String> updatedCalendar1,
        ArrayList<String> updatedCalendar2 )
    {
       int sizeCalendar1 = updatedCalendar1.size();
       int sizeCalendar2 = updatedCalendar2.size();
       ArrayList<String> mergedCalendar = new ArrayList<>();
       int i=0,j=0;
       while(i<sizeCalendar1 && j< sizeCalendar2)
       {
           int minuteCalendar1StartTime = convertTimeToMinute(updatedCalendar1.get( i ).split( "-" )[0]);
           int minuteCalendar2StartTime = convertTimeToMinute(updatedCalendar2.get( j ).split( "-" )[0]);
           if(minuteCalendar1StartTime<minuteCalendar2StartTime)
               mergedCalendar.add( updatedCalendar1.get( i++ ) );
           else
               mergedCalendar.add( updatedCalendar2.get( j++  ));
       }
       
       while(i<sizeCalendar1)
           mergedCalendar.add( updatedCalendar1.get( i++ ) );
       
       while(j<sizeCalendar2)
           mergedCalendar.add( updatedCalendar2.get( j++ ) );
       
       return mergedCalendar;
    }

    private int convertTimeToMinute( String time )
    {
       String[] minuteHour = time.split( ":");
       int hh = Integer.parseInt( minuteHour[0] );
       int mm = Integer.parseInt( minuteHour[1] );
       return mm+hh*60;
    }

    private String convertMinuteToTime(int startTime, int endTime)
    {
        int mmStart = startTime%60;
        int hhStart = startTime/60;
        int mmEnd = endTime%60;
        int hhEnd = endTime/60;
        
        return hhStart+":"+mmStart+"-"+hhEnd+":"+mmEnd;
    }
    private ArrayList<String> getUpdatedCalendar( ArrayList<String> calendar, String dailyBounds )
    {
        ArrayList<String> updatedCalendar = new ArrayList<String>();
        updatedCalendar.add( "0:00-"+dailyBounds.split( "-" )[0] );
        updatedCalendar.addAll( calendar );
        updatedCalendar.add( dailyBounds.split( "-" )[1] +"-23:99" );
        return updatedCalendar;
    }
    
    

    public static void main( String[] args )
    {
        ArrayList<String> calendar1 = new ArrayList<String>();
        calendar1.add( "9:00-10:30" );
        calendar1.add( "12:00-13:00" );
        calendar1.add( "16:00-18:00" );
     
        ArrayList<String> calendar2 = new ArrayList<String>();
        calendar2.add( "10:00-11:30" );
        calendar2.add( "12:30-14:30" );
        calendar2.add( "14:30-15:00" );
        calendar2.add( "16:00-17:00" );
        
        CalendarMatch match = new CalendarMatch();
        ArrayList<String> matchingTime = match.getCalendarMatchingTime( calendar1, "9:00-20:00", calendar2, "10:00-18:30", 30 );
        for(String meeting: matchingTime)
            System.out.println( meeting );

    }

}
class Meeting
{
    int startTime ;
    int endTime;
    public Meeting( int startTime, int endTime )
    {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Meeting(String time)
    {
        this.startTime =convertTimeToMinute( time.split( "-" )[0]);
        this.endTime = convertTimeToMinute( time.split( "-" )[1] );
    }
    
    private int convertTimeToMinute( String time )
    {
       String[] minuteHour = time.split( ":");
       int hh = Integer.parseInt( minuteHour[0] );
       int mm = Integer.parseInt( minuteHour[1] );
       return mm+hh*60;
    }
    
}