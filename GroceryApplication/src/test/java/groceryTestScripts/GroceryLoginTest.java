package groceryTestScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mainProject.GroceryBaseClass;
import pages.GroceryHomePage;
import pages.GroceryLoginPage;
import utility.GroceryUtilitiesExcel;

public class GroceryLoginTest extends GroceryBaseClass{
	
	GroceryHomePage ghp;
	
@Test(priority = 1, description = "User logging in with valid username and password", groups = {"smoke"}, retryAnalyzer = retry.Retry.class)
	public void loginWithValidCredentials() throws IOException
	{
	String userNameValue = GroceryUtilitiesExcel.getStringData(8, 0, "groceryLoginPage");
	String passwordValue = GroceryUtilitiesExcel.getStringData(0, 1, "groceryLoginPage");
	GroceryLoginPage glp = new GroceryLoginPage(driver);
	glp.enterUsername(userNameValue).enterPassword(passwordValue);
	ghp = glp.submitClick();
	boolean loginSuccess = ghp.isDashboardDisplayed();
	Assert.assertTrue(loginSuccess, "User is Unable to login with Valid Credentials");

	}
	
@Test(priority = 3, description = "User logging in with valid username and invalid password")
	public void loginWithValidUsernameInvalidPassword() throws IOException
	{
		String userNameValue = GroceryUtilitiesExcel.getStringData(1, 0, "groceryLoginPage");
		String password = GroceryUtilitiesExcel.getStringData(1, 1, "groceryLoginPage");
		GroceryLoginPage glp = new GroceryLoginPage(driver);
		glp.enterUsername(userNameValue).enterPassword(password).submitClick();
		String expected = "7rmart supermarket";
		String actual = glp.textDisplayed();
		Assert.assertEquals(actual, expected, "Able to log in with invalid password");
	}
	
@Test(priority = 4, description = "User logging in with invalid username and valid password")
	public void loginWithInvalidUsernameValidPassword() throws IOException
	{
	String userNameValue = GroceryUtilitiesExcel.getStringData(2, 0, "groceryLoginPage");
	String password = GroceryUtilitiesExcel.getStringData(2, 1, "groceryLoginPage");
	GroceryLoginPage glp = new GroceryLoginPage(driver);
	glp.enterUsername(userNameValue).enterPassword(password).submitClick();
	}
	
@Test(priority = 2, description = "User logging in with invalid  username and invalid password", groups = {"smoke"}, dataProvider = "loginProvider")
	public void loginWithInvalidUsernameInvalidPassword(String userNameValue, String password) throws IOException 
	{
//	String userNameValue = GroceryUtilitiesExcel.getStringData(3, 0, "groceryLoginPage");
//	String password = GroceryUtilitiesExcel.getStringData(3, 1, "groceryLoginPage");
	GroceryLoginPage glp = new GroceryLoginPage(driver);
	glp.enterUsername(userNameValue).enterPassword(password).submitClick();
	}

@DataProvider(name = "loginProvider")
public Object[][] getDataFromDataProvider() throws IOException {

return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
// new Object[] {ExcelUtility.getStringData(3,
// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
};
}

}
