package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumWrappers;

public class ShippingPage extends SeleniumWrappers{
	public WebDriver driver;
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		}
	//locatori
	public By addressesMenu = By.xpath("//a[contains(text(), 'Addresses')]");
	public By addButton = By.xpath("//h3[contains(text(), 'Shipping address')]/following-sibling::a[contains(@class, 'edit')] ");	
	public By firstName = By.xpath("//input[contains(@id, 'shipping_first_name')]");
	public By lastName = By.xpath("//input[contains(@id, 'last_name')]");
	public By houseStreetNr = By.xpath("//input[contains(@placeholder, 'House number and street name')]");
	public By city = By.xpath("//input[contains(@id, 'shipping_city')]");
	public By postalCode = By.xpath("//input[contains(@id, 'shipping_postcode')]");	
	public By drpCountry = By.xpath("//select[contains(@name, 'shipping_country')]");
	public By drpProvince = By.xpath("//select[contains(@name, 'shipping_state')]");	
	public By saveShippingAddress = By.xpath("//button[contains(@type, 'submit')]");
	
	public void addAddress(String first, String last, String house, String postal, String town) {
		driver.findElement(addressesMenu).click();
		driver.findElement(addButton).click();
		driver.findElement(firstName).sendKeys(first);
		driver.findElement(lastName).sendKeys(last);
		driver.findElement(houseStreetNr).sendKeys(house);
		driver.findElement(postalCode).sendKeys(postal);
		driver.findElement(city).sendKeys(town);

	}
	public void filterByIndex(int index) {

		WebElement element =  driver.findElement(drpCountry);
		Select dropdown =  new Select(element);
		dropdown.selectByIndex(index);
	}
	public void filterByValue(String value) {
		WebElement element =  driver.findElement(drpProvince);
		Select dropdown =  new Select(element);
		dropdown.selectByValue(value);
	}
	public String getCurrentSelectedOption() {
		WebElement element =  driver.findElement(drpProvince);
		Select dropdown =  new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}

}
