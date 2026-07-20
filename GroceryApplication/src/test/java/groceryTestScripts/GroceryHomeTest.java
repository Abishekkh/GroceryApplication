package groceryTestScripts;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import mainProject.GroceryBaseClass;
import pages.GroceryHomePage;
import pages.GroceryLoginPage;
import utility.GroceryUtilitiesExcel;

public class GroceryHomeTest extends GroceryBaseClass{
	GroceryHomePage ghp;
	
	@Test
	public void verify_Whether_User_Is_Able_To_Logout() throws IOException
	{

		String userNameValue = GroceryUtilitiesExcel.getStringData(0, 0, "groceryLoginPage");
		String passwordValue = GroceryUtilitiesExcel.getStringData(0, 1, "groceryLoginPage");
		GroceryLoginPage glp = new GroceryLoginPage(driver);
		glp.enterUsername(userNameValue).enterPassword(passwordValue);
		ghp = glp.submitClick();
		ghp.adminButtonClick();
		glp = ghp.logoutClick();
	}

}
