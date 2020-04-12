package mapSynqTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import mapSynqBaseFile.MapSynqBaseFile;


public class Register extends MapSynqBaseFile{
	
	//open url	
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		
		driver.get(propX.getProperty("URL"));
		
	}
	
	//get title of the home page
	@Test(priority=2)
	public void getTitle()
	{
		s=driver.getTitle();
		if(s!=null)
			System.out.println(s);
		else
			System.out.println("No text is there");
			
	}
	
	//maximize window
	@Test(priority=3)
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	//register page
	@Test(priority=4)
	public void registerLink()
	{
		driver.findElement(By.xpath(propX.getProperty("RegisterLink"))).click();
		driver.findElement(By.xpath(propX.getProperty("registertext"))).click();
		s=driver.getTitle();
		if(s!=null)
			System.out.println(s);
		
	}
	
	
	@Test(dataProvider="register", priority=5)
	
		public void register(String firstname, String lastname, String address, String contact, String email, 
				String password, String confirmpassword){
		System.out.println(firstname);
		System.out.println(lastname);
		driver.findElement(By.xpath(propX.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(propX.getProperty("lastname"))).sendKeys(lastname);
		//driver.findElement(By.xpath(propX.getProperty("country"))).sendKeys(pass);
		driver.findElement(By.xpath(propX.getProperty("address"))).sendKeys(address);
		driver.findElement(By.xpath(propX.getProperty("contact"))).sendKeys(contact);
		 WebElement dateBox = driver.findElement(By.xpath(propX.getProperty("dob")));

	        //Fill date as mm/dd/yyyy as 08/23/1985

	        dateBox.sendKeys("23-08-1985");
	        driver.findElement(By.xpath(propX.getProperty("emailtext"))).click();
		driver.findElement(By.xpath(propX.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(propX.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(propX.getProperty("confirmpassword"))).sendKeys(confirmpassword);
		
	        //driver.findElement(By.xpath(propX.getProperty("emailtext"))).click();
		
	}
	
	
	
	
	
	
		

}
