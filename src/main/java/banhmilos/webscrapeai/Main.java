package banhmilos.webscrapeai;

import banhmilos.webscrapeai.ai.NotegptSummaryAI;

public class Main {
    public static void main(String[] args) {
        NotegptSummaryAI test = new NotegptSummaryAI();
        String testUrl = "https://www.nytimes.com/search?query=blockchain";
        try {
            String testRes = test.summaryUrl(testUrl);
            System.out.println(testRes);
        }
        catch (Exception e) {
            System.out.println("oh no");
        }
    }
}