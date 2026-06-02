/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package wishlist;
//
//import com.microsoft.playwright.*;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PlaywrightScraper {
//
//    public String getHtml(String url) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions().setHeadless(true)
//            );
//
//            Page page = browser.newPage();
//            page.navigate(url);
//
//            return page.content();
//        }
//    }
//}
package wishlist;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Service;

@Service
public class PlaywrightScraper {

    public String getHtml(String url) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false) // change to true later
            );

            BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                    .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")
                    .setViewportSize(1280, 800)
                    .setLocale("en-GB")
                    .setTimezoneId("Europe/London")
            );

            Page page = context.newPage();

            // Navigate normally
            page.navigate(url);

            // Wait for page to finish loading (default load state)
            page.waitForLoadState();

            return page.content();
        }
    }
}
