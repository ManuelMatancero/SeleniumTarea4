package com.tarea4.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SuscribirseError {
	
	WebDriver driver;
	By locNewsLetter = By.id("newsletter-input");
	By locBotonSender = By.cssSelector("[name=\"submitNewsletter\"]");
	By locError = By.cssSelector("[class=\"alert alert-danger\"]");
	
	
	
	
  @Test
  public void Suscribir() {
	  
	  driver.findElement(locNewsLetter).sendKeys("Josdjskad");
	  driver.findElement(locBotonSender).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 3);
	  wait.until(ExpectedConditions.presenceOfElementLocated(locError));
	  
	  assertEquals(driver.findElement(locError).getText(), "Newsletter : Invalid email address.");
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
  }

  @AfterClass
  public void afterClass() throws Exception {
	  this.takeSnapShot(driver, "C://Users//18297//OneDrive//Desktop//imagen//SuscribirseError.png"); 
	  driver.close();
  }
  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

      //Convert web driver object to TakeScreenshot

      TakesScreenshot scrShot =((TakesScreenshot)webdriver);

      //Call getScreenshotAs method to create image file

              File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

          //Move image file to new destination

              File DestFile=new File(fileWithPath);

              //Copy file at destination

              FileUtils.copyFile(SrcFile, DestFile);
             

  }

}
