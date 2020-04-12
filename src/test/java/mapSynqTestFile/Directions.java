package mapSynqTestFile;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mapSynqBaseFile.MapSynqBaseFile;
import mapSynqUtility.MapSynqUtilityFile;

public class Directions extends MapSynqBaseFile{
	
	@Test(priority=1)
	public void loadURL() 
	{
		
		driver.get(propX.getProperty("URL"));
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Open the Url and maximize the window ");
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
	}
	
	@Test(priority=2)
	public void directions() throws InterruptedException 
	{
		driver.findElement(By.xpath(propX.getProperty("directions"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("currentlocation"))).clear();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		driver.findElement(By.xpath(propX.getProperty("currentlocation"))).sendKeys("NOVENA");
		/* wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Autocomplete_fba9c\"]/div[2]/strong")));
		driver.findElement(By.xpath("//*[@id=\"Autocomplete_e9375\"]/div[3]")).click();*/
		
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("closetoggle"))));
		driver.findElement(By.xpath(propX.getProperty("closetoggle"))).click();
		
		
		driver.findElement(By.xpath(propX.getProperty("destination"))).sendKeys("BEDONG");
		//driver.findElement(By.xpath("//*[@id=\"Autocomplete_eb0d2\"]/div[2]")).click();
		driver.findElement(By.xpath(propX.getProperty("getdirections"))).click();
		
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		
		
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("Novena"))));
		
		 driver.findElement(By.xpath(propX.getProperty("Novena"))).click();
		 
		 MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
			test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
			
		
		 wait = new WebDriverWait(driver, 70);
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propX.getProperty("Bedong"))));
		
		driver.findElement(By.xpath(propX.getProperty("Bedong"))).click();
		
		driver.findElement(By.xpath(propX.getProperty("getdirections"))).click();
		MapSynqUtilityFile.takeScreenShot(driver,"E:\\Avishek\\ScreenShot", "ss.png");
		test.log(LogStatus.INFO, " Screen Shot: "+test.addScreenCapture(MapSynqUtilityFile.takeScreenShot(driver, "E:\\Avishek\\ScreenShot", "ss.png")));
		Thread.sleep(3000);
		 try {
			Alert alert = driver.switchTo().alert();
			 alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 test.log(LogStatus.INFO, "No result found  ");
		 
		  /*try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.dismiss();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }*/
		
		/*try {
		    click(myButton);
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}*/
		//driver = new ChromeDriver(dc); 
		//driver.switchTo().alert().dismiss();
		/*Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);*/
		 
		/*try {
		    // Add a wait timeout before this statement to make 
		    // sure you are not checking for the alert too soon.
		    Alert alt = driver.switchTo().alert();
		    alt.accept();
		} catch(NoAlertPresentException noe) {
		    // No alert found on page, proceed with test.
		}*/
		/*try {
		    click();
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}*/
		
		test.log(LogStatus.PASS, "Test Pass");
		rep.endTest(test);
		rep.flush();
	}

	


}
