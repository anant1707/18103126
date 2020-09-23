/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import java.util.*;

public class WebScrapper 
{
    static String BASE;
    static HashSet<String> visited=new HashSet();
    private static Document connect(String url, int tries){
        if(tries > 3){
            System.out.println("Failure! Tried 3 times to connect to " + url + ". Moving forward...");
            return null;
        }
        try{
            System.out.print("Trying to connect(" +  tries + ") to " + url + ": ");
            Connection conn = Jsoup.connect(url);
            Document page = conn.get();
            if(conn.response().statusCode() == 200){
                System.out.println("Status OK");
                if(!conn.response().contentType().contains("text/html")){
                    System.out.println("Oops! not a HTML page. Moving forward...");
                    return null;
                }
                return page;
            }
            else{
                System.out.println("Status FAILED. Retrying...");
                return connect(url, tries+1);
            }
        } catch(IOException e){
            System.out.println("Some Error has occured. Moving forward...");
            return null;
        }
    }
    public static void search(String url) throws IOException 
    {
        System.out.println(url);
        visited.add(url);
        Document page = connect(url, 1);
        Elements links = page.select("a[href]");
        for (Element link : links) 
        {
            String suburl=link.attr("href");
            System.out.println(suburl);
            if(suburl.charAt(0)=='/')
            {
                suburl= BASE+suburl;
            }

            if(!visited.contains(suburl) && suburl.contains(BASE))
                search(suburl);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the URL: ");
        BASE = input.nextLine();
        System.out.println(BASE);
        search(BASE);
        input.close();
    }

}

