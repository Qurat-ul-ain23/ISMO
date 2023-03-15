package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class MediaLibrary extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public MediaLibrary() throws IOException 
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
	public void TS_73mediaLibraryModule()
	{
		this.ClickonElementsbyXpath("medialibrary_module_link");
	}
	@Test(priority=1)
	public void TS_74addmediaLibrary() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_media_library");
		String mediaLibraryname = "Media Library2";
		driver.findElement(By.xpath(loc.getProperty("media_library_name"))).sendKeys(mediaLibraryname);
		//CK Editor
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("media_library_save_button");
	}
	@Test(priority=2)
	public void TS_75editmediaLibrary() 
	{ 
		this.ClickonElementsbyXpath("edit_medialibrary_button");
		this.ClickonElementsbyXpath("update_medialibrary_button");
	}
	@Test(priority=3)
	public void TS_76delmediaLibrary() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_media_library_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_medialibrary_alert");
	}
	@Test(priority=4)
	public void TS_78filtersmediaLibrary() throws InterruptedException
	{
		this.ClickOnFilter("medialibrary_id_filter");
		this.ClickOnFilter("medialibrary_name_filter");
		this.ClickOnFilter("medialibrary_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_79searchmediaLibrary() throws InterruptedException 
	{
		String searchCMSPage = "test";
		this.driver.findElement(By.xpath(loc.getProperty("medialibrary_search"))).sendKeys(searchCMSPage);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("medialibrary_search"))).clear();
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
