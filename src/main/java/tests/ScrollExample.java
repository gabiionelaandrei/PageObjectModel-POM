package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	
	//@Test
	public void scrollByAmount() throws InterruptedException {	
		//Js Executor Scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 2500)");
		
		Thread.sleep(4000);

		// Action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1500).perform();
		Thread.sleep(4000);
		action.scrollByAmount(0, -1500).perform();
		
	}
	
	//@Test
	public void scrollToElement() {
		
		WebElement text = driver.findElement
				(By.xpath("//h4//em[text()='Picked']"));
		//js executor scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", text);
		
		
		//action class scroll
		Actions action = new Actions(driver);
		//action.scrollToElement(text).perform();
		//action.moveToElement(text).perform();
	}
	@Test
	public void scrollDownAndTop() throws InterruptedException {
		//js executor scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(4000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		Thread.sleep(4000);

		//action class scroll
		Actions action = new Actions(driver);
		action.sendKeys(Keys.END).perform();
		Thread.sleep(4000);
		action.sendKeys(Keys.HOME).perform();

	}
	

}