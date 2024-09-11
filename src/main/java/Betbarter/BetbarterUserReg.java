package Betbarter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.asprise.ocr.Ocr;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BetbarterUserReg {

    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		
    	//WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://qabb.betbarter.com/online-bo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Login
        driver.findElement(By.id("signinname")).sendKeys("jadmin");
        driver.findElement(By.id("signinpassword")).sendKeys("Test@123");
        Thread.sleep(5000);
        
//        //get captcha
//        WebElement captcha = driver.findElement(By.id("captcha_Image"));
//        String captchaImageSrc = captcha.getAttribute("src");
//        
//        
//        InputStream in = new URL(captchaImageSrc).openStream();
//        OutputStream out = new FileOutputStream("captcha.jpg");
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = in.read(buffer)) != -1) {
//            out.write(buffer, 0, bytesRead);
//        }
//        
//        in.close();
//        out.close();Ocr.setUp(); // One-time setup
//        Ocr ocr = new Ocr();
//        ocr.startEngine("eng", Ocr.SPEED_FASTEST);
//        File captchaImageFile = new File("captcha.jpg");
//        String s = ocr.recognize(new File[] { captchaImageFile }, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT, 0, null);
//        System.out.println(s);
        
        
        
        
        driver.findElement(By.id("login_button")).click();

        driver.get("https://qabb.betbarter.com/online-bo/user_register");

        for (int i = 1; i <=50; i++) {
            String randomPhoneNumber = generatePhoneNumber();

            driver.findElement(By.id("USERNAME")).sendKeys("Smtest" + i);
            driver.findElement(By.id("EMAIL")).sendKeys("Smtest" + i + "@gmail.com");
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
