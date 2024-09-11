package Exchange;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
       
        		
        		
               for(int i=30;i<=65;i++) {
            	driver.get("https://devenvexchmarket.bollytech.com/");
           		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           		driver.findElement(By.xpath("//*[@id = 'signbtn']")).click();
           		Thread.sleep(1000);
           		driver.findElement(By.xpath("//*[@id = 'username']")).sendKeys("Testfs"+i); 
               Thread.sleep(1000);
               driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("Testfs"+i+"@gmail.com");        
               driver.findElement(By.xpath("//*[@id = 'password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'c_password']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys("98934100"+i);
               WebElement dropdownElement = driver.findElement(By.name("form_language"));
               Select drplang = new Select(dropdownElement);
               
               // Select by value "english"
               drplang.selectByValue("english");
               driver.findElement(By.xpath("//*[@id = 'terms']")).click();
               driver.findElement(By.xpath("//button[@class='login-btn register-submit']")).click();
               Thread.sleep(7000);
               //driver.findElement(By.xpath("//img[@class='header_usr_icon']")).click();
              
               driver.findElement(By.xpath("//a[text()='Logout']")).click();
               //Thread.sleep(3000);
               //driver.get("https://devenvexchmarket.bollytech.com/");
               Thread.sleep(5000);
               }
	}
}
