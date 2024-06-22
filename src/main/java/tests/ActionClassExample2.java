package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import page.objects.ContactsPage;
import page.objects.MenuPage;
import selenium.utils.BaseTest;

public class ActionClassExample2 extends BaseTest{

	
	//@Test
	public void sendKeysExample() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.contactsLink);
		
		ContactsPage contactPage =  new ContactsPage(driver);
		WebElement nameFiled = driver.findElement(contactPage.nameField);
		
		Actions action  =  new Actions(driver);
		
		action
			.moveToElement(nameFiled)
			.click()
			.keyDown(Keys.SHIFT)
			.sendKeys(nameFiled, "test")
			.keyUp(Keys.SHIFT)
			.sendKeys(Keys.TAB, "email@email.com")
			.sendKeys(Keys.TAB, "Subject")
			.sendKeys(Keys.TAB, "Message")
			.sendKeys(Keys.TAB, Keys.ENTER)
			.perform();
		
		
	}
	
	@Test
	public void sendKeysExample2() throws InterruptedException {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.contactsLink);
		
		ContactsPage contactPage =  new ContactsPage(driver);
		WebElement nameFiled = driver.findElement(contactPage.nameField);
		
		Actions action  =  new Actions(driver);
		
		action
			.moveToElement(nameFiled)
			.sendKeys(nameFiled, "ABRACADABRA")
			.keyDown(Keys.SHIFT)
			.sendKeys(Keys.ARROW_LEFT)
			.sendKeys(Keys.ARROW_UP)
			.keyUp(Keys.SHIFT)
				.keyDown(Keys.COMMAND)
				.sendKeys("c")
				.keyUp(Keys.COMMAND)			
			.sendKeys(Keys.TAB)
				.keyDown(Keys.COMMAND)
				.sendKeys("v")
				.keyUp(Keys.COMMAND)	
			.perform();
		
		Thread.sleep(4000);
		
	}
	
	
	
}