package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By sortingDropdown = By.name("orderby");
	public By priceSliderLeft = By.xpath("//span[@style='left: 0%;']");
	public By priceSliderRight = By.xpath("//span[@style='left: 100%;']");
	
	
	public void selectByValue(String value) {
		WebElement element = driver.findElement(sortingDropdown);
		Select select = new Select(element);
		select.selectByValue(value);	
	}
	
	
	public void selectByIndex(int index) {
		WebElement element = driver.findElement(sortingDropdown);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByVisibleText(String visibleText) {
		WebElement element = driver.findElement(sortingDropdown);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);	
	}
	
	
	
	public String getSelectedOption() {
		WebElement element = driver.findElement(sortingDropdown);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();	
	}
	
	

}