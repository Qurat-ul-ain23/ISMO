package testcases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseclass.BaseTest;

public class ClientsModule extends BaseTest
{	
	public WebDriver driver;
	//Class Constructor
	public ClientsModule() throws IOException 
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
	public void TS_13clientsModule()
	{
		this.ClickonElementsbyXpath("client_module_link");
	}
	@Test(priority=1)
	public void TS_14viewClient() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("view_client_button");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("download_general_attachement");
		Thread.sleep(3000);
		scrollUp(this.driver);
		this.ClickonElementsbyXpath("client_breadcrumbs");
	}
	@Test(priority=2)
	public void TS_15delClient() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_client_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_button");
	}
	@Test(priority=3)
	public void TS_16filtersClient() throws InterruptedException 
	{
		this.ClickOnFilter("client_id_filter");
		this.ClickOnFilter("client_name_filter");
		this.ClickOnFilter("client_email_filter");
		this.ClickOnFilter("client_type_filter");
		this.ClickOnFilter("client_status_filter");
		this.ClickOnFilter("client_createdAt_filter");
	}
	@Test(priority=4)
	public void TS_17searchClient() throws InterruptedException 
	{
		String searchClient = "test";
		this.driver.findElement(By.xpath(loc.getProperty("client_search"))).sendKeys(searchClient);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("client_search"))).clear();
	}
	@AfterClass
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}
	private void ClickOnFilter(String xpath) throws InterruptedException  
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
	}
	private void ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
	}
}