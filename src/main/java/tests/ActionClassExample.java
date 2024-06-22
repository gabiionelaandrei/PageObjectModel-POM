package tests;

import org.testng.annotations.Test;

import page.objects.MenuPage;
import page.objects.ShopPage;
import selenium.utils.BaseTest;

public class ActionClassExample extends BaseTest {

	@Test(priority=1)
	public void hoverExample() throws InterruptedException {
		
		MenuPage menuPage =  new MenuPage(driver);
		
		menuPage.hoverElement(menuPage.blogLink);
		Thread.sleep(3000);
		menuPage.hoverElement(menuPage.aboutLink);
	}
	
	@Test(priority=2)
	public void dragAndDropExample() {
		
		MenuPage menuPage =  new MenuPage(driver);
		menuPage.click(menuPage.shopLink);
		
		ShopPage shopPage = new ShopPage(driver);
		shopPage.dragAndDrop(shopPage.priceSliderLeft, 100, 0);
		shopPage.dragAndDrop(shopPage.priceSliderRight, -100, 0);

		
	}
	
	
	
}