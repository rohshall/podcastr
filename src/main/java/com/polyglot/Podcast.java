package com.polyglot;

import java.io.*;
import java.util.*;
import java.net.URL;

public class Podcast
{
    private final String title;
    private final String mediaUrl;

    public Podcast( String title, String mediaUrl )
    {
        this.title = title;
        this.mediaUrl = mediaUrl;
    }

    public String getTitle()
    { 
        return title; 
    }
    
    public String getMediaUrl()
    {
        return mediaUrl;
    }
    
    public void download()
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        String filename = mediaUrl.substring( mediaUrl.lastIndexOf( '/' ) + 1 );
        System.out.println( title );
        System.out.println( "Downloding " + mediaUrl );
        try {
            in = new BufferedInputStream(new URL( mediaUrl ).openStream());
            out = new BufferedOutputStream( new FileOutputStream( filename ) );
            byte data[] = new byte[1024];
            int count;
            while((count = in.read(data,0,1024)) != -1)
            {
                out.write(data, 0, count);
            }
        } catch( IOException e ) {
            System.out.println( "File output error!" );
        } finally {
            if( out != null ) {
                try {
                    out.close();
                } catch( IOException e ) {
                }
            }
        }
    }

}
