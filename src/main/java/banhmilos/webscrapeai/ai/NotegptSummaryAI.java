package banhmilos.webscrapeai.ai;

import banhmilos.webscrapeai.util.URLValidator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NotegptSummaryAI implements SummaryAI {

    @Override
    public String summaryUrl(String url) throws IOException {

        if (!URLValidator.isValidUrl(url)) throw new RuntimeException("Not valid url");

        String api = "https://notegpt.io/api/v1/ai-tab/gpts-summary?url=" + URLEncoder.encode(url, StandardCharsets.UTF_8);
        String response = Jsoup.connect(api).ignoreContentType(true).get().body().text();

        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        if (!json.has("data")) throw new RuntimeException("No data");
        JsonObject data = json.get("data").getAsJsonObject();
        if (!data.has("text")) throw new RuntimeException("No text");

        return data.get("text").getAsString();
    }
}
