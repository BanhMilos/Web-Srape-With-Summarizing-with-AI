package banhmilos.webscrapeai.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLValidatorTest {

    @Test
    void isValidUrl() {
        assertFalse(URLValidator.isValidUrl("test"));
        assertFalse(URLValidator.isValidUrl("abc://test"));
        assertTrue(URLValidator.isValidUrl("ftp://test.com"));
    }
}