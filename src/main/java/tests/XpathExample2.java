package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class XpathExample2 extends BaseTest {

	
	@Test
	public void xpathExampleTest() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		
		//parent	
		WebElement loginPopUp = driver.findElement
				(By.xpath("//a[@href='#popup_login']/parent::li[@class='menu_user_login']"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid green;')", loginPopUp);
		
		loginPopUp.click();
		
		
		//descendant
		/*
		 * //ul/descendant::input[@id='log']
		 * //ul//input[@id='log']
		 * 
		 */
		WebElement user = driver.findElement(By.xpath("//ul/descendant::input[@id='log']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid green;')", user);
		
		user.sendKeys("TestCeva");
		
		
		//child
		WebElement pass = driver.findElement
				(By.xpath("//ul/descendant::form[@name='login_form']/child::div[contains(@class,'password_field')]/child::input"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid green;')", pass);
		
		pass.sendKeys("Test Ceva");
		
		//following-sibling	
		WebElement rememberMe = driver.findElement
				(By.xpath("//ul//div[contains(@class, 'login_field')]/following-sibling::div[contains(@class, 'remember_field')]/child::input"));
		
	
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid green;')", rememberMe);
		
		rememberMe.click();
		
		Thread.sleep(3000);
		//preceding-sibling
		WebElement user2 = driver.findElement
				(By.xpath("//ul//div[contains(@class, 'submit_field')]/preceding-sibling::div[contains(@class, 'login_field')]/input"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid red;')", user2);
		
		
		//following
		WebElement forgotPass = driver.findElement
				(By.xpath("//a[@href='tel:123-456-7890']/following::a[@class='forgot_password']"));
		
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid red;')", forgotPass);
		
		
		//preceding
		WebElement loginBtn = driver.findElement
				(By.xpath("//div[@class='top_panel_middle']/preceding::input[@class='submit_button']"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:yellow; border:4px solid red;')", loginBtn);
		
		loginBtn.click();
	}
	
	
}