package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class PostsModule extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public PostsModule() throws IOException 
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
	public void TS_18postModule() 
	{
		this.ClickonElementsbyXpath("post_module_link");
	}
	@Test(priority=1)
	public void TS_19addPost() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_post_button");
		String postTitle = "Post26";
		this.driver.findElement(By.xpath(loc.getProperty("post_title"))).sendKeys(postTitle);
		Thread.sleep(2000);
		//CkEditor 
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		WebElement categoryDropdown = this.driver.findElement(By.xpath(loc.getProperty("post_category")));
		Select category = new Select(categoryDropdown);
		category.selectByValue("2");
		this.driver.findElement(By.id(loc.getProperty("choose_image"))).sendKeys("C:\\Users\\quratulain\\Downloads\\post.png");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("publish_button");
		String postTableName = this.driver.findElement(By.xpath(loc.getProperty("post_table_name"))).getText();

		if(postTableName.contains(postTitle))
		{
			System.out.print("Post Added successfully...!");
		}
		else
		{
			System.out.println("Post is not added....!");
		}
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void TS_20editPost() 
	{
		this.ClickonElementsbyXpath("edit_post");
		this.ClickonElementsbyXpath("update_button");
	}
	@Test(priority=3)
	public void TS_21delPost() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_post_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_button");
	}
	@Test(priority=4)
	public void TS_22filtersPost() throws InterruptedException
	{
		this.ClickOnFilter("post_id_filter");
		this.ClickOnFilter("post_title_filter");
		this.ClickOnFilter("post_category_filter");
		this.ClickOnFilter("post_keyword_filter");
		this.ClickOnFilter("post_status_filter");
		this.ClickOnFilter("post_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_23searchPost() throws InterruptedException 
	{
		String searchPost = "test";
		this.driver.findElement(By.xpath(loc.getProperty("post_search"))).sendKeys(searchPost);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("post_search"))).clear();
		Thread.sleep(2000);
	}
	
	@Test(priority=6)
	public void TS_24viewPost() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("view_post");
		scrollDown(this.driver);
		switchToWindowIndex(1);
		Thread.sleep(3000);
		this.driver.close();
	}

	@AfterClass
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}

	public void switchToWindowIndex(int index) {
		Set<String> windowHandles = this.driver.getWindowHandles();
		List<String> windowStrings = new ArrayList<String>(windowHandles);
		String reqWindow = windowStrings.get(index);
		this.driver.switchTo().window(reqWindow);

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
