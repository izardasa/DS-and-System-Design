package com.designpatter.adapter;

public class AudioPlayer implements MediaPlayer
{

    MediaAdapter mediaAdapter;

    @Override
    public void play( String audioType, String fileName )
    {
        // Inbuilt support for mp3 files
        if( audioType.equals( "mp3" ) )
            System.out.println( "Playing mp3 file :" + fileName );

        // MediaAdapter is supporting other files like mp4 and vlc formats
        else if( audioType.equals( "vlc" ) || audioType.equals( "mp4" ) )
        {
            mediaAdapter = new MediaAdapter( audioType );
            mediaAdapter.play( audioType, fileName );
        }
        else
            System.out.println( "Invalid Media : " + fileName );

    }

}
