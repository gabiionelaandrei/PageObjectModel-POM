package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.objects.MenuPage;
import selenium.utils.BaseTest;
import testdata.DataProviderClass;

public class DataProviderExample2 extends BaseTest {

	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "booksDataProvider")
	public void searchAndAssertBookPicture(String bookName, String bookPicture) throws InterruptedException {
		
		MenuPage menu =  new MenuPage(driver);
		menu.search(bookName);
		
		Thread.sleep(3000);
		
		//div[data-image*='book2.jpg']
		
		WebElement bookPic = driver.findElement
				(By.cssSelector("div[data-image*='"+bookPicture+"']"));
		
		assertTrue(bookPic.isDisplayed());
		
	
	}	
}