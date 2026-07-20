package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class GroceryAdminUsersPage {
	
	public WebDriver driver;
	PageUtility pgu = new PageUtility();                //creating object for page utility class for using methods inside page utility class
	
	public GroceryAdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(id="user_type") WebElement userTypeDropdown;
	@FindBy(name="Create") WebElement saveButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
	@FindBy(id="un") WebElement searchUserName;
	@FindBy(id="ut") WebElement searchUserType;
	@FindBy(name="Search") WebElement searchSubmitButton;

	
	public GroceryAdminUsersPage clickingNewButton()
	{
		newButton.click();
		return this;
	}
	
	public GroceryAdminUsersPage enterUsernameInput(String userNameInput)
	{
		userName.sendKeys(userNameInput);
		return this;
	}
	
	public GroceryAdminUsersPage enterPasswordInput(String passwordInput)
	{
		password.sendKeys(passwordInput);
		return this;
	}
	
	public GroceryAdminUsersPage clickingUserType()
	{
		userTypeDropdown.click();
        return this;
	}
	
	public GroceryAdminUsersPage selectingUserTypeValues()
	{
//		Select obj = new Select(userTypeDropdown);
//		obj.selectByVisibleText("Admin");
		pgu.selectDropdownWithVisibleText(userTypeDropdown, "Admin");
		return this;
	}
	
	public GroceryAdminUsersPage clickSave()
	{
		saveButton.click();
		return this;
	}
	
	public GroceryAdminUsersPage clickSearch()
    {
		searchButton.click();
		return this;
    }

	public GroceryAdminUsersPage searchUsername(String SearchUserInput)
    {
		searchUserName.sendKeys(SearchUserInput);  
		return this;
	}
	
	public GroceryAdminUsersPage searchUserTypeClick()
    {
		searchUserType.click();    
		return this;
	}
	
	public GroceryAdminUsersPage selectUserType()
    {
//		Select obj = new Select(searchUserType);
//		obj.selectByValue("admin"); 
		pgu.selectDropdownWithValue(searchUserType, "admin");
		return this;
	}
	
	public GroceryAdminUsersPage submitSearch()
	{
		searchSubmitButton.click();
		return this;
	}

}
