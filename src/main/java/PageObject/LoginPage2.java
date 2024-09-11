package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	public WebDriver driver;
	
	//Constructor
	LoginPage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
		
	// WebElements Locators+identification
	//@FindBy(xpath="//img[@alt='company-branding']") 
	@FindBy(xpath="//*[@id=\"loginbutton\"]")
	WebElement Login_Btn;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[2]/input")
	WebElement txt_username;
	
	@FindBy(xpath="//*[@id=\"user-password\"]")
	WebElement txt_password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/button")
	WebElement btn_submit;
		
	//@FindBy(tagName="a")
	//List<WebElement> links;
	
	//Action methods
	public void clicklogin()
	{
		Login_Btn.click();
	}
	
	public void setUserName(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	
	public void clickSubmit()
	{
		btn_submit.click();
	}
		
}
