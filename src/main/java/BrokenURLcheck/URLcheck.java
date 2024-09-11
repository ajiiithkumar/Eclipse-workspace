package BrokenURLcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class URLcheck {

    public static void main(String[] args) {

        // Set up WebDriver (Make sure you have the correct path to chromedriver)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

        // Optional: to run without opening a browser window
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--remote-debugging-port=9222");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Specify the URL of the website you want to check
            driver.get("https://www.stakeheroes.com/");

            // Find all links and images
            List<WebElement> elements = driver.findElements(By.xpath("//a[@href] | //img[@src]"));

            for (WebElement element : elements) {
                String url = element.getAttribute("href") != null ? element.getAttribute("href") : element.getAttribute("src");

                // Check if the link or image is broken
                checkBrokenLink(url);
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void checkBrokenLink(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Broken link found: " + urlString + " - Response Code: " + responseCode);
            } else {
                System.out.println("Valid link: " + urlString + " - Response Code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error checking URL: " + urlString + " - " + e.getMessage());
        }
    }
}
