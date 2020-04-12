package mapSynqTestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mapSynqBaseFile.MapSynqBaseFile;
import mapSynqUtility.MapSynqUtilityFile;

public class Camerars extends MapSynqBaseFile{
	
	@Test(priority=1)
	public void loadURL() throws Exception
	{
		//
		driver.get(propX.getProperty("URL"));
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Open the Url and maximize the window ");
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
	}
	
	@Test(priority=2)
	public void camerars()
	{
		driver.findElement(By.xpath(propX.getProperty("Camerars"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("adamroad"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("aftertuas"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("closetoggle"))));
		driver.findElement(By.xpath(propX.getProperty("closetoggle"))).click();
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		test.log(LogStatus.PASS, "Test Pass");
		rep.endTest(test);
		rep.flush();
	}

}
