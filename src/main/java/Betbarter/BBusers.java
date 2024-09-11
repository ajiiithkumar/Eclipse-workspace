package Betbarter;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BBusers {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://qabb.betbarter.com/online-bo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Login
        driver.findElement(By.id("signinname")).sendKeys("jadmin");
        driver.findElement(By.id("signinpassword")).sendKeys("Test@123");
        Thread.sleep(5000);

        driver.findElement(By.id("login_button")).click();

        driver.get("https://qabb.betbarter.com/online-bo/user_register");

        for (char prefix1 = 'H'; prefix1 <= 'Z'; prefix1++) {
            for (int j = 1; j <= 10; j++) {
                String randomPhoneNumber = generatePhoneNumber();

                String username = "" + prefix1 + prefix1 + prefix1 + "Test" + j;
                String email = "" + prefix1 + prefix1 + prefix1 + "Test" + j + "@gmail.com";

                driver.findElement(By.id("USERNAME")).sendKeys(username);
                driver.findElement(By.id("EMAIL")).sendKeys(email);
                driver.findElement(By.id("PASSWORD")).sendKeys("Test@123");
                driver.findElement(By.id("CONFIRM_PASSWORD")).sendKeys("Test@123");
                driver.findElement(By.id("CONTACT")).sendKeys(randomPhoneNumber);

                // Submit the registration form
                driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
                Thread.sleep(1000);

                // Navigate back to the registration page
                driver.get("https://qabb.betbarter.com/online-bo/user_register");
                Thread.sleep(1000);
            }
        }

        // Close the browser
        driver.quit();
    }

    private static String generatePhoneNumber() {
        // Generate a random 10-digit phone number
        StringBuilder phoneNumber = new StringBuilder("9");

        for (int i = 0; i < 9; i++) {
            phoneNumber.append((int) (Math.random() * 10)); // Append a random digit (0-9)
        }

        return phoneNumber.toString();
    }
}
