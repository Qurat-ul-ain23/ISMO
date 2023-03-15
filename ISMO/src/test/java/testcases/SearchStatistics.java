package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;
import org.openqa.selenium.JavascriptExecutor;

public class SearchStatistics extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public SearchStatistics() throws IOException 
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
	public void TS_122searchStatisticsModule() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("search_statistic_module_link");
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void TS_123startandendDateSearch() throws InterruptedException 
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('start_date').value='01/09/2022 11:34'");
		js.executeScript("document.getElementById('end_date').value='17/12/2022 11:34'");
		js.executeScript("document.getElementById('start_date_hidden').value='2022-09-01 11:34:00'");
		js.executeScript("document.getElementById('end_date_hidden').value='2022-12-17 11:34:00'");
		this.ClickonElementsbyXpath("search_button_ss");
		Thread.sleep(2000);	
	}
	@Test(priority=2)
	public void TS_124clearSearch()
	{
		this.ClickonElementsbyXpath("clear_search_button");
	}
	@Test(priority=3)
	public void TS_125exportButton()
	{
		this.ClickonElementsbyXpath("search_statistic_export_btn");
	}
	@Test(priority=4)
	public void TS_126filtersearchStatistic() throws InterruptedException
	{
		this.ClickOnFilter("search_statistic_keyword_filter");
		this.ClickOnFilter("search_statistic_count_filter");
	}
	@Test(priority=5)
	public void TS_127searchStatistics() throws InterruptedException 
	{
		String searchstatistic = "test";
		this.driver.findElement(By.xpath(loc.getProperty("search_statistic_search_box"))).sendKeys(searchstatistic);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("search_statistic_search_box"))).clear();
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
