package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage 
{
	WebDriver driver; 
	
	@FindBy (xpath = "//span[@id='total_price']") private WebElement TotalCost2;
	@FindBy (xpath = "(//a[@title='Proceed to checkout'])[2]") private WebElement CheckoutButton2;
	@FindBy (xpath = "//button[@name='processAddress']") private WebElement CheckoutButton3;
	@FindBy (xpath = "//input[@id='cgv']") private WebElement AgreeCheckbox;
	@FindBy (xpath = "//button[@name='processCarrier']") private WebElement CheckoutButton4;
	@FindBy (xpath = "//span[@id='total_price']") private WebElement TotalCost3;
	@FindBy (xpath = "//a[@title='Pay by bank wire']") private WebElement PayByBankWire;
	@FindBy (xpath = "//span[@id='amount']") private WebElement TotalCost4;
	@FindBy (xpath = "(//button[@type='submit'])[2]") private WebElement ConfirmOrderButton;
	@FindBy (xpath = "//a[@title='Back to orders']") private WebElement BackToOrderButton;
	@FindBy (xpath = "//span[@class='price']") private WebElement TotalCost5;
	@FindBy (xpath = "//table/tbody/tr[1]/td[3]/span") private WebElement OrderAmount;

	

	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public void ConfirmOrder() throws InterruptedException
	{
		String cost = TotalCost2.getText();
		System.out.println("Total Cost of products with Tax: "+TotalCost2.getText());

		CheckoutButton2.click();
		Thread.sleep(2000);	
		
		CheckoutButton3.click();
		Thread.sleep(2000);
		
		AgreeCheckbox.click();
		Thread.sleep(2000);
		
		CheckoutButton4.click();
		Thread.sleep(2000);
		System.out.println("Total Cost of products with Tax: "+TotalCost3.getText()); 
		
		Assert.assertEquals(cost, TotalCost3.getText());
		
		PayByBankWire.click();
		Thread.sleep(2000);
		System.out.println("Total Cost of products with Tax: "+TotalCost4.getText()); 
		
		Assert.assertEquals(cost, TotalCost4.getText());

		ConfirmOrderButton.click();
		Thread.sleep(2000);
		
		BackToOrderButton.click();
		Thread.sleep(2000);	
		System.out.println("Total cost of products with Tax: "+TotalCost5.getText()); 
		
		Assert.assertEquals(cost, TotalCost5.getText());
		
		System.out.println("Order Amount: "+OrderAmount.getText());
		Assert.assertEquals(cost, OrderAmount.getText());
		
	}
}

