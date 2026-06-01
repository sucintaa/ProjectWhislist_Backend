/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package wishlist;
//
///**
// *
// * @author palan
// */
//public class OpenGraphExtractor {
//    
//}
package wishlist;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class OpenGraphExtractor {

    public static ProductPreview extract(String url) throws Exception {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

        String title = doc.select("meta[property=og:title]").attr("content");
        String image = doc.select("meta[property=og:image]").attr("content");
        String description = doc.select("meta[property=og:description]").attr("content");

        // Fallbacks
        if (title.isEmpty()) {
            title = doc.title();
        }

        if (image.isEmpty()) {
            image = doc.select("img").first() != null
                    ? doc.select("img").first().absUrl("src")
                    : "";
        }

        return new ProductPreview(title, image, description, url);
    }
}

