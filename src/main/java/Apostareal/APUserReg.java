package Apostareal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class APUserReg {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		 //ChromeOptions options = new ChromeOptions();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
      
        		
        		driver.get("https://devaponbo.arealboffice.com/login");
        		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        		driver.findElement(By.xpath("//*[@id = 'signinname']")).sendKeys("jadmin");
               driver.findElement(By.xpath("//*[@id = 'signinpassword']")).sendKeys("Test@123");    
               Thread.sleep(5000);
               driver.findElement(By.xpath("//*[@id = 'login_button']")).click();
               driver.get("https://devaponbo.arealboffice.com/user_register");
               for(int i=118;i<=1000;i++) {
            	   String randomPhoneNumber = generatePhoneNumber();
               driver.findElement(By.xpath("//*[@id = 'USERNAME']")).sendKeys("testch"+i);        
               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).sendKeys("testch"+i+"@gmail.com");        
//               driver.findElement(By.xpath("//*[@class = 'fa fa-edit edit_icon']")).click();        
//               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).clear();        
               //driver.findElement(By.xpath("//*[@id = 'CPF_NUMBER']")).clear();
               driver.findElement(By.xpath("//*[@id = 'PASSWORD']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'CONFIRM_PASSWORD']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'CONTACT']")).sendKeys(randomPhoneNumber);
               //driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys(randomPhoneNumber);
               
               driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
               Thread.sleep(2000);
               driver.get("https://devaponbo.arealboffice.com/user_register");
               Thread.sleep(2000);
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
