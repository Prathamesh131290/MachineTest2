package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage 
{
	WebDriver driver;
	String cost;
	
	@FindBy (xpath = "//input[@id='quantity_wanted']") private WebElement Qty;
	@FindBy (xpath = "//button[@name='Submit']") private WebElement AddToCartButton;
	@FindBy (xpath = "//span[@class='ajax_block_cart_total']") private WebElement TotalCost1;
	@FindBy (xpath = "//a[@title='Proceed to checkout']") private WebElement CheckoutButton;
	
	
	public FramePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public String handleFrame() throws InterruptedException
	{
		Qty.sendKeys(Keys.BACK_SPACE);
		Qty.sendKeys("2");
		Thread.sleep(2000);
		
		AddToCartButton.click();
		Thread.sleep(2000);
		cost = TotalCost1.getText();
		
		CheckoutButton.click();
		Thread.sleep(2000);
		
		return cost;
	}
}
