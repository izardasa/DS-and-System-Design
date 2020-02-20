package com.designpatter.adapter;

public class MediaPlayerDemo
{

    public static void main( String[] args )
    {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play( "vlc", "Every night in my dream." );
        audioPlayer.play( "mp4", "Rythm divine." );
        audioPlayer.play( "mp3", "Now I know why you wanna hate me" );
        audioPlayer.play( "tyl", "Those were the best days." );

           
    }

}
