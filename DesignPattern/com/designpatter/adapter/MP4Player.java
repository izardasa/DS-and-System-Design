package com.designpatter.adapter;

public class MP4Player implements AdvancedMediaPlayer
{

    @Override
    public void playVlc( String fileName )
    {
        // TODO Do nothing
        
    }

    @Override
    public void playMp4( String fileName )
    {
        System.out.println( "Playing MP4 file: "+fileName );
    }

}
