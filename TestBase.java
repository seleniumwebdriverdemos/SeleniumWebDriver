package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import util.DbManager;
import util.ExcelReader;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	
	
	@BeforeSuite
	public void setUp() throws IOException, ClassNotFoundException, SQLException{
		
		if(driver==null){
			
			
		
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
				OR.load(fis);
			
				log.debug("OR Properties loaded");
			
			
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
				Config.load(fis);
				log.debug("Config Properties loaded");
			
			
			if(Config.getProperty("browser").equals("firefox")){
				
				
				driver = new FirefoxDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			
		
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 10L);
			DbManager.setDbConnection();
			
		}
		
	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.quit();
		
	}
	
	

}
