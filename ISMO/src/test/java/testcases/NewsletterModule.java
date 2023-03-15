package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class NewsletterModule extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public NewsletterModule() throws IOException 
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
	public void TS_51newsletterModule()
	{
		this.ClickonElementsbyXpath("newsletter_module_link");
	}
	@Test(priority=1)
	public void TS_52addNewsletter() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_newsletter");
		String newsletterSubject = "Newsletter6";
		driver.findElement(By.xpath(loc.getProperty("newsletter_subject"))).sendKeys(newsletterSubject);
		//CK Editor
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		Thread.sleep(2000);
		//Publish Newsletter
		this.ClickonElementsbyXpath("save_newsletter");
	}
	@Test(priority=2)
	public void TS_53editNewsletter() 
	{ 
		this.ClickonElementsbyXpath("edit_newsletter_button");
		this.ClickonElementsbyXpath("update_newsletter_button");
	}
	@Test(priority=3)
	public void TS_54delNewsletter() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_newsletter_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_newsletter_button");
	}
	@Test(priority=4)
	public void TS_55filtersNewsletter() throws InterruptedException
	{
		this.ClickOnFilter("newsletter_id_filter");
		this.ClickOnFilter("newsletter_subject_filter");
		this.ClickOnFilter("newsletter_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_56searchNewsletter() throws InterruptedException 
	{
		String searchCMSPage = "test";
		this.driver.findElement(By.xpath(loc.getProperty("newsletter_search"))).sendKeys(searchCMSPage);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("newsletter_search"))).clear();
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void TS_57subscribeButton() 
	{
		this.ClickonElementsbyXpath("subscibe_newsletter_button");;
		
	}
	@Test(priority=7)
	public void TS_58unsub() throws InterruptedException 
	{
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("checkbox_check");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("bulk_unsub");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("bulk_unsub_yes");
	}
	@Test(priority=8)
	public void TS_59sub() throws InterruptedException 
	{
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("checkbox_check");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("bulk_sub");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("bulk_sub_yes");
	}
	@Test(priority=9)
	public void TS_60filtersSubscriber() throws InterruptedException
	{
		Thread.sleep(2000);
		this.ClickOnFilter("sub_id_newsletter");
		this.ClickOnFilter("sub_email_newsletter");
		this.ClickOnFilter("sub_status_newsletter");
		this.ClickOnFilter("sub_createdAt_newsletter");
		Thread.sleep(2000);
	}
	@Test(priority=10)
	public void TS_61searchSubscriber() throws InterruptedException 
	{
		String searchSubscriber = "test";
		this.driver.findElement(By.xpath(loc.getProperty("search_subscriber_newsletter"))).sendKeys(searchSubscriber);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("search_subscriber_newsletter"))).clear();
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
