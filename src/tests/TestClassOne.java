package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.CreateAccountPage;
import pages.FramePage;
import pages.MyAccountPage;
import pages.ViewItemPage;
import utilities.Snapshot;
import pages.OrderPage;

public class TestClassOne extends BaseClass
{
	WebDriver driver;
	HomePage home;
	CreateAccountPage create;
	MyAccountPage myacc;
	ViewItemPage view;
	FramePage fp;
	OrderPage ord;
	
	@BeforeClass
	public void configure() 
	{
		driver = BaseClass.initChromeBrowser(); 
	}
	
	@Test(priority=1)
	public void TestStepOne() throws IOException, Exception
	{
		home = new HomePage(driver);
		home.SignIn();
		create = new CreateAccountPage(driver);
		create.CreateNewAccount();
		System.out.println("New account created.");
	}
	
	@Test(priority=2)
	public void TestStepTwo() throws IOException, Exception
	{
		myacc = new MyAccountPage(driver);
		myacc.EnterAccountInfo();
		System.out.println("Account information added.");
	}
	
	@Test(priority=3)
	public void TestStepThree() throws InterruptedException
	{
		view = new ViewItemPage(driver);
		view.viewItem();
		System.out.println("Item viewed.");
		driver.switchTo().frame(0);
	}
	
	@Test(priority=4)
	public void TestStepFour() throws InterruptedException 
	{
		fp = new FramePage(driver);
		String cost = fp.handleFrame();
		System.out.println("Product Quantity updated.");
		System.out.println("Cost of products with shipping: "+cost); // $35.02
	}
	
	@Test(priority=5)
	public void TestStepFive() throws InterruptedException
	{
		ord = new OrderPage(driver);
		ord.ConfirmOrder();
		System.out.println("Order placed successfully.");
	}
	
	@AfterClass
	public void closure() throws IOException, InterruptedException
	{
		try 
		{
			Snapshot.captureScreenshot(driver, "TestCaseOne");
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		home.SignOut();
		Thread.sleep(2000);
		driver.	close();
	}
}
