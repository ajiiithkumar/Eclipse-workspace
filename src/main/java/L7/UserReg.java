package L7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class UserReg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
       
        		
        		driver.get("https://l7onbo.bollytech.com/");
        		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        		driver.findElement(By.xpath("//*[@id = 'signinname']")).sendKeys("devadmin");
               driver.findElement(By.xpath("//*[@id = 'signinpassword']")).sendKeys("L7Test@123");    
               Thread.sleep(5000);
               driver.findElement(By.xpath("//*[@id = 'login_button']")).click();
               driver.get("https://l7onbo.bollytech.com/user_register");
               for(int i=1;i<=10;i++) {
               driver.findElement(By.xpath("//*[@id = 'USERNAME']")).sendKeys("User"+i);        
               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).sendKeys("User"+i+"@gmail.com");        
//               driver.findElement(By.xpath("//*[@class = 'fa fa-edit edit_icon']")).click();        
//               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).clear();        
//               driver.findElement(By.xpath("//*[@id = 'CPF_NUMBER']")).clear();
               driver.findElement(By.xpath("//*[@id = 'PASSWORD']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'CONFIRM_PASSWORD']")).sendKeys("Test@123");
               driver.findElement(By.xpath("//input[@id='FIRST_NAME']")).sendKeys("Test");
               driver.findElement(By.xpath("//input[@id='LAST_NAME']")).sendKeys("user");
               driver.findElement(By.xpath("//span[@class='selection']")).click();
               driver.findElement(By.xpath("//li[@id='select2-GENDER-result-yaj4-male']")).click();
               
               driver.findElement(By.xpath("(//span[@class='select2-selection__rendered'])[2]")).click();
               driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("India");
               
               
               driver.findElement(By.xpath("//*[@id = 'CONTACT']")).sendKeys("9893100"+i);
               driver.findElement(By.xpath("//button[@class='btn btn-info disabled']")).click();
               Thread.sleep(2000);
               driver.get("https://l7onbo.bollytech.com/user_register");
               Thread.sleep(2000);
               }
	}
}
