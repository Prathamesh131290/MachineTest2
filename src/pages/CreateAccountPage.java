package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelSheetData;

public class CreateAccountPage 
{
	WebDriver driver;
	
	@FindBy (xpath = "//input[@id='email_create']") private WebElement EmailAddressTextbox;
	@FindBy (xpath = "//button[@id='SubmitCreate']") private WebElement CreateAccountButton;

	
	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public void CreateNewAccount() throws EncryptedDocumentException, IOException 
	{
		// Note: Every time we run the test case, we have to specify new mail ID.
		
		String value = ExcelSheetData.fetchData("Sheet1", 1, 0); 
		if(EmailAddressTextbox.isDisplayed())
		{
			EmailAddressTextbox.sendKeys(value); 

		}
		
		if(CreateAccountButton.isEnabled())
		{
			CreateAccountButton.click(); 
		}
	}
}

