package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import page.objects.EventPage;
import selenium.utils.BaseTest;

public class WindowHandleExample extends BaseTest{

	@Test
	public void windowHandleTest() throws InterruptedException {
		
		driver.get("https://keybooks.ro/event/time-for-books-discussion/");
		
		EventPage event =  new EventPage(driver);
		
		event.scrollVertically(800);
		driver.switchTo().frame(driver.findElement(event.iframe));
		
		System.out.println("Before: " + driver.getWindowHandle());
		
		event.click(event.viewMapBtn);
		
		System.out.println("After: " + driver.getWindowHandle());
		
		System.out.println("All windows: " + driver.getWindowHandles());

		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		
		Thread.sleep(4000);
		
		driver.switchTo().window(browserTabs.get(1));
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		event.click(event.viewMapBtn);

		
	}
	
	
}