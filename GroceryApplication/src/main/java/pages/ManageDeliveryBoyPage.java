package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GroceryUtilitiesExcel;
import utility.PageUtility;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	PageUtility pgu = new PageUtility();
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") 
	WebElement addNewDeliveryBoyButton;
	@FindBy(xpath="//input[@name='name']") WebElement name;
	@FindBy(id="email") WebElement email;
	@FindBy(id="phone") WebElement phoneNumber;
	@FindBy(id="address") WebElement address;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement dpassword;
	@FindBy(name="create") WebElement submit;
	
	
	public void click_add_New_Delivery_Boy_Button()
	{
		addNewDeliveryBoyButton.click();
	}
		
	public void enter_Delivery_Boy_Name(String deliveryBoyName)
	{
		name.sendKeys(deliveryBoyName);
	}
	
	public void enter_Delivery_Boy_Email(String deliveryBoyEmail)
	{
		email.sendKeys(deliveryBoyEmail);
	}
	
	public void enter_Delivery_Boy_PhoneNumber(String deliveryBoyPhoneNumber)
	{
		phoneNumber.sendKeys(deliveryBoyPhoneNumber);
	}
	
	public void enter_Delivery_Boy_Address(String deliveryBoyAddress)
	{
		address.sendKeys(deliveryBoyAddress);
	}
	
	public void enter_Delivery_Boy_Username(String deliveryBoyUsername)
	{
		username.sendKeys(deliveryBoyUsername);
	}
	
	public void enter_Delivery_Boy_Password(String password)
	{
		dpassword.sendKeys(password);
	}
	
	public void clickSaveDeliveryBoy()
	{
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", submit);
//		js.executeScript("window.scrollBy(0,2000)", ""); // x and y axis
//		submit.click();
		
		pgu.scrollUsingJavascript(driver);
		pgu.clickUsingJavascript(driver, submit);
	}
	

}
