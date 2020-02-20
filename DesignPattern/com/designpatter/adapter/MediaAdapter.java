package com.designpatter.adapter;

public class MediaAdapter implements MediaPlayer
{
    AdvancedMediaPlayer advancedMediaPlayer;
    
    public MediaAdapter(String fileType)
    {
        if(fileType.equals( "mp4" ))
            advancedMediaPlayer = new MP4Player();
        else if(fileType.equals( "vlc" ))
            advancedMediaPlayer = new VLCPlayer(); 
    }
    @Override
    public void play( String audioType, String fileName )
    {
        if(audioType.equals( "mp4" ))
            advancedMediaPlayer.playMp4( fileName );
        else if(audioType.equals( "vlc"))
            advancedMediaPlayer.playVlc( fileName );
        
    }

}
