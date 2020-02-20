package com.designpatter.adapter;

public class VLCPlayer implements AdvancedMediaPlayer
{

    @Override
    public void playVlc( String fileName )
    {
        System.out.println( " Playing vlc file: "+fileName );
        
    }

    @Override
    public void playMp4( String fileName )
    {
        // TODO Do nothing
        
    }

}
