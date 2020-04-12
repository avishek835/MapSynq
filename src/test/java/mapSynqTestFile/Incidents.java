package mapSynqTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mapSynqBaseFile.MapSynqBaseFile;
import mapSynqUtility.MapSynqUtilityFile;


public class Incidents extends MapSynqBaseFile{
	
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		
		driver.get(propX.getProperty("URL"));
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Open the Url and maximize the window ");
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
	}
	
	@Test(priority=2)
	public void incidentsList() throws Exception
	{
		
		driver.findElement(By.xpath(propX.getProperty("firstlist"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("secondlist"))).click();
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
	}
	
	//search by vehicle, clear the field, close the toogle, and again search 
	@Test(priority=3)
	public void incedentsSearch()
	{
		driver.findElement(By.xpath(propX.getProperty("search"))).sendKeys("vehicle");
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("search"))).clear();
		
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("closetoggle"))));
		driver.findElement(By.xpath(propX.getProperty("closetoggle"))).click();
		
		test.log(LogStatus.INFO, "Clear the search field and enter the search value Roadworks ");
		driver.findElement(By.xpath(propX.getProperty("search"))).sendKeys("roadworks");
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		test.log(LogStatus.PASS, "Test Pass");
		rep.endTest(test);
		rep.flush();
	}
	

}
