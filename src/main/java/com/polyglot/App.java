package com.polyglot;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void processFeedUrl( String feedUrl )
    {
        RSSFeedParser.parse( feedUrl );
        int numPodcasts = PodcastArray.PodcastTitle.length;
        for( int i = 0; i < numPodcasts; i++ )
        {
            System.out.println( PodcastArray.PodcastTitle[i] );
        }
    }


    public static void main( String[] args )
    {
        try {
            FileReader fr = new FileReader( "feeds.txt" );
            BufferedReader br = new BufferedReader( fr );
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
        }
    }
}
