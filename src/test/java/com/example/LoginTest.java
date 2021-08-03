package com.example;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  // set path of Chromedriver executable
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
	  
	  // initialize new WebDriver session
	  driver = new ChromeDriver();
	  
	  driver.get("https://bccm-portal.projectuat.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  // close and quit the browser
	  driver.quit();
  }
  
  @Test
  public void menuDisplay() {
	  WebElement navigationBar = driver.findElement(By.className("navigation-desktop-level1"));
	  System.out.println("Content of the menu are:" + navigationBar.getText());
  }
  
  @Test
  public void menuAbout() {
	  WebElement aboutLink = driver.findElement(By.linkText("About"));
	  //System.out.println("About link text is: " + aboutLink.getText());
	  Assert.assertEquals(aboutLink.getCssValue("color"), "rgba(0, 0, 0, 1)");
	  Assert.assertEquals(aboutLink.getCssValue("font-size"), "18px");
	  Assert.assertEquals(aboutLink.getCssValue("font-weight"), "700");
  }
  @Test
  public void socialIcon() {
	  WebElement socialIcon = driver.findElement(By.cssSelector(".social-icons a:first-child"));
	  System.out.println(socialIcon.getText());
	  socialIcon.click();
	  System.out.println(driver.getCurrentUrl());
	  
  }
  @Test
  public void menuCoops() {
	  WebElement coopsLink = driver.findElement(By.linkText("Co-ops & mutuals"));
	  Assert.assertEquals(coopsLink.getCssValue("color"), "rgba(0, 0, 0, 1)");
	  Assert.assertEquals(coopsLink.getCssValue("font-size"), "18px");
	  Assert.assertEquals(coopsLink.getCssValue("font-weight"), "700");
	  System.out.println("Co-ops link text is: " + coopsLink.getText());
  }
  @Test
  public void menuHelp() {
	  WebElement helpLink = driver.findElement(By.linkText("Help & advice"));
	  System.out.println("Help link text is: " + helpLink.getText());
	  Assert.assertEquals(helpLink.getCssValue("color"), "rgba(0, 0, 0, 1)");
	  Assert.assertEquals(helpLink.getCssValue("font-size"), "18px");
	  Assert.assertEquals(helpLink.getCssValue("font-weight"), "700");
	  
  }
  @Test
  public void menuCourse() {
	  WebElement courseLink = driver.findElement(By.linkText("Courses & events"));
	  System.out.println("Course text link is: " + courseLink.getText());
	  Assert.assertEquals(courseLink.getCssValue("color"), "rgba(0, 0, 0, 1)");
	  Assert.assertEquals(courseLink.getCssValue("font-size"), "18px");
	  Assert.assertEquals(courseLink.getCssValue("font-weight"), "700"); 
  } 
  @Test
  public void menuNews() {
	  WebElement newsLink = driver.findElement(By.linkText("News"));
	  System.out.println("News link text is: " + newsLink.getText());
	  Assert.assertEquals(newsLink.getCssValue("font-size"), "18px");
	  Assert.assertEquals(newsLink.getCssValue("color"), "rgba(0, 0, 0, 1)");
	  Assert.assertEquals(newsLink.getCssValue("font-weight"), "700");
  }
}
