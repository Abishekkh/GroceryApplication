package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class GroceryLoginPage {
	
	WaitUtility wu = new WaitUtility(); // this is for just implementing wait property on the method submitClick()
	public WebDriver driver;
	
	public GroceryLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//div[@class='col-4']/button") WebElement logIn;
    @FindBy(xpath="//b[text()='7rmart supermarket']") WebElement logInScreenText;
	
	public GroceryLoginPage enterUsername(String usernameValue)
	{
		username.sendKeys(usernameValue);
		return this;
	}
	
	public GroceryLoginPage enterPassword(String passwordValue)
	{
		password.sendKeys(passwordValue);
		return this;
	}
	
	public GroceryHomePage submitClick()
	{
		wu.waitUntilElementToBeClickable(driver, logIn);
		logIn.click();
		return new GroceryHomePage(driver);
	}
	
	public String textDisplayed()
	{
		return logInScreenText.getText();
	}

}
