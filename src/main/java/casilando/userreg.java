package casilando;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class userreg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		 //ChromeOptions options = new ChromeOptions();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
      
        		
        		driver.get("https://qacsonbo.digient.co/login");
        		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        		driver.findElement(By.xpath("//*[@id = 'signinname']")).sendKeys("zadmin");
               driver.findElement(By.xpath("//*[@id = 'signinpassword']")).sendKeys("Test@123");    
               Thread.sleep(5000);
               driver.findElement(By.xpath("//*[@id = 'login_button']")).click();
               driver.get("https://qacsonbo.digient.co/user_register");
               for(int i=11;i<=20;i++) {
            	   String randomPhoneNumber = generatePhoneNumber();
               driver.findElement(By.xpath("//*[@id = 'USERNAME']")).sendKeys("bontest"+i);        
               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).sendKeys("bontest"+i+"@gmail.com");        
//               driver.findElement(By.xpath("//*[@class = 'fa fa-edit edit_icon']")).click();        
//               driver.findElement(By.xpath("//*[@id = 'EMAIL']")).clear();        
//               driver.findElement(By.xpath("//*[@id = 'CPF_NUMBER']")).clear();
               driver.findElement(By.xpath("//*[@id = 'PASSWORD']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'CONFIRM_PASSWORD']")).sendKeys("Test@123");  
               driver.findElement(By.xpath("//*[@id = 'CONTACT']")).sendKeys(randomPhoneNumber);
               //driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys(randomPhoneNumber);
               WebDriverWait wait = new WebDriverWait(driver, 10);
               driver.findElement(By.xpath("//*[@id='select2-COUNTRY_CODE-container']")).click();
               driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
               String code = "+91"; 
               String optionXPath = String.format("(//li[contains(text(), '%s')])", code);
               WebElement optionToSelect = driver.findElement(By.xpath(optionXPath));
               wait.until(ExpectedConditions.elementToBeClickable(optionToSelect)).click();
               Thread.sleep(500);
               
               driver.findElement(By.xpath("//*[@id='select2-CURRENCY_CODE-container']")).click();
               driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
               String currency = "INR"; 
               String optionXPath1 = String.format("(//li[contains(text(), '%s')])", currency);
               WebElement optionToSelect1 = driver.findElement(By.xpath(optionXPath1));
               wait.until(ExpectedConditions.elementToBeClickable(optionToSelect1)).click();
               Thread.sleep(500);
               
               driver.findElement(By.xpath("//*[@id='select2-countryId-container']")).click();
               driver.findElement(By.xpath("//*[@class='select2-search__field']")).click();
               String country = "India"; 
               String optionXPath2 = String.format("(//li[contains(text(), '%s')])", country);
               WebElement optionToSelect2 = driver.findElement(By.xpath(optionXPath2));
               wait.until(ExpectedConditions.elementToBeClickable(optionToSelect2)).click();
               Thread.sleep(500);

//               WebElement dropdownElement = driver.findElement(By.xpath("//*[@id='select2-COUNTRY_CODE-container']"));
//               Select drplang = new Select(dropdownElement);
//            // Select by value "english"
//               drplang.selectByIndex(1);
              
//               WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id='select2-CURRENCY_CODE-container']"));
//               Select drpcountry = new Select(dropdownElement1);
//            // Select by value "english"
//               drpcountry.selectByIndex(2);
               //Thread.sleep(15000);
               
               driver.findElement(By.xpath("//button[@class='btn btn-info disabled']")).click();
              Thread.sleep(500);
               driver.get("https://qacsonbo.digient.co/user_register");
               Thread.sleep(500);
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
