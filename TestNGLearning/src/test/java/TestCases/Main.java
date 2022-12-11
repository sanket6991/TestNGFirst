package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Main {
	//public static Logger log = Logger.getLogger(LoginTestAmazon.class.getName());
	public static void main(String[] args) throws InterruptedException {
//Date d = new Date()'
		
		/*System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure("/home/sanketchakradeo/eclipse-workspace/FirstProj/src/test/resources/Properties/log4j.properties");*/
		void Setup1() extends Main{ 
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		}
		 
		// @Test
		 //Test Case 1 incorrect phone number
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		 driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("860023487");
		 driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		 WebElement E = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4"));
		 String act = E.getText();
		 
		 //@Test;
		 //Test Case 2 incorrect password 
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		 driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		 driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("qwsdvf");
		 driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		 WebElement E1 = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
		 String act1 = E1.getText();
		 
		//@Test;
		 //Test Case 3 successful Login
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		 driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		 driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("QAZxsw23@");
		 driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		 WebElement E2 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		 String act2 = E2.getText();
		 
		//@Test;
		 //Test Case 4 Successfully Logout
		 Actions a = new Actions(driver);
		 a.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span/span"))).build().perform();
		 driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]")).click();
		 WebElement E3 = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/div[1]/label"));
		String act3 = E3.getText();
		 driver.quit();
		 System.out.println("Test 1 Passed:" +act);
		 System.out.println("Test 2 Passed:" +act1);
		 System.out.println("Test 3 Passed:" +act2);
		 System.out.println("Test 4 Passed:" +act3);

		 
	}

 
}

