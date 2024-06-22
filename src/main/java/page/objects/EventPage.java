package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumWrappers;

public class EventPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public EventPage(WebDriver driver) {
		this.driver = driver;
	}


	public By iframe = By.tagName("iframe");
	public By viewMapBtn = By.linkText("View larger map");
	
}