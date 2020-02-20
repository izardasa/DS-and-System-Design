package com.designpattern.facade;

public class HomeTheaterDemo
{

    public static void main( String[] args )
    {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLight theatreLight = new TheaterLight();
        HomeTheater homeTheatre = new HomeTheater( dvdPlayer, projector, screen, theatreLight );
        System.out.println( "I'm starting the Home Theatre." );
        System.out.println( "-----------------------------" );
        homeTheatre.watchMovie();
        
        System.out.println( "\nI'm truning off the Home Theatre." );
        System.out.println( "--------------------------------" );
        homeTheatre.endMovie();
    }

}
