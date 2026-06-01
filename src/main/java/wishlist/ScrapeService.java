//package wishlist;
//
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class ScrapeService {
//
//    public ScrapeResponse scrapeShopifyProduct(String url) {
//        try {
//            // Convert to Shopify JSON endpoint
//            if (!url.endsWith(".json")) {
//                url = url + ".json";
//            }
//
//            // Create HTTP client
//            HttpClient client = HttpClient.newHttpClient();
//
//            // Build GET request
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            // Send request
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Parse JSON
//            JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
//            JsonObject product = root.getAsJsonObject("product");
//
//            // Build response object
//            ScrapeResponse result = new ScrapeResponse();
//            result.setName(product.get("title").getAsString());
//            result.setDescription(product.get("body_html").getAsString());
//
//            // Extract price + currency
//            JsonObject variant = product.getAsJsonArray("variants").get(0).getAsJsonObject();
//            result.setPrice(variant.get("price").getAsString());
//            result.setCurrency(variant.get("price_currency").getAsString());
//
//            // Extract main image
//            JsonObject image = product.getAsJsonObject("image");
//            result.setMainImage(image.get("src").getAsString());
//
//            return result;
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to scrape product: " + e.getMessage());
//        }
//    }
//}
package wishlist;

import org.springframework.stereotype.Service;

@Service
public class ScrapeService {

    public ProductPreview extractMetadata(String url) {
        try {
            return OpenGraphExtractor.extract(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to extract metadata: " + e.getMessage());
        }
    }
}
