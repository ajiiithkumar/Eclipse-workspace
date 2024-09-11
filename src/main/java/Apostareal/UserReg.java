package Apostareal;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UserReg {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Explicit wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://devenvap.apostareal.com/registration");
        for(int i=251;i<=300;i++) {
        	   String randomPhoneNumber = generatePhoneNumber();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='cookieshow-button cookieshow-button_1']")).click();
        driver.findElement(By.xpath("//input[@id='cpf_number']")).sendKeys("103.505.836-76");
        driver.findElement(By.xpath("//input[@id='cpf_number_submit_register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='cpf_number_details_submit']")).click();
        WebElement userNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_name']")));
        userNameInput.sendKeys("cbwbtest"+i);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("cbwbtest"+i+"@gmail.com");
        driver.findElement(By.xpath("//input[@id='userpassword']")).sendKeys("Test@123");
        //driver.findElement(By.xpath("//input[@id='user_mobile_no']")).sendKeys("928244400"+i);
        driver.findElement(By.xpath("//*[@id = 'mobile_no']")).sendKeys(randomPhoneNumber);
        driver.findElement(By.xpath("//input[@id='age_cnfrm']")).click();
        Thread.sleep(15000);
        WebElement Submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cpf_submit_register']")));
        Submit.click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//input[@id='cpf_submit_register']")).click();
        
        //BO
        
        driver.get("https://devaponbo.arealboffice.com/dashboard");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='signinname']")).sendKeys("Xadmin");
        driver.findElement(By.xpath("//input[@id='signinpassword']")).sendKeys("Test@123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='login_button']")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='sidebarmenu_players'])[3]")).click();
        driver.findElement(By.xpath("(//a[@class='form_redirect_no ahref_class'])[10]")).click();
        driver.findElement(By.xpath("//input[@id='cpf_number']")).sendKeys("103.505.836-76");
        driver.findElement(By.xpath("//button[@id='search_user']")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-edit edit_icon'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='CPF_NUMBER']")).clear();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(3000);
        driver.get("https://devenvap.apostareal.com/registration");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@class='btn-close'])[7]")).click();
        driver.findElement(By.xpath("//img [@class='img-fluid nav-icon']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img [@class='menu_desktopicon'])[6]")).click();
        driver.findElement(By.xpath("(//div[@class='common-btn logout-btn'])[1]")).click();
        Thread.sleep(3000);
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
