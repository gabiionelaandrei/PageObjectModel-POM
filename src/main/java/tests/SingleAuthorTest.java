package tests;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.objects.MenuPage;
import page.objects.SingleAuthorPage;
import selenium.utils.BaseTest;

public class SingleAuthorTest extends BaseTest{
	SingleAuthorPage singleAuthor = new SingleAuthorPage(driver);
	MenuPage menuPage = new MenuPage(driver);
	
	@Test(priority =1)
	public void explicitWait() {
		menuPage.click(menuPage.singleAuthorLink);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(singleAuthor.drama, "95"));
		
		
	}
	@Test(priority=2)
	public void checkText() {
		assertEquals(singleAuthor.getElementText(singleAuthor.drama), 
				"95%");
		assertEquals(singleAuthor.getElementText(singleAuthor.biography), 
				"75%");
		assertEquals(singleAuthor.getElementText(singleAuthor.cookBooks), 
				"82%");
	}
}
