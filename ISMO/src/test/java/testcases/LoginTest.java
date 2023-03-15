package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseclass.BaseTest;
import utilities.ReadxlsData;

public class LoginTest extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public LoginTest() throws IOException 
	{
		//call base class constructor
		super();
	}
	@BeforeMethod
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
	}
	@Test(dataProviderClass=ReadxlsData.class,dataProvider="bvtdata")
	public void login(String email, String password) 
	{
		this.driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(email);
		this.driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		this.ClickonElementsbyXpath("login_button");
	}
	@Test
	public void loginTitleTestTS_07() throws InterruptedException 
	{
		String expectedtitle = "Login - MO";
		String actualtitle = this.driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		Thread.sleep(2000);
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
