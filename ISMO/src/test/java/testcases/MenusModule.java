package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class MenusModule extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public MenusModule() throws IOException 
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
	public void TS_146menuModule() 
	{
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("settings_dropdown_link");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("menu_module_link");
	}
	@Test(priority=1)
	public void TS_147editMenus() 
	{
		this.ClickonElementsbyXpath("edit_menu_button");
		this.ClickonElementsbyXpath("update_menu_button");
	}
	@Test(priority=2)
	public void TS_148editSubMenus() 
	{
		this.ClickonElementsbyXpath("edit_submenu_button");
		this.ClickonElementsbyXpath("about_checkbox_submenu");
		this.ClickonElementsbyXpath("gryphon_checkbox_submenu");
		this.ClickonElementsbyXpath("add_to_menu_button");
		this.ClickonElementsbyXpath("update_submenu_button");
	}
	@Test(priority=3)
	public void TS_149delMenus() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_menu_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_menu_alert");
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void TS_150filtersMenu() throws InterruptedException
	{
		this.ClickOnFilter("menu_id_filter");
		this.ClickOnFilter("menu_name_filter");
		this.ClickOnFilter("menu_theme_filter");
		this.ClickOnFilter("menu_status_filter");
		this.ClickOnFilter("menu_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_151searchMenus() throws InterruptedException 
	{
		String searchRole = "test";
		this.driver.findElement(By.xpath(loc.getProperty("menu_search_box"))).sendKeys(searchRole);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("menu_search_box"))).clear();
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
