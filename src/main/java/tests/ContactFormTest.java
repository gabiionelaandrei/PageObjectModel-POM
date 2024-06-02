package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import page.objects.ContactsPage;
import page.objects.LoginPage;
import page.objects.MenuPage;
import selenium.utils.BaseTest;

public class ContactFormTest extends BaseTest {
	
	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");

	
	@Test
	public void sendMessageTest() {
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(USER, PASS);
		
		menuPage.click(menuPage.contactsLink);
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.sendMessage
				("Harry potter", 
				"harry.potter@howgharts.com", 
				"Addmison", 
				"Can I join?");
		
		assertEquals(contactPage.getElementText(contactPage.sentMsg), 
				"Thank you for your message. It has been sent.");
	}
	

}