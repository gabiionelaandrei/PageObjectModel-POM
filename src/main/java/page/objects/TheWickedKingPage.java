package page.objects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.utils.SeleniumWrappers;

public class TheWickedKingPage extends SeleniumWrappers {
	public WebDriver driver;
	
	public TheWickedKingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori 
	public By category = By.cssSelector("a[href='https://keybooks.ro/product-category/new-releases/'][rel='tag']");
	public By productId = By.cssSelector("span[class='product_id']>span");
	
	
}
