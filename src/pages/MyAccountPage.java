package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelSheetData;

public class MyAccountPage 
{
	WebDriver driver;
	
	@FindBy (xpath = "//input[@id='customer_firstname']") private WebElement FirstName;
	@FindBy (xpath = "//input[@id='customer_lastname']") private WebElement LastName;
	@FindBy (xpath = "//input[@id='email']") private WebElement Email;
	@FindBy (xpath = "//input[@id='passwd']") private WebElement Password;
	@FindBy (xpath = "//input[@id='firstname']") private WebElement FirstName2;
	@FindBy (xpath = "//input[@id='lastname']") private WebElement LastName2;
	@FindBy (xpath = "//input[@id='address1']") private WebElement Address;
	@FindBy (xpath = "//input[@id='city']") private WebElement City;
	@FindBy (xpath = "//select[@id='id_state']") private WebElement State;
	@FindBy (xpath = "//input[@id='postcode']") private WebElement PostalCode;
	@FindBy (xpath = "//input[@id='phone_mobile']") private WebElement MobilePhone;
	@FindBy (xpath = "//button[@id='submitAccount']") private WebElement RegisterButton;
	
		
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public void EnterAccountInfo() throws Exception, IOException
	{
		String fn = ExcelSheetData.fetchData("Sheet1", 1, 1); 
		FirstName.sendKeys(fn); 
//		Thread.sleep(2000);
		
		String ln = ExcelSheetData.fetchData("Sheet1", 1, 2); 
		LastName.sendKeys(ln); 
//		Thread.sleep(2000);
		
		String psw = ExcelSheetData.fetchData("Sheet1", 1, 3); 
		Password.sendKeys(psw); 
//		Thread.sleep(2000);

		FirstName2.sendKeys(fn);
//		Thread.sleep(2000);
		
		LastName2.sendKeys(ln);
//		Thread.sleep(2000);

		String addr = ExcelSheetData.fetchData("Sheet1", 1, 4); 
		Address.sendKeys(addr);
//		Thread.sleep(2000);

		String c = ExcelSheetData.fetchData("Sheet1", 1, 5); 
		City.sendKeys(c);
//		Thread.sleep(2000);
		
		Select v = new Select(State);
		v.selectByIndex(1);
//		Thread.sleep(2000);

		String pc = ExcelSheetData.fetchData("Sheet1", 1, 6); 
		PostalCode.sendKeys(pc);
//		Thread.sleep(2000);
		
		String m = ExcelSheetData.fetchData("Sheet1", 1, 7); 
		MobilePhone.sendKeys(m);
//		Thread.sleep(2000);

		RegisterButton.click();
//		Thread.sleep(2000);
	}
}

