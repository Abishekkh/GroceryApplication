package groceryTestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mainProject.GroceryBaseClass;
import pages.GroceryAdminUsersPage;
import pages.GroceryHomePage;
import pages.GroceryLoginPage;
import utility.GroceryUtilitiesExcel;
import utility.RandomDataUtility;

public class GroceryAdminUsersTest extends GroceryBaseClass{
	
	GroceryHomePage ghp;
	GroceryAdminUsersPage adu;


	@Test
	public void verify_Whether_User_Is_Able_To_Add_New_Admin_User() throws IOException
	{
		String userNameValue = GroceryUtilitiesExcel.getStringData(0, 0, "groceryLoginPage");
		String passwordValue = GroceryUtilitiesExcel.getStringData(0, 1, "groceryLoginPage");
		
		GroceryLoginPage glp = new GroceryLoginPage(driver);
		glp.enterUsername(userNameValue).enterPassword(passwordValue);
		ghp = glp.submitClick();
		adu = ghp.adminUsersClick();
		
//		String userNameInput = GroceryUtilitiesExcel.getStringData(0, 0, "groceryAdminUsersPage");
//		String passwordInput = GroceryUtilitiesExcel.getStringData(0, 1, "groceryAdminUsersPage");

		RandomDataUtility rd = new RandomDataUtility();
		String userNameInput = rd.randomUsername();
		String passwordInput = rd.randomPassword();
				
		adu.clickingNewButton().enterUsernameInput(userNameInput).enterPasswordInput(passwordInput)
		.clickingUserType().selectingUserTypeValues().clickSave();
	}
	
	@Test
	public void verify_Whether_User_Is_Able_To_Search_Newly_Added_User() throws IOException
	{
		String SearchUserNameInput = GroceryUtilitiesExcel.getStringData(0, 0, "groceryAdminUsersPage");

		String userNameValue = GroceryUtilitiesExcel.getStringData(0, 0, "groceryLoginPage");
		String passwordValue = GroceryUtilitiesExcel.getStringData(0, 1, "groceryLoginPage");
		
		GroceryLoginPage glp = new GroceryLoginPage(driver);
		glp.enterUsername(userNameValue).enterPassword(passwordValue);
		ghp = glp.submitClick();
		adu = ghp.adminUsersClick();
		
		adu.clickSearch().searchUsername(SearchUserNameInput).searchUserTypeClick().selectUserType().submitSearch();
		

	}


}
