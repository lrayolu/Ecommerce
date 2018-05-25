package Testcase1;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.java.swing.plaf.windows.resources.windows;


public class Baseclass {

	private WebDriver driver;
        String actualtitle, expectedhometitle = "Home page", expectedtitle = "mobe", expectedresult = "Thank you for registering with Main Website Store.";
	String expectedwish = "Your Wishlist has been shared.";
        boolean flag = true, expectedflag = true,actualvalue = false;
	SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void configTest(){
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	/*@Test
	public void testcase1(){
	
		actualtitle = driver.getTitle();
		softassert.assertEquals(actualtitle, expectedhometitle);
		actualtitle = "";
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		actualtitle = driver.getTitle();
		softassert.assertEquals(actualtitle, expectedtitle);
		softassert.assertAll();
		WebElement webelement = driver.findElement(By.xpath("//div[@class='category-products']/div[1]/div[1]/div/select[@title= 'Sort By']"));
	    Select se = new Select(webelement);
	    se.selectByVisibleText("Name");
	    List<WebElement> list= driver.findElements(By.xpath("//div[@class='category-products']/ul/li/div/h2/a"));
	    for(int i = 0;i<list.size()-1;i++){
	    	String obj1 = list.get(i).getText();
	    	String obj2 = list.get(i+1).getText();
    		System.out.println(obj1.compareTo(obj2));
	    	if(obj1.compareTo(obj2) > 0){
	    		flag = false;
	    	}
	    }
	    softassert.assertEquals(flag,expectedflag);
	}
	
	
	@Test
	public void testcase4(){
		List<String> l = new ArrayList<String>();
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		l.add(driver.findElement(By.cssSelector("a[title='Sony Xperia']")).getText());
		driver.findElement(By.xpath("//a[@title = 'Sony Xperia']/../../div[3]/ul/li[2]/a")).click();
		l.add(driver.findElement(By.xpath("//a[@title = 'IPhone']/../div/h2[@class='product-name']")).getText());
		driver.findElement(By.xpath("//a[@title = 'IPhone']/../../div[3]/ul/li[2]/a")).click();
		driver.findElement(By.cssSelector("button[title='Compare']")).click();
		String mainwindow = driver.getWindowHandle();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()){
			
			String childwindow = itr.next();
			if(!mainwindow.equalsIgnoreCase(childwindow)){
				
				driver.switchTo().window(childwindow);
				
				String message = driver.findElement(By.cssSelector("h1")).getText();
				assertEquals(message,"COMPARE PRODUCTS");
				List<WebElement> list =driver.findElements(By.cssSelector("h2"));
				if(list.size()==l.size()){
				for(int i = 0 ; i < l.size();i++){
					String str = list.get(i).getText();
					 actualvalue =  l.contains(str);
				    assertEquals(actualvalue, expectedflag);
				}
				}
				else{
					 assertEquals(actualvalue, expectedflag);
				}
				driver.close();
			}
		}
			
		driver.switchTo().window(mainwindow);
		
	}
	*/
	@Test
	public void Test5(){
		driver.manage().window().maximize();
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
		driver.findElement(By.id("firstname")).sendKeys("chai512");
		driver.findElement(By.id("lastname")).sendKeys("M1");
		driver.findElement(By.id("email_address")).sendKeys("lekasree@gmail.com");
		driver.findElement(By.id("password")).sendKeys("chai1234");
		driver.findElement(By.id("confirmation")).sendKeys("chai1234");
		driver.findElement(By.xpath("//button[@title = 'Register']")).click();
		String actualresult = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
		softassert.assertEquals(actualresult, expectedresult);
		driver.findElement(By.linkText("TV")).click();
		driver.findElement(By.xpath("//a[@title='LG LCD']/../div/div[3]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//button[@class='button btn-share']")).click();
		driver.findElement(By.id("email_address")).sendKeys("chai123@gmail.com");
		driver.findElement(By.id("message")).sendKeys("check the product");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		String actualwish= driver.findElement(By.xpath("//span[contains(text(),'Your Wishlist')]")).getText();
	    softassert.assertEquals(actualwish, expectedwish);
		softassert.assertAll();
	}
	
	
	@AfterMethod
	public void closeTest(){
		driver.close();
	}
	
}
