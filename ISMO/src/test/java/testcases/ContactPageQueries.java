package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class ContactPageQueries extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public ContactPageQueries() throws IOException 
	{
		//Call base class constructor
		super();
	}
	@BeforeClass
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
		this.driver = login(this.driver,prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=0)
	public void TS_105contactPageQueriesModule()
	{
		this.ClickonElementsbyXpath("contact_page_query_link");
	}
	@Test(priority=1)
	public void TS_106viewQuery() throws InterruptedException 
	{ 
		this.ClickonElementsbyXpath("view_query");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void TS_107replyQuery() 
	{
		this.driver.findElement(By.xpath(loc.getProperty("reply_contact_page_query"))).clear();
		String queryReply = "Test Query Reply";
		driver.findElement(By.xpath(loc.getProperty("reply_contact_page_query"))).sendKeys(queryReply);
		this.ClickonElementsbyXpath("submit_query_button");
	}
	@Test(priority=3)
	public void TS_108delQuery() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_query_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_query_btn_alert");
	}
	@Test(priority=4)
	public void TS_109filterspageQuery() throws InterruptedException
	{
		this.ClickOnFilter("query_id_filter");
		this.ClickOnFilter("query_name_filter");
		this.ClickOnFilter("query_email_filter");
		this.ClickOnFilter("query_subject_filter");
		this.ClickOnFilter("query_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_110searchpageQuery() throws InterruptedException 
	{
		String searchQuery = "test";
		this.driver.findElement(By.xpath(loc.getProperty("query_search_box"))).sendKeys(searchQuery);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("query_search_box"))).clear();
		Thread.sleep(2000);
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
