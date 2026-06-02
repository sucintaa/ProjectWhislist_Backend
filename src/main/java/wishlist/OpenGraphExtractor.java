package wishlist;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class OpenGraphExtractor {

    // New method: extract from HTML instead of fetching the URL
    public static ProductPreview extractFromHtml(String html, String url) throws Exception {
        Document doc = Jsoup.parse(html, url);

        String title = doc.select("meta[property=og:title]").attr("content");
        String image = doc.select("meta[property=og:image]").attr("content");
        String description = doc.select("meta[property=og:description]").attr("content");

        // Fallbacks
        if (title == null || title.isEmpty()) {
            title = doc.title();
        }

        if (image == null || image.isEmpty()) {
            image = doc.select("img").first() != null
                    ? doc.select("img").first().absUrl("src")
                    : "";
        }

        return new ProductPreview(title, image, description, url);
    }
}
