package orangeHRM_modules;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login_screen {
 public WebDriver driver;
 public String baseUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
 public String val_username = "admin";
 public String val_pwd = "admin123";
 public String expected_pagetitle = "OrangeHRM";
 
 
 @BeforeTest
 public void login() {
	 driver = new ChromeDriver();
	 driver.get(baseUrl);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	 
 }
 
 @Test
 public void val_login() {
	 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(val_username);
	 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(val_pwd);
	 driver.findElement(By.cssSelector("button[type='submit']")).submit();
	 if(expected_pagetitle == driver.getTitle()) {
		 System.out.println("successful");
	 }else {
		 System.out.println("fail");
	 }
	 
 }
 
 
 @AfterTest
 public void logout() throws InterruptedException {
	 driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	 driver.close();
	 driver.quit();
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

}
