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

public class RedditPost {
    public static void Scrap(String getUrl, int index) throws FileNotFoundException {
        Document doc = null;
        JSONObject obj = new JSONObject();
        String url = getUrl;
        try {
            doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(20000).get();
            String link = "D:/Data/";
            Element shredditTitle = doc.selectFirst("shreddit-title");
            Element postContent = doc.getElementsByTag("shreddit-post").getFirst();
            Elements p = postContent.select("div p");
            String content = "";
            String subredditDescription = p.getFirst().text();
            p.remove(0);
            for (Element text : p) {
                content = content + text.text();
            }
            NotegptSummaryAI ai = new NotegptSummaryAI();
            String summarizedContent = ai.summaryUrl(getUrl);
            obj.put("title", shredditTitle.attr("title"));
            obj.put("subredditDesription", subredditDescription);
            obj.put("content", content);
            obj.put("url", getUrl);
              link = link + "r" + index + ".json";
            FileWriter file = new FileWriter(link);
            file.write(obj.toString());
            file.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
