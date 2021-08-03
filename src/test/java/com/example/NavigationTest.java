package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.AfterMethod;

public class NavigationTest {
	WebDriver driver;
  
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  // set path of Chromedriver executable
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
	  
	  // initialize new WebDriver session
	  driver = new ChromeDriver();
  }
  
  @Test
  public void navigateToAUrl() {
	  // navigate to the website
	  driver.get("https://bccm-portal.projectuat.com/");
	  // Validate page title
	  Assert.assertEquals(driver.getTitle(), "Home – BCCM");
  }
  
  @Test
  
  public void searchPhone() 
  {
	  driver.get("https://bccm-portal.projectuat.com/?s=");
	  WebElement searchButton = driver.findElement(By.className("search-toggle"));
	  searchButton.click();
	  WebElement searchInput = driver.findElement(By.id("search-form-1"));
	  searchInput.sendKeys("BCCM");
	  WebElement searchSubmit = driver.findElement(By.className("search-submit"));
	  searchSubmit.click();
	  Assert.assertEquals(driver.getTitle(), "You searched for BCCM – BCCM");
	  
  }
  @AfterMethod
  public void afterMethod() {
	  // close and quit the browser
	  driver.quit();
  }

}
