package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDropdownWithVisibleText(WebElement element, String text)
	{
		Select object1 = new Select(element);
		object1.selectByVisibleText(text);
	}
	
	public void selectDropdownWithIndex(WebElement element, String index)
	{
		Select object2 = new Select(element);
		object2.selectByVisibleText(index);
	}
	
	public void clickUsingJavascript(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);

	}

	public void scrollUsingJavascript(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

	}
}
