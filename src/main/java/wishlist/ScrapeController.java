//package wishlist;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@RestController
//public class ScrapeController {
//
//    @Autowired
//    private ScrapeService scrapeService;
//
//    // JSON endpoint for Postman
//    @PostMapping("/scrape")
//    public ScrapeResponse scrape(@RequestBody ScrapeRequest request) {
//        return scrapeService.scrapeShopifyProduct(request.getUrl());
//    }
//
//    // HTML preview endpoint for browser
//    @GetMapping("/preview")
//    public String preview(@RequestParam String url) {
//        ScrapeResponse product = scrapeService.scrapeShopifyProduct(url);
//
//        String html = ""
//            + "<html>"
//            + "<body style='font-family: Arial; max-width: 600px; margin: 40px auto; line-height: 1.6;'>"
//            + "<h1 style='font-size: 28px; margin-bottom: 10px;'>" + product.getName() + "</h1>"
//            + "<img src='" + product.getMainImage() + "' "
//            + "style='width: 100%; border-radius: 10px; margin-bottom: 20px;' />"
//            + "<h2 style='font-size: 22px; color: #444;'>Price: "
//            + product.getPrice() + " " + product.getCurrency() + "</h2>"
//            + "<div style='margin-top: 20px; font-size: 16px; color: #333;'>"
//            + product.getDescription()
//            + "</div>"
//            + "</body>"
//            + "</html>";
//
//        return html;
//    }
//}
package wishlist;

import org.springframework.web.bind.annotation.*;

@RestController
public class ScrapeController {

    private final ScrapeService scrapeService;

    public ScrapeController(ScrapeService scrapeService) {
        this.scrapeService = scrapeService;
    }

    // Phase 1: Metadata extraction (POST)
    @PostMapping("/preview")
    public ProductPreview preview(@RequestBody ScrapeRequest request) {
        return scrapeService.extractMetadata(request.getUrl());
    }
}
