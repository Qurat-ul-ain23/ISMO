package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class CMSPagesModule extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public CMSPagesModule() throws IOException 
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
	public void TS_44CMSPagesModule() 
	{
		this.ClickonElementsbyXpath("cms_pages_module_link");
	}
	@Test(priority=1)
	public void TS_45addNewPage() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_new_page");
		String pageTitle = "CMSPage7";
		driver.findElement(By.xpath(loc.getProperty("page_title"))).sendKeys(pageTitle);
		//CK Editor
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		Thread.sleep(2000);
		scrollDown(this.driver);
		//Image Upload
		driver.findElement(By.id(loc.getProperty("page_choose_image"))).sendKeys("C:\\Users\\quratulain\\Downloads\\page.jpg");
		//Publish Page
		this.ClickonElementsbyXpath("publish_page_button");
	}
	@Test(priority=2)
	public void TS_46editPage() 
	{ 
		this.ClickonElementsbyXpath("edit_page_button");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("update_page_button");
	}
	@Test(priority=3)
	public void TS_47delPage() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_page_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_page_alert");
	}
	@Test(priority=4)
	public void TS_48filtersCMSPage() throws InterruptedException
	{
		this.ClickOnFilter("cms_id_filter");
		this.ClickOnFilter("cms_title_filter");
		this.ClickOnFilter("cms_keyword_filter");
		this.ClickOnFilter("cms_status_filter");
		this.ClickOnFilter("cms_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_49searchCMSPage() throws InterruptedException 
	{
		String searchCMSPage = "test";
		this.driver.findElement(By.xpath(loc.getProperty("cms_search"))).sendKeys(searchCMSPage);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("cms_search"))).clear();
		Thread.sleep(2000);
	}	
	@Test(priority=6)
	public void TS_50viewPage() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("view_page_button");
		scrollDown(this.driver);
		Thread.sleep(3000);
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
