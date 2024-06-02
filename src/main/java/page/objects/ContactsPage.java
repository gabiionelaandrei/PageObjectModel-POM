package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers {
	
	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori/webelements
	public By nameField = By.cssSelector("input[name='your-name']");
	public By emailField = By.cssSelector("input[name='your-email']");
	public By subjectField = By.cssSelector("input[name='your-s']");
	public By msgField = By.cssSelector("textarea[name='your-message']");
	public By submitBtn = By.cssSelector("input[value='Send Message']");
	public By sentMsg = By.cssSelector("div[class='wpcf7-response-output']");
	
	//metode
	
	public void sendMessage(String name, String email, String subject, String message) {
		
		sendKeys(nameField, name);
		sendKeys(emailField, email);
		sendKeys(subjectField, subject);
		sendKeys(msgField, message);
		click(submitBtn);
		
	}

}