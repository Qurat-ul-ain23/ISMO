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

public class UsersModule extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public UsersModule() throws IOException 
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
	public void TS_132userModule() 
	{
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("settings_dropdown_link");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("users_module_link");
	}
	@Test(priority=1)
	public void TS_133addUser() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_user_button");
		String userName = "Automated User 4";
		this.driver.findElement(By.xpath(loc.getProperty("user_full_name"))).sendKeys(userName);
		String userEmail = "automateduser4@mailinator.com";
		this.driver.findElement(By.xpath(loc.getProperty("user_email"))).sendKeys(userEmail);
		WebElement roleDropdown = this.driver.findElement(By.xpath(loc.getProperty("user_role_dropdown")));
		Select categoryRole = new Select(roleDropdown);
		categoryRole.selectByValue("91");
		String userDesignation = "SQA Engineer";
		this.driver.findElement(By.xpath(loc.getProperty("user_designation"))).sendKeys(userDesignation);
		WebElement userStatusDropdown = this.driver.findElement(By.xpath(loc.getProperty("user_status_dropdown")));
		Select category = new Select(userStatusDropdown);
		category.selectByValue("1");
		this.ClickonElementsbyXpath("user_save_button");
	}
	@Test(priority=2)
	public void TS_134editUser() 
	{
		this.ClickonElementsbyXpath("edit_user");
		this.ClickonElementsbyXpath("update_user_button");
	}
	@Test(priority=3)
	public void TS_135delUser() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_user_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_user_alert");
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void TS_136filtersUsers() throws InterruptedException
	{
		this.ClickOnFilter("user_id_filter");
		this.ClickOnFilter("user_name_filter");
		this.ClickOnFilter("user_email_filter");
		this.ClickOnFilter("user_designation_filter");
		this.ClickOnFilter("user_role_filter");
		this.ClickOnFilter("user_status_filter");
		this.ClickOnFilter("user_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_139searchUsers() throws InterruptedException 
	{
		String searchUser = "test";
		this.driver.findElement(By.xpath(loc.getProperty("user_search_box"))).sendKeys(searchUser);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("user_search_box"))).clear();
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
