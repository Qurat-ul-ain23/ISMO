package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class StaticBlock extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public StaticBlock() throws IOException 
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
	public void TS_128staticBlockModule() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("static_block_module_link");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void TS_129editstaticBlock() 
	{ 
		this.ClickonElementsbyXpath("edit_static_block");
		this.ClickonElementsbyXpath("update_static_block_button");
	}
	@Test(priority=2)
	public void TS_130filterstaticBlock() throws InterruptedException
	{
		this.ClickOnFilter("static_block_id_filter");
		this.ClickOnFilter("static_block_name_filter");
		this.ClickOnFilter("static_block_createdAt_filter");
	}
	@Test(priority=3)
	public void TS_131staticBlockSearch() throws InterruptedException 
	{
		String searchstaticBlock = "test";
		this.driver.findElement(By.xpath(loc.getProperty("static_block_search_box"))).sendKeys(searchstaticBlock);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("static_block_search_box"))).clear();
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
	private WebElement ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		return null;
	}

}
