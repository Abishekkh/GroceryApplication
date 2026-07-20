package groceryTestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;

import mainProject.GroceryBaseClass;
import pages.GroceryHomePage;
import pages.GroceryLoginPage;
import pages.ManageDeliveryBoyPage;
import utility.GroceryUtilitiesExcel;
import utility.RandomDataUtility;

public class ManageDeliveryBoyTest extends GroceryBaseClass
{
	@Test
	public void verify_Whether_User_Is_Able_To_Add_New_Delivery_Boy() throws IOException
	{
		String userNameValue = GroceryUtilitiesExcel.getStringData(0, 0, "groceryLoginPage");
		String passwordValue = GroceryUtilitiesExcel.getStringData(0, 1, "groceryLoginPage");
		GroceryLoginPage obj = new GroceryLoginPage(driver);
		obj.enterUsername(userNameValue);
		obj.enterPassword(passwordValue);
		obj.submitClick();
		
		GroceryHomePage ghp = new GroceryHomePage(driver);
		ghp.clickManageDeliveryBoy();
		
//		String deliveryBoyName = GroceryUtilitiesExcel.getStringData(0, 0, "addDeliveryBoyPage");
//		String deliveryBoyEmail = GroceryUtilitiesExcel.getStringData(0, 1, "addDeliveryBoyPage");
//				
//		String deliveryBoyPhoneNumber = GroceryUtilitiesExcel.getStringData(0, 2, "addDeliveryBoyPage");
//		String deliveryBoyAddress = GroceryUtilitiesExcel.getStringData(0, 3, "addDeliveryBoyPage");
//		String deliveryBoyUsername = GroceryUtilitiesExcel.getStringData(0, 4, "addDeliveryBoyPage");
//		String deliveryBoyPassword = GroceryUtilitiesExcel.getStringData(0, 5, "addDeliveryBoyPage");
		
		RandomDataUtility rdu = new RandomDataUtility();
		
		String deliveryBoyName = rdu.fullname();
		String deliveryBoyEmail = rdu.email();
		String deliveryBoyPhoneNumber = rdu.phoneNumber();
		String deliveryBoyAddress = rdu.address();
		String deliveryBoyUsername = rdu.randomUsername();
		String deliveryBoyPassword = rdu.randomPassword();
		
		ManageDeliveryBoyPage mdp = new ManageDeliveryBoyPage(driver);
		
		mdp.click_add_New_Delivery_Boy_Button();
		
		mdp.enter_Delivery_Boy_Name(deliveryBoyName);
		mdp.enter_Delivery_Boy_Email(deliveryBoyEmail);
		mdp.enter_Delivery_Boy_PhoneNumber(deliveryBoyPhoneNumber);
		mdp.enter_Delivery_Boy_Address(deliveryBoyAddress);
		mdp.enter_Delivery_Boy_Username(deliveryBoyUsername);
		mdp.enter_Delivery_Boy_Password(deliveryBoyPassword);
		
		mdp.clickSaveDeliveryBoy();
	}

}
