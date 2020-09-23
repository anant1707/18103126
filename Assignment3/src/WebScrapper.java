import java.io.FileWriter;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import java.util.*;
import org.jsoup.Connection;

public class WebScrapper 
{
    static String BASE;//base url
    static HashSet<String> visited;//visited urls
    static FileWriter ScrapeAll;//csv file to write
    static FileWriter ScrapeFaculty;//csv file to write the faculty data
    static FileWriter DownloadablePdfs;
    private static Document connect(String url, int tries)
    {
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
    public static void search(String url,int depth) throws IOException //search function based on DFS
    {
        //System.out.println(url);
        visited.add(url);

        if(depth>300)
        return;

        if(url.endsWith(".pdf"))
        {
            DownloadablePdfs.write(url+"\n");
            return;
        }
        Document page =connect(url,1);
        if(page==null)
        return;
        Elements text = page.select("p");
        for(Element t: text)
        {
            ScrapeAll.write("<p>," + "\"" +t.text()+ "\""+"," +"\""+ url +"\""+ "\n");
            if(url.contains("faculty") || url.contains("FACULTY") || url.contains("Faculty") || t.text().contains("faculty"))
                ScrapeFaculty.write("<p>," + "\"" +t.text()+ "\""+"," +"\""+ url +"\""+ "\n");
        }
        Elements links = page.select("a[href]");

        for (Element link : links) 
        {
            String suburl=link.attr("href");
            //System.out.println(suburl);
            if(suburl.startsWith("/"))
            {
                suburl= BASE+suburl;
            }

            if(!visited.contains(suburl) && suburl.contains(BASE))
                search(suburl,depth+1);
        }
    }

    public static void main(String[] args) throws IOException 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the URL: ");//Taking input the base url
        visited= new HashSet<String>();
        ScrapeAll=new FileWriter("Data_All.csv");
        ScrapeFaculty=new FileWriter("Data_Faculty.csv");
        DownloadablePdfs= new FileWriter("Downloadable_PDFs.csv");
        ScrapeAll.write("TAG,TEXT,LINK\n");
        BASE = input.nextLine();
        //System.out.println(BASE);
        search(BASE,0);// calling the search function
        input.close();
        ScrapeAll.close();
        ScrapeFaculty.close();
        DownloadablePdfs.close();
    }

}

