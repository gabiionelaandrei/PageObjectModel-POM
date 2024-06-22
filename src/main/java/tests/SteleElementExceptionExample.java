package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import page.objects.MenuPage;
import selenium.utils.BaseTest;

public class SteleElementExceptionExample extends BaseTest{
	
	
	@Test
	public void staleExample() throws InterruptedException {
		
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.shopLink);

		//incarca in memorie un webelement (care este asociat cu un id de sesiune)
		WebElement element = driver.findElement(By.name("orderby"));
		Select select =  new Select(element);
		//se foloseste de element si selecteaza optiunea de la index 2
		select.selectByIndex(2);
		//ca urmare a selectiei se face refresh la pagina
		//ca urmare a refreshului se genereaza un nou id de sesiune
		Thread.sleep(5000);
		//FIX pentru StaleElement este reindentificarea elementului care a 
		//ramas asociat cu vechea sesiune de browser
		element = driver.findElement(By.name("orderby"));
		select =  new Select(element);
		select.selectByValue("date");
		
		
	}
	

}