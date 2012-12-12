package com.polyglot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Following code is borrowed mostly as it is from:
 * http://droidapp.co.uk/2011/05/12/android-dev-reading-a-rss-feed/
 */
public class RSSFeedParser
{
    public static List<Podcast> parse( String feedUrl )
    {
        URL url;
        ArrayList<Podcast> podcasts = null;
        try 
        {
            url = new URL( feedUrl );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc;
                doc = db.parse(url.openStream());
                doc.getDocumentElement().normalize();
                NodeList itemLst = doc.getElementsByTagName("item");
                int numItems = itemLst.getLength();
                
                podcasts = new ArrayList<Podcast>( numItems );

                for(int i=0; i < numItems; i++)
                {
                    Node item = itemLst.item(i);
                    if(item.getNodeType() == Node.ELEMENT_NODE)
                    {
                          Element ielem = (Element)item;
                          NodeList title = ielem.getElementsByTagName("title");
                          String pTitle = title.item(0).getChildNodes().item(0).getNodeValue();
                          //NodeList description = ielem.getElementsByTagName("description"); 
                          NodeList media = ielem.getElementsByTagName("media:content");
                          String pMediaUrl = media.item(0).getAttributes().getNamedItem("url").getNodeValue();
                          
                          podcasts.add( new Podcast( pTitle, pMediaUrl ) );
                    }
                }
            }
        } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (DOMException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return podcasts;
    }
}
