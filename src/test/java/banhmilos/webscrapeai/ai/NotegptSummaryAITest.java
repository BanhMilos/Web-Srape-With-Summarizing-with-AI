package banhmilos.webscrapeai.ai;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotegptSummaryAITest {

    @Test
    void summary() {
        try {
            String url = "https://vi.m.wikipedia.org/wiki/H%E1%BB%87_M%E1%BA%B7t_Tr%E1%BB%9Di";
            String text = new NotegptSummaryAI().summaryUrl(url);
            assertTrue(text.startsWith("Hệ Mặt Trời – Wikipedia tiếng Việt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}