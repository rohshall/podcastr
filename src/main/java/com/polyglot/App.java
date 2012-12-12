package com.polyglot;

import java.io.*;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void downloadUrl( String mediaUrl )
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        String filename = mediaUrl.substring( mediaUrl.lastIndexOf( '/' ) + 1 );
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

    private static void processFeedUrl( String feedUrl )
    {
        RSSFeedParser.parse( feedUrl );
        int numPodcasts = PodcastArray.PodcastTitle.length;
        for( int i = 0; i < numPodcasts; i++ )
        {
            System.out.println( PodcastArray.PodcastTitle[i] );
            System.out.println( "Downloding " + PodcastArray.PodcastMedia[i] );
            downloadUrl( PodcastArray.PodcastMedia[i] );
        }
    }


    public static void main( String[] args )
    {
        BufferedReader br = null;
        try {
            br = new BufferedReader( new FileReader( "feeds.txt" ) );
            String line;
            while( (line = br.readLine()) != null )
            {
                System.out.println( "Feeds in " + line );
                processFeedUrl( line );
                System.out.println();
            }
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found!" );
        } catch( IOException e ) {
            System.out.println( "File input error!" );
        } finally {
            if( br != null ) {
                try {
                    br.close();
                } catch( IOException e ) {
                }
            }
        }
    }
}
