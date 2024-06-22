package selenium.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends BaseTest{
	/*
	 * 
	 * 
	 */
	
	
	//WebElement element  =  driver.findElement(locator)
	//element.click();
	
	/**
	 * Wrapper method over selenium default click() enhanced with:
	 * 1.waitForElementToBeVisible
	 * 2.retry mechanism for NoSuchElement 
	 * @param locator
	 */
	public void click(By locator) {
	
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element  =  driver.findElement(locator);
			element.click();	
			
		}catch(NoSuchElementException e) {
			
		}	
	}
	
	
	public void sendKeys(By locator, String text) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element  =  driver.findElement(locator);
			element.clear();
			element.sendKeys(text);	
			
		}catch(NoSuchElementException e) {
			
		}	
		
	}
	
	public String getElementText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
		return driver.findElement(locator).getText();
		
	}
	
	public void hoverElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	
	public void dragAndDrop(By locator, int x, int y) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action
			.moveToElement(element)
			.clickAndHold(element)
			.moveByOffset(x, y)
			.release()
			.perform();
	}
	
	
	public void scrollVertically(int y) {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, y).perform();
		
	}
	
	public void scrollHorizontally(int x) {
		Actions action = new Actions(driver);
		action.scrollByAmount(x, 0).perform();
	}
	
	
	public WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void navigateTo( By locator) {
		driver.findElement(locator).click();
	}
	
	public void loginMsgIsDisplayed( By locator) {
		driver.findElement(locator).isDisplayed();
	}
}