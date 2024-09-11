package L7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UserRegSite {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
       
        		
        		
               for(int i=4;i<=10;i++) {
            	driver.get("https://devenvl7.bollytech.com/");
           		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           		driver.findElement(By.xpath("//*[@id = 'signbtn']")).click();
           		Thread.sleep(1000);
           		driver.findElement(By.xpath("//*[@id = 'username']")).sendKeys("Testuser"+i); 
               //Thread.sleep(1000);                                 
               //driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("Testcam"+i+"@gmail.com");        
               driver.findElement(By.xpath("//*[@id = 'password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'c_password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys("979035100"+i);
               Select drpCountry = new Select(driver.findElement(By.id("form_language")));
               drpCountry.selectByValue("english");
               driver.findElement(By.xpath("//*[@id = 'terms']")).click();
               driver.findElement(By.xpath("//button[@class='login-btn register-submit']")).click();
               Thread.sleep(7000);
               //driver.findElement(By.xpath("//img[@class='header_usr_icon']")).click();
               //Thread.sleep(1000);
               driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
               Thread.sleep(3000);
               //driver.get("https://qaenv.satbet.com/");
               //Thread.sleep(5000);
               }
	}
}
