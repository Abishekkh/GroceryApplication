package mainProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utility.ScreenshotUtility;

public class GroceryBaseClass {
	
	Properties prop;          // this is for config file 
	FileInputStream file;    //  this is form config file
	
public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true) // alwaysRun=true used because of parameterization won't support 'Run' 'RunAll' in test class
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{
		prop = new Properties();
		file = new FileInputStream(Constant.CONFIGFILE);
		prop.load(file);
		if(browsers.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult itestresult) throws IOException{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}

}
