package page.objects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumWrappers;

public class SingleAuthorPage extends SeleniumWrappers{
	public WebDriver driver;
	
	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori
	public By drama = By.cssSelector("div[class='sc_skills_total'][data-stop='95']");
	public By biography = By.cssSelector("div[class='sc_skills_total'][data-stop='75']");
	public By cookBooks = By.cssSelector("div[class='sc_skills_total'][data-stop='82']");
	
	

	
}
