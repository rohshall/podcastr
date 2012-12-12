package com.polyglot;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader br = null;
        try {
            br = new BufferedReader( new FileReader( "feeds.txt" ) );
            String feedUrl;
            while( (feedUrl = br.readLine()) != null )
            {
                System.out.println( "Feeds in " + feedUrl );
                List<Podcast> podcasts = RSSFeedParser.parse( feedUrl );
                for( Podcast podcast : podcasts )
                {
                    podcast.download();
                }
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
