package wishlist;

import org.springframework.stereotype.Service;

@Service
public class ScrapeService {

    private final PlaywrightScraper playwrightScraper;

    public ScrapeService(PlaywrightScraper playwrightScraper) {
        this.playwrightScraper = playwrightScraper;
    }

    public ProductPreview extractMetadata(String url) {
        try {
            // 1. Load the full HTML using Playwright (bypasses Cloudflare, JS, etc.)
            String html = playwrightScraper.getHtml(url);

            // 2. Extract metadata (OG tags, JSON-LD, etc.)
            return OpenGraphExtractor.extractFromHtml(html, url);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to extract metadata: " + e.getMessage());
        }
    }
}
