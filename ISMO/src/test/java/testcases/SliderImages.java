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

public class SliderImages extends BaseTest
{
	public WebDriver driver;
	//Class Constructor 
	public SliderImages() throws IOException
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
	public void TS_80sliderImagesModule()
	{
		this.ClickonElementsbyXpath("slider_image_link");
	}
	@Test(priority=1)
	public void TS_81addsliderImage() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_slider_image");	
		String sliderImageSlotOne = "Test Slot 5";
		driver.findElement(By.xpath(loc.getProperty("slider_image_slot_one"))).sendKeys(sliderImageSlotOne);
		String sliderImageSlotTwo = "Test Slot 6";
		driver.findElement(By.xpath(loc.getProperty("slider_image_slot_two"))).sendKeys(sliderImageSlotTwo);
		String sliderImageUrl = "testurl32";
		driver.findElement(By.xpath(loc.getProperty("slider_image_url"))).sendKeys(sliderImageUrl);
		String sliderImageOrder = "12";
		driver.findElement(By.xpath(loc.getProperty("slider_image_order"))).sendKeys(sliderImageOrder);
		//Image Upload
		this.driver.findElement(By.id(loc.getProperty("slider_image_upload"))).sendKeys("C:\\Users\\quratulain\\Downloads\\slider-img1.jpg");
		this.ClickonElementsbyXpath("slider_image_save_button");
	}
	@Test(priority=2)
	public void TS_82editsliderImage() 
	{ 
		this.ClickonElementsbyXpath("edit_slider_image_button");
		this.ClickonElementsbyXpath("update_slider_image_button");
	}
	@Test(priority=3)
	public void TS_83delsliderImage() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_slider_image_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_slider_image_alert");
	}
	@Test(priority=4)
	public void TS_84filtersliderImage() throws InterruptedException
	{
		this.ClickOnFilter("slider_image_id_filter");
		this.ClickOnFilter("slider_image_slot_one_filter");
		this.ClickOnFilter("slider_image_slot_two_filter");
	}
	@Test(priority=5)
	public void TS_85searchsliderImage() throws InterruptedException 
	{
		String sliderImage = "test";
		this.driver.findElement(By.xpath(loc.getProperty("slider_image_search"))).sendKeys(sliderImage);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("slider_image_search"))).clear();
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void TS_86sliderSetting() throws InterruptedException
	{
		this.ClickonElementsbyXpath("slider_setting_button");
		WebElement transitionDropdown = this.driver.findElement(By.xpath(loc.getProperty("transition_dropdown")));
		Select category = new Select(transitionDropdown);
		category.selectByValue("3");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("update_slider_setting");
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
