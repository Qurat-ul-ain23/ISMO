package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseclass.BaseTest;
import utilities.ReadxlsData;

public class ForgotPassword extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public ForgotPassword() throws IOException 
	{
		//call base class constructor
		super();
	}
	@BeforeMethod
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
	}
	@Test(dataProviderClass=ReadxlsData.class,dataProvider="forgotPassword")
	public void forgotPassword(String emailAddress) 
	{
		this.ClickonElementsbyXpath("forgot_password_link");
		driver.findElement(By.xpath(loc.getProperty("email_address"))).sendKeys(emailAddress);
		this.ClickonElementsbyXpath("reset_password_button");
	}
	@AfterMethod
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}
	private void ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
	}
}