package com.test.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("<img src=\"images/mast_register.gif\" width=\"492\" height=\"30\">");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");
	By registerUserNameLocator = By.name("userName");
	By registerPasswordLocator = By.name("password");
	By registerBtnSignInLocator = By.name("submit");
	By pageLoginLocator = By.xpath("//h3[contains(text(), 'Login Successfully')]");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registerUser() throws InterruptedException {
	  driver.findElement(registerLinkLocator).click();
	  Thread.sleep(2000);
	  if (driver.findElement(registerLinkLocator).isDisplayed()) {
		  driver.findElement(usernameLocator).sendKeys("aluna93");
		  driver.findElement(passwordLocator).sendKeys("1234");
		  driver.findElement(confirmPasswordLocator).sendKeys("1234");
		  driver.findElement(registerBtnLocator).click();
	  }
	  else {
		  System.out.println("Register pages was not found");
	  }
	  
	  List<WebElement> fonts = driver.findElements(By.tagName("font"));
	  assertEquals("Note: Your user name is aluna93.", fonts.get(5).getText());
	}
	
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(registerUserNameLocator).isDisplayed()) {
		   driver.findElement(registerUserNameLocator).sendKeys("aluna93");
		   driver.findElement(registerPasswordLocator).sendKeys("1234");
		   driver.findElement(registerBtnSignInLocator).click();
		   Thread.sleep(2000);
		   assertTrue(driver.findElement(pageLoginLocator).isDisplayed());
		}
		else
			System.out.println("username testhome was not present");
	}}
