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

public class Contactos {
	
	WebDriver driver;
	By locContacto = By.cssSelector("[title=\"Contact Us\"]");
	By locCustomerService = By.cssSelector("[class=\"page-heading bottom-indent\"]");
	By locSubject = By.id("id_contact");
	By locEmail = By.id("email");
	By locMessage = By.id("message");
	By locBoton = By.id("submitMessage");
	By locStatus = By.cssSelector("[class=\"alert alert-success\"]");
	
	
  @Test
  public void Contacto() {
	  
	  if(driver.findElement(locContacto).isDisplayed()) {
		  driver.findElement(locContacto).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 3);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locEmail));
		  
		  driver.findElement(locSubject).sendKeys("Customer service");
		  driver.findElement(locEmail).sendKeys("manuel0@gmail.com");
		  driver.findElement(locMessage).sendKeys("Hola como estas sensei");
		  driver.findElement(locBoton).click();  
		  
		  assertEquals(driver.findElement(locStatus).getText(), "Your message has been successfully sent to our team.");
		  
	  }else {
		  
		  System.out.println("El elemento Contact Us no se mostro");
	  }
	  
	  
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
	  this.takeSnapShot(driver, "C://Users//18297//OneDrive//Desktop//imagen//Contacto.png"); 
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
