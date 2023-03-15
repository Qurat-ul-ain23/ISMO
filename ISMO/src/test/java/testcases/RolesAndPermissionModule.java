package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class RolesAndPermissionModule extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public RolesAndPermissionModule() throws IOException 
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
	public void TS_138RPModule() 
	{
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("settings_dropdown_link");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("roles_permission_module_link");
	}
	@Test(priority=1)
	public void TS_139addRole() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_role_button");
		String roleName = "Role 8";
		this.driver.findElement(By.xpath(loc.getProperty("role_name"))).sendKeys(roleName);
		this.ClickonElementsbyXpath("role_save_button");
	}
	@Test(priority=2)
	public void TS_140selectRole() 
	{
		WebElement categoryDropdown = this.driver.findElement(By.xpath(loc.getProperty("permissions_dropdown_select_role")));
		Select category = new Select(categoryDropdown);
		category.selectByValue("35");;
	}
	@Test(priority=3)
	public void TS_141rolePermission() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("user_checkbox_role");
		this.ClickonElementsbyXpath("faq_checkbox_role");
		this.ClickonElementsbyXpath("update_permission_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("role_breadcrumbs");
	}
	@Test(priority=4)
	public void TS_142editRole() 
	{
		this.ClickonElementsbyXpath("edit_role_button");
		this.ClickonElementsbyXpath("update_role_button");
	}
	@Test(priority=5)
	public void TS_143delRole() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_role_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_role_alert");
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void TS_144filtersRole() throws InterruptedException
	{
		this.ClickOnFilter("role_id_filter");
		this.ClickOnFilter("role_name_filter");
		this.ClickOnFilter("role_createdAt_filter");
	}
	@Test(priority=7)
	public void TS_145searchRole() throws InterruptedException 
	{
		String searchRole = "test";
		this.driver.findElement(By.xpath(loc.getProperty("role_search_box"))).sendKeys(searchRole);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("role_search_box"))).clear();
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
