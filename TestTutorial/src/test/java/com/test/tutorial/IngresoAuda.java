package com.test.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IngresoAuda {
	
	private WebDriver driver;
	
	By registerPageLocator = By.xpath("//h1[contains(text(), 'Iniciar sesión')]");
	By userNameLocator = By.id("username");
	By userPasswordLocator = By.id("password");
	By buttonSignInLocator = By.xpath("//*[@id=\"kc-form-login\"]/input[3]");
	By buttonSingUpLocator = By.id("frmCerrarSesion:j_idt245");
    By menuLocator = By.id("mobile-menu-button");
    
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.6.43:8380/gtm/ui/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registerUser() throws InterruptedException {
	  if (driver.findElement(userNameLocator).isDisplayed()) {
		  driver.findElement(userNameLocator).sendKeys("ALUNA");
		  driver.findElement(userPasswordLocator).sendKeys("Gtm123456789+");
		  driver.findElement(buttonSignInLocator).click();
		  Thread.sleep(2000);
		  assertTrue(driver.findElement(buttonSingUpLocator).isDisplayed());
	  }
	  else {
		  System.out.println("Register pages was not found");
	  } 
	  
	} 
	
}

