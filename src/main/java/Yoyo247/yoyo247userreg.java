package Yoyo247;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class yoyo247userreg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
       
        
        		
               for(int i=1 ;i<100;i++) {
            	   String randomPhoneNumber = generatePhoneNumber();
            	driver.get("https://devyo.bollytech.com/");
           		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           		driver.findElement(By.xpath("//*[@id = 'signbtn']")).click();
           		Thread.sleep(1000);
           		driver.findElement(By.xpath("//*[@id = 'username']")).sendKeys("fbtest"+i); 
               Thread.sleep(1000);
               driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("fbtest"+i+"@gmail.com");        
               driver.findElement(By.xpath("//*[@id = 'password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'c_password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys(randomPhoneNumber);
               WebElement dropdownElement = driver.findElement(By.name("form_language"));
               Select drplang = new Select(dropdownElement);
            // Select by value "english"
               drplang.selectByValue("english");
               driver.findElement(By.xpath("//*[@id = 'terms']")).click();
               driver.findElement(By.xpath("//button[@class='login-btn register-submit']")).click();
               Thread.sleep(5000);
               //driver.findElement(By.xpath("//img[@class='userdtls_drop_icn']")).click();
               driver.findElement(By.xpath("//*[text()='Logout']")).click();
               Thread.sleep(2000);
               //driver.findElement(By.xpath("//a[@class='logout_btn22']")).click();
               //Thread.sleep(3000);
               //driver.get("https://qaenv.satbet.com/");
               //Thread.sleep(5000);

               }
               
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

