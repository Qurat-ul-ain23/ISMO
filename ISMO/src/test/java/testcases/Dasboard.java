package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class Dasboard extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public Dasboard() throws IOException 
	{
		//call base class constructor
		super();
	}
	@BeforeClass
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
		this.driver = login(this.driver,prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=0)
	public void TS_11dasboardModule() 
	{
		this.ClickonElementsbyXpath("dashboard");
	}
	@Test(priority=1)
	public void TS_12dashboardWindowTitle() throws InterruptedException 
	{
		String expectedtitle = "Dashboard - MO";
		String actualtitle = this.driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		Thread.sleep(2000);
	}
	@AfterClass
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}
	private void ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
	}

}
