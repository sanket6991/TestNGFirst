package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	// open browser and Setup browser
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	};

//Test Case 1 incorrect phone number
	@Test
	public void incorrectPhone() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("860023487");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		WebElement E = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4"));
		String act = E.getText();
		System.out.println("Test 1 :" +act);
	};

	// Test Case 2 incorrect password
	@Test
	public void incorrectPassword() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("qwsdvf");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		WebElement E1 = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
		String act1 = E1.getText();
		System.out.println("Test 2 :" +act1);
	};

//Test Case 3 successful Login
	@Test
	public void successfulLogin() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("QAZxsw23@");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		WebElement E2 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		String act2 = E2.getText();
		 System.out.println("Test 3 :" +act2);
	};

//Test Case 4 Successfully Logout
	@Test
	public void successfulLogout() {
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span/span"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]")).click();
		WebElement E3 = driver.findElement(
				By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/div[1]/label"));
		String act3 = E3.getText();
		System.out.println("Test 4 :" +act3);
	};

//Close browser
	@AfterTest
	public void closeBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.quit();
	};
}
