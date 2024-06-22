package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;

import org.testng.annotations.Test;

import page.objects.LoginPage;
import page.objects.MenuPage;
import page.objects.ShippingPage;
import selenium.utils.BaseTest;



public class ShippingPageTest extends BaseTest{

	@Test(priority = 1, groups = "UserManagementFunctionality")
	public void validLoginTest() {
		
		MenuPage menuPage = new MenuPage(driver);		
		//menuPage.navigateTo(menuPage.loginLink);
		menuPage.click(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(USER, PASS);
		
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.successLoginMsg));
		//loginPage.logoutFromApp();
		loginPage.click(loginPage.logoutBtn);
		
	}
	@Test(priority = 2, description = "Add values for the static fields")
	public void shippingAddress() {
		MenuPage shippingAdress =  new MenuPage(driver);
		shippingAdress.navigateTo(shippingAdress.contactDetails);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shippingAdress.navigateTo(shippingAdress.contactSettings);	
		ShippingPage address = new ShippingPage(driver);
		address.addAddress("First","Last","Street1, House6","041907","City Test");
	}
	@Test(priority = 3,  description = "Select Canada value")
	public void selectByIndexTest() {
		ShippingPage shippingCountry = new ShippingPage(driver);
		shippingCountry.filterByIndex(41);
		assertEquals(shippingCountry.getCurrentSelectedOption(), "Canada");
	}	

	@Test(priority=4, description = "Select Newfoundland and Labrador value")
	public void selectByValueTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ShippingPage shippingProvince = new ShippingPage(driver);
		shippingProvince.filterByValue("NL");
		assertEquals(shippingProvince.getCurrentSelectedOption(), "Newfoundland and Labrador");
		ShippingPage saveAdress = new ShippingPage(driver);
		saveAdress.navigateTo(saveAdress.saveShippingAddress);
	}


	}
