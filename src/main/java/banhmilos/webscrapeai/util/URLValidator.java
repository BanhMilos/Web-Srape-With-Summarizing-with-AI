package banhmilos.webscrapeai.util;

import java.net.MalformedURLException;
import java.net.URI;

public class URLValidator {
    public static boolean isValidUrl(String url) {
        try {
            URI.create(url).toURL();
            return true;
        } catch (MalformedURLException | IllegalArgumentException e) {
            return false;
        }
    }
}
