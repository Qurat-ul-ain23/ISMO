package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class OurTeam extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public OurTeam() throws IOException 
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
	public void TS_87ourTeamModule()
	{
		this.ClickonElementsbyXpath("our_team_link");
	}
	@Test(priority=1)
	public void TS_88addteamMemberBtn() 
	{
		this.ClickonElementsbyXpath("team_member_button");
	}
	@Test(priority=2)
	public void TS_89addteamMember() throws InterruptedException
	{
		this.ClickonElementsbyXpath("add_team_member_button");
		String teamMemberName = "Member 3";
		driver.findElement(By.xpath(loc.getProperty("team_member_name"))).sendKeys(teamMemberName);
		String teamMemberDesignation = "SQA Engineer";
		driver.findElement(By.xpath(loc.getProperty("team_member_designation"))).sendKeys(teamMemberDesignation);
		Thread.sleep(2000);		//CkEditor 
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		//Manager Category
		WebElement managercategoryDropdown = this.driver.findElement(By.xpath(loc.getProperty("manager_category_team")));
		Select category = new Select(managercategoryDropdown);
		category.selectByValue("6");
		String Order = "Test Order 1";
		driver.findElement(By.xpath(loc.getProperty("order_team_member"))).sendKeys(Order);
		this.ClickonElementsbyXpath("save_team_member");	
	}
	@Test(priority=2)
	public void TS_90editteamMember() 
	{ 
		this.ClickonElementsbyXpath("edit_team_member");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("update_team_member");
	}
	@Test(priority=3)
	public void TS_91delteamMember() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("delete_team_member");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_team_member_alert");
	}
	@Test(priority=4)
	public void TS_92filtersteamMember() throws InterruptedException
	{
		this.ClickOnFilter("team_member_id_filter");
		this.ClickOnFilter("team_member_name_filter");
		this.ClickOnFilter("team_member_designation_filter");
		this.ClickOnFilter("team_member_manager_filter");
		this.ClickOnFilter("team_member_order_filter");
		this.ClickOnFilter("team_member_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_93searchteamMember() throws InterruptedException 
	{
		String searchteamMember = "test";
		this.driver.findElement(By.xpath(loc.getProperty("search_team_member"))).sendKeys(searchteamMember);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("faq_category_search"))).clear();
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("managers_breadcrumbs");
		Thread.sleep(2000);		
	}
	@Test(priority=6)
	public void TS_94addManagerProfile() throws InterruptedException
	{
		this.ClickonElementsbyXpath("add_manager_profile_button");
		String managerName = "Manager 2";	
		driver.findElement(By.xpath(loc.getProperty("enter_manager_name"))).sendKeys(managerName);
		String managerDesignation  = "SQA Engineer";	
		driver.findElement(By.xpath(loc.getProperty("enter_manager_designation"))).sendKeys(managerDesignation);
		Thread.sleep(2000);
		//CK Editor
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		scrollDown(this.driver);
		String managerOrder  = "Order 1";	
		driver.findElement(By.xpath(loc.getProperty("enter_manager_order"))).sendKeys(managerOrder);		
		this.ClickonElementsbyXpath("manager_profile_save_button");
	}
	@Test(priority=7)
	public void TS_95editManagerProfile() 
	{ 
		this.ClickonElementsbyXpath("edit_manager_profile");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("update_manager_profile");
	}
	@Test(priority=8)
	public void TS_96delManagerProfile() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_manager_profile");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_manager_profile_alert");
	}
	@Test(priority=9)
	public void TS_97filtersManagerProfile() throws InterruptedException
	{
		this.ClickOnFilter("manager_id_filter");
		this.ClickOnFilter("manager_name_filter");
		this.ClickOnFilter("manager_designation_filter");
		this.ClickOnFilter("manager_order_filter");
		this.ClickOnFilter("manager_createdAt_filter");
	}
	@Test(priority=10)
	public void TS_98searchManagerProfile() throws InterruptedException 
	{
		String searchManagerProfile = "test";
		this.driver.findElement(By.xpath(loc.getProperty("manager_search_box"))).sendKeys(searchManagerProfile);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("manager_search_box"))).clear();
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
