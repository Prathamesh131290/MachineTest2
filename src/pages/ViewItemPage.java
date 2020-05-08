package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewItemPage
{
	WebDriver driver;
	
	@FindBy (xpath = "//a[@title='Women']") private WebElement WomenTab;
	@FindBy (xpath = "//a[contains(@title,'tops')]") private WebElement Tops;
	@FindBy (xpath = "(//a[@title='T-shirts'])[3]") private WebElement Tshirts;
	@FindBy (xpath = "//div[@class='product-image-container']") private WebElement QuickView;	
	
	
	public ViewItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public void viewItem() throws InterruptedException
	{
		WomenTab.click();
//		Thread.sleep(2000);
		
		Tops.click();
//		Thread.sleep(2000);
		
		Tshirts.click();
//		Thread.sleep(2000);
		
		QuickView.click();
//		Thread.sleep(2000); 
	}
}

