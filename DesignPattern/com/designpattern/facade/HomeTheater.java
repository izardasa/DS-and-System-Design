package com.designpattern.facade;

public class HomeTheater
{
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;
    private TheaterLight theatreLight;
    public HomeTheater( DVDPlayer dvdPlayer, Projector projector, Screen screen, TheaterLight theatreLight )
    {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.screen = screen;
        this.theatreLight = theatreLight;
    }
    
    public void watchMovie()
    {
        System.out.println( "Get ready to watch a movie." );
        theatreLight.on();
        theatreLight.dim();
        projector.on();
        screen.up();
        dvdPlayer.on();
        dvdPlayer.play();
    }
    
    public void endMovie()
    {
        System.out.println( "Shutting down the movie threatre" );
        
        projector.off();
        theatreLight.off();
        dvdPlayer.off();
        screen.down();
    }
}
