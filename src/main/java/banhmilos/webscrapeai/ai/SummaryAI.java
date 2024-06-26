package banhmilos.webscrapeai.ai;

import java.io.IOException;

public interface SummaryAI {
    /**
     * Get summary of url
     * @param url Url to be summarized
     * @return text summary
     */
    String summaryUrl(String url) throws IOException;
}
