package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroceryHomePage {
	
	public WebDriver driver;
	
	public GroceryHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='nav-item dropdown']/a") 
	WebElement profile;
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[2]") 
	WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement moreInfo;
	@FindBy(xpath="//p[text()='Dashboard']") 
	WebElement dashboardTile;
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and text()='More info ']") 
	WebElement manageDeliveryBoyButton;

	public GroceryHomePage adminButtonClick()
	{
		profile.click();
		return this;
	}
	
	public GroceryLoginPage logoutClick()
	{
		logout.click();
		return new GroceryLoginPage(driver);
	}
	
	public GroceryAdminUsersPage adminUsersClick()
	{
		moreInfo.click();
		return new GroceryAdminUsersPage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboardTile.isDisplayed();
	}
	public ManageDeliveryBoyPage clickManageDeliveryBoy()
	{
		manageDeliveryBoyButton.click();
		return new ManageDeliveryBoyPage(driver);
	}
}
