package Testcase1;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class purchaseProduct {

	private WebDriver driver;
	String actualtext = "Fixed $5.00";
	@BeforeClass
	public void config(){
		
		System.setProperty("webdriver.chrome.driver", "Browser//chromedriver.exe");
		 //driver = new ChromeDriver();	
		driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void url(){
		 driver.get("http://live.guru99.com");
		 driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void addWishlist(){
			driver.manage().window().maximize();
			driver.findElement(By.linkText("MY ACCOUNT")).click();
			driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
			driver.findElement(By.id("firstname")).sendKeys("chai512");
			driver.findElement(By.id("lastname")).sendKeys("M1");
			driver.findElement(By.id("email_address")).sendKeys("chai1234@gmail.com");
			driver.findElement(By.id("password")).sendKeys("lekha12345");
			driver.findElement(By.id("confirmation")).sendKeys("lekha12345");
			driver.findElement(By.xpath("//button[@title = 'Register']")).click();
			//String actualresult = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
			//softassert.assertEquals(actualresult, expectedresult);
			driver.findElement(By.linkText("TV")).click();
			driver.findElement(By.xpath("//a[@title='LG LCD']/../div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//button[@class='button btn-share']")).click();
			driver.findElement(By.id("email_address")).sendKeys("chai1@gmail.com");
			driver.findElement(By.id("message")).sendKeys("check the product");
			driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
			//String actualwish= driver.findElement(By.xpath("//span[contains(text(),'Your Wishlist')]")).getText();
		    //softassert.assertEquals(actualwish, expectedwish);
			//softassert.assertAll();
		
	}
	
	
	@Test(priority = 1)
	public void Test_06(){
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		//driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("lekasree@gmail.com");
		//driver.findElement(By.id("pass")).sendKeys("chai1234");
		//driver.findElement(By.id("send2")).click();
		//driver.findElement(By.linkText("")).click();
		driver.findElement(By.xpath("//div[@class='block-content']/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
        driver.findElement(By.id("billing:street1")).sendKeys("ABCD");
        driver.findElement(By.id("billing:city")).sendKeys("New York");
        driver.findElement(By.id("billing:postcode")).sendKeys("542896");
        driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
        WebElement webelement = driver.findElement(By.id("billing:country_id"));
        Select sel= new Select(webelement);
        sel.selectByVisibleText("United States");
        WebElement webelement1 = driver.findElement(By.id("billing:region_id"));
        Select sel1= new Select(webelement1);
        sel1.selectByVisibleText("New York");
        driver.findElement(By.xpath("//button[@title='Continue']/span/span")).click();
        String text = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText();
        assertEquals(actualtext, text);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button")).click();
        driver.findElement(By.id("p_method_checkmo")).click();
        driver.findElement(By.xpath("//div[@id='payment-buttons-container']/button")).click();
        driver.findElement(By.xpath("//button[@title='Place Order']/span")).click();
        String order = driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println(order);
	}
	
	@AfterClass
	public void configclose(){
		driver.close();
	}
}
