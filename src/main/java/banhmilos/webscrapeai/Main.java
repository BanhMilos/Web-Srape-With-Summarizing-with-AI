package banhmilos.webscrapeai;

import banhmilos.webscrapeai.ai.NotegptSummaryAI;

public class Main {
    public static void main(String[] args) {
        NotegptSummaryAI test = new NotegptSummaryAI();
        String testUrl = "https://vi.m.wikipedia.org/wiki/H%E1%BB%87_M%E1%BA%B7t_Tr%E1%BB%9Di";
        try {
            String testRes = test.summaryUrl(testUrl);
            System.out.println(testRes);
        }
        catch (Exception e) {
            System.out.println("oh no");
        }
    }
}