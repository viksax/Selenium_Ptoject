package automation_proj.module.tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_Signup {

	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
        System.setProperty("webdriver.edge.driver","C:\\Users\\HP\\Desktop\\edgedriver_win64\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void signUp() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()=' Sign up! ']")).click();//*[@id="login_block"]/div/ul/li[1]/a
		
		    WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
	        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
	        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
	        WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
	        WebElement pass=driver.findElement(By.xpath("//input[@name='pass1']"));
	        WebElement conPass=driver.findElement(By.xpath("//input[@name='pass2']"));
	        WebElement submitBtn=driver.findElement(By.xpath("//button[@name='submit']"));
	        
	        
	        
	        firstName.sendKeys("test_user");
	        lastName.sendKeys("02");
	        email.sendKeys("vikrant.saxena1909@gmail.com");
	        userName.sendKeys("TestUser_20");
	        pass.sendKeys("qwertyuiop@123");
	        conPass.sendKeys("qwertyuiop@123");
	        Thread.sleep(2000);
	        submitBtn.click();
	        
	        Thread.sleep(3000);
	        
	      
	        String actual = driver.findElement(By.xpath("//p[contains(text(),'Dear')]")).getText();
	        String expected = "test_user 02";
	        Assert.assertTrue(actual.contains(expected));
	        
	       
	        driver.findElement(By.xpath("//button[@name='next']")).click();
	        
	        
	       /* String actual = driver.getTitle();
	        String expected = "elearning - elearning - Registration";
	        //Assert.assertTrue(actual.contains(expected));
	        Assert.assertEquals(actual, expected,"True");*/
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[contains(text(),'Inbox')]")).click();
	        
	      driver.findElement(By.xpath("//a[@href='http://elearningm1.upskills.in/main/messages/new_message.php?f=social']")).click();
	
	      driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vikrant");
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//li[text()='vikrant qwwe']")).click();
	      
	      driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("my assigned project");
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//button[@name='compose']")).click();
	      
	
	
	
	
	}
	
	
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
