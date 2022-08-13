package com.tarea4.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

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

public class Registro {
	
    WebDriver driver;
	By localizadorSignIn = By.linkText("Sign in");
	By localizadorEmail = By.id("email_create");
	By localizadorBotonEmail = By.id("SubmitCreate");
	By localizadorCreate = By.linkText("Create an account");
	By locGenero = By.id("id_gender1");
	By locNombre = By.id("customer_firstname");
	By locApellido = By.id("customer_lastname");
	By locPass = By.id("passwd");
	By locDia = By.id("days");
	By locMes = By.id("months");
	By locYear = By.id("years");
	By locPrimerNombre = By.id("firstname");
	By locApelli2 = By.id("lastname");
	By locAddres = By.id("address1");
	By locCiudad = By.id("city");
	By locState = By.id("id_state");
	By locPostal = By.id("postcode");
	By locPhone = By.id("phone");
	By locTelefono = By.id("phone_mobile");
	By locRegister = By.id("submitAccount");
	
  @Test
  public void Registro() {
	  
	  if(driver.findElement(localizadorSignIn).isDisplayed()) {
		  driver.findElement(localizadorSignIn).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.presenceOfElementLocated(localizadorEmail));
		  
		  driver.findElement(localizadorEmail).sendKeys("hegel.2000000@gmail.com");
		  driver.findElement(localizadorBotonEmail).click();
		  
		  WebDriverWait wait2 = new WebDriverWait(driver, 10);
		  wait2.until(ExpectedConditions.presenceOfElementLocated(locGenero));
		  
		  driver.findElement(locGenero).click();
		  driver.findElement(locNombre).sendKeys("Sagitario");
		  driver.findElement(locApellido).sendKeys("Santos");
		  driver.findElement(locPass).sendKeys("123456");
		  driver.findElement(locDia).sendKeys("1");
		  driver.findElement(locMes).sendKeys("January");
		  driver.findElement(locYear).sendKeys("1999");
		  driver.findElement(locPrimerNombre).sendKeys("Carlos");
		  driver.findElement(locApelli2).sendKeys("Correa");
		  driver.findElement(locAddres).sendKeys("Calle Martinez 2");
		  driver.findElement(locCiudad).sendKeys("Doral");
		  driver.findElement(locState).sendKeys("Colorado");
		  driver.findElement(locPostal).sendKeys("00000");
		  driver.findElement(locPhone).sendKeys("8293332222");
		  driver.findElement(locTelefono).sendKeys("8093332222");
		  driver.findElement(locRegister).click();	  	  
	  }else {
		  
		  System.out.println("No se visualizo el elemento " + driver.findElement(localizadorCreate).getText());
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
	  this.takeSnapShot(driver, "C://Users//18297//OneDrive//Desktop//imagen//Registro.png"); 
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
