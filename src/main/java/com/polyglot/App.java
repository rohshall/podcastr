package com.polyglot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RSSFeedParser.parse( "http://feeds.feedburner.com/TheEpilepticGibbonPodcastMusicShow" );
        int numPodcasts = PodcastArray.PodcastTitle.length;
        for( int i = 0; i < numPodcasts; i++ )
        {
            System.out.println( PodcastArray.PodcastTitle[i] );
        }
    }
}
