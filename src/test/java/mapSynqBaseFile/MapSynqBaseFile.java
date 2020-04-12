package mapSynqBaseFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import mapSynqUtility.MapSynqUtilityFile;




public class MapSynqBaseFile {
	public Properties propX;
	
	protected ExtentReports rep=MapSynqUtilityFile.getInstance();
	protected ExtentTest test;
	protected WebElement element;
	protected WebDriverWait wait;
	protected JavascriptExecutor jse;
	protected WebDriver driver;
	protected String s;
		
	protected MapSynqBaseFile(){
	MapSynqUtilityFile up= new MapSynqUtilityFile();
	propX=up.getProp();
	}
	
	
	@BeforeClass
	public void setup() throws Exception
	{
		test=rep.startTest("Testting Started ");
		test.log(LogStatus.PASS, "Browser loaded");
		String browserName = propX.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		}else if(browserName.equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
	}
	
	@AfterClass
	public void teardown() throws Exception
	{
		driver.close();
		test.log(LogStatus.INFO, "Coming back to home page");
		test.log(LogStatus.PASS, "Test Pass");
		rep.endTest(test);
		rep.flush();
		
	}
	
	@DataProvider(name="register")
	 
	 public Object[][] register() {
			Object[][] arrayObject = getExcelData("E:\\GithubProjects\\mapsynq\\mapsynq\\src\\test\\java\\mapSynqTestFile\\DataProvider.xls","Register");
			return arrayObject;
	}
	
	@DataProvider(name="getProduct")
	 
	 public Object[][] getProduct() {
			Object[][] arrayObject = getExcelData("E:\\Avishek\\SeleniumProjects\\GIT\\4crewBackend\\4crewBackened\\src\\test\\java\\FourCrewData.xls","AddProduct");
			return arrayObject;
	}
	
	
	
	
	 public String[][] getExcelData(String fileName, String sheetName) 
	 {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) 
				{
					for (int j=0; j < totalNoOfCols; j++) 
					{
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}
				}
				fs.close();
				} catch (FileNotFoundException e) 
						{
							e.printStackTrace();
						} catch (IOException e) 
								{
									e.printStackTrace();
									//e.printStackTrace();
								} catch (BiffException e) 
										{
											e.printStackTrace();
										}
			return arrayExcelData;
		}


}
