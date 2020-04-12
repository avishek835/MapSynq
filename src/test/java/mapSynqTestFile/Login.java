package mapSynqTestFile;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mapSynqBaseFile.MapSynqBaseFile;

public class Login extends MapSynqBaseFile {
	
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		
		driver.get(propX.getProperty("URL"));
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser loaded");
	}
	
	@Test(priority=2)
	
		public void clickSignInLink() 
	{
		
		driver.findElement(By.xpath(propX.getProperty("signinlink"))).click();
		test.log(LogStatus.PASS, "Click on Sign in button");
		
	}
	
	@Test(priority=3)
	public void loginCrediential()
	{
		driver.findElement(By.xpath(propX.getProperty("Email"))).sendKeys("avi@mailinator.com");
		driver.findElement(By.xpath(propX.getProperty("pass"))).sendKeys("123456");
		//driver.findElement(By.xpath(propX.getProperty("signin"))).click();
	}
		
}
