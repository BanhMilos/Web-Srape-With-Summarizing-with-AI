package banhmilos.webscrapeai.ai;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URLEncoder;

public class NotegptSummaryAI implements SummaryAI {

    @Override
    public String summary(String url) throws IOException {
        String api = "https://notegpt.io/api/v1/ai-tab/gpts-summary?url=" + URLEncoder.encode(url, "UTF-8");
        String response = Jsoup.connect(api).ignoreContentType(true).get().body().text();
        JsonElement json = JsonParser.parseString(response);
        String result = json.getAsJsonObject().get("data").getAsJsonObject().get("text").getAsString();
        return result;
    }
}
