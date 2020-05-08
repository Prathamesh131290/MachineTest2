package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy (xpath = "//a[@class='login']") private WebElement SignInButton;
	@FindBy (xpath = "//a[@title='Log me out']") private WebElement SignOutButton; 

	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	
	public void SignIn()
	{
		if(SignInButton.isEnabled())
		{
			SignInButton.click();
		}
	}
	
	public void SignOut()
	{
		SignOutButton.click();
	}
}
