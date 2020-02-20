package com.designpattern.facade;

public class DVDPlayer
{
    public void on()
    {
        System.out.println( "DVD player is on." );
    }
    
    public void off()
    {
        System.out.println( "DVD player is off." );
    }
    public void play()
    {
        System.out.println( "Play movie" );
    }
    
    public void stop()
    {
        System.out.println( "Stop movie." );
    }
}
