package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.objects.MenuPage;
import page.objects.TheWickedKingPage;
import selenium.utils.BaseTest;

public class TheWickedKingTest extends BaseTest{
	TheWickedKingPage theWickedKing = new TheWickedKingPage(driver);
	MenuPage menuPage = new MenuPage(driver);
	
	
	@Test(priority=1)
	public void checkTextAndpictures() {
		menuPage.click(menuPage.searchIcon);
		menuPage.sendKeys(menuPage.searchButton, "king");
		menuPage.click(menuPage.theWickedKing);
		assertEquals(theWickedKing.getElementText(theWickedKing.category), 
				"New releases");
		assertEquals(theWickedKing.getElementText(theWickedKing.productId), 
				"1709");
		 for(int i=1; i<=4; i++) {
	            WebElement picture = driver.findElement(By.cssSelector("a[href*='TheWickedKing"+i+".png'][class='inited']"));
	            assertTrue(picture.getAttribute("href").contains("TheWickedKing"+i+".png"));

	        }
	}

}
