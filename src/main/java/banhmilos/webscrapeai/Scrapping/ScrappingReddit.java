package banhmilos.webscrapeai.Scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ScrappingReddit {
    public static void main(String[] args) {
        String url = "https://www.reddit.com/search/?q=blockchain&type=link&cId=4cb2c9eb-ac88-478d-957f-b7a3543280f6&iId=d29afdcd-93f7-4eba-8ecf-803962b7fc59";
        Document doc = null;
        int index = 0;
        try {
            doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(20000).get();
            Elements li = doc.select("faceplate-tracker post-consume-tracker div faceplate-tracker h2 a");
            for (Element element : li) {
                String getUrl = "https://www.reddit.com" + element.attr("href");
                RedditPost.Scrap(getUrl, index);
                index++;
                //RedditPost.Scrap(getUrl);
                getUrl = "";
                //System.out.println("https://www.reddit.com" + element.attr("href"));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}