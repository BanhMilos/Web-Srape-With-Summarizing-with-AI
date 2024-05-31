package banhmilos.webscrapeai.Scrapping;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import banhmilos.webscrapeai.ai.NotegptSummaryAI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.JSONObject;

public class RedditPostScrapper {
    public JSONObject redditPost (String getUrl) throws FileNotFoundException {
        Document doc = null;
        JSONObject obj = new JSONObject();
        String url = getUrl;
        try {
            doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(20000).get();
            Element shredditTitle = doc.selectFirst("shreddit-title");
            Element postContent = doc.getElementsByTag("shreddit-post").getFirst();
            Elements p = postContent.select("div p");
            String content = "";
            String subredditDescription = p.getFirst().text();
            p.removeFirst();
            for (Element text : p) {
                content = content + text.text();
            }
            assert shredditTitle != null;
            obj.put("title", shredditTitle.attr("title"));
            obj.put("subredditDesription", subredditDescription);
            obj.put("content", content);
            obj.put("url", getUrl);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
