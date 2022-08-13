package com.tarea4.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
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

public class LoginStatus {
	WebDriver driver;
	By localizadorSignIn = By.linkText("Sign in");
	By localizadorEmail = By.id("email");
	By localizadorPass = By.id("passwd");
	By localizadorBoton = By.id("SubmitLogin");
	By localizadorError = By.cssSelector("h1.page-heading");
	
	
	
  @Test(dataProvider = "dataAuthentification")
  public void Login(String email, String passw) {
	  
	  if(driver.findElement(localizadorSignIn).isDisplayed()) {
		  driver.findElement(localizadorSignIn).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.presenceOfElementLocated(localizadorEmail));
		  
		  driver.findElement(localizadorEmail).sendKeys(email);
		  driver.findElement(localizadorPass).sendKeys(passw);
		  
		  driver.findElement(localizadorBoton).click();
		  
		  WebDriverWait wait2 = new WebDriverWait(driver, 3);
		  wait2.until(ExpectedConditions.presenceOfElementLocated(localizadorEmail));
		  
		  assertEquals(driver.findElement(localizadorError).getText(), "AUTHENTICATION");
		  
		  
	  }else {
		  System.out.println("No se visualizo el boton sign In");
	  }
	  
  }

  @DataProvider(name = "dataAuthentification")
  public Object[][] dataAuthentification() {
   Object [][] data = new Object[2][2];
   
   data [0][0] = "sarante4@gmail.com";
   data [0][1] = "123131123";
   data [1][0] = "sarante4@gmail.com";
   data [1][1] = "1211212";

   return data;
   
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
	  this.takeSnapShot(driver, "C://Users//18297//OneDrive//Desktop//imagen//LoginStatus.png"); 
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
