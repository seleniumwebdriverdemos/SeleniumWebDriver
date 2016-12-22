import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestReadPropertiesFile {

	
	public static WebDriver driver;
	
	
	public static void captureScreenshot(String path) throws IOException{
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	FileUtils.copyFile(scrFile, new File(path));

		
	}
	
	
	public static void main(String[] args) throws IOException {


		Properties OR = new Properties();
		Properties Config = new Properties();
		
		
		System.out.println(System.getProperty("user.dir"));
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		OR.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		Config.load(fis);
		
		
		System.out.println(OR.getProperty("username"));
		
		System.out.println(Config.getProperty("testsiteurl"));
		
		
		if(Config.getProperty("browser").equals("firefox")){
			
			
			driver = new FirefoxDriver();
			
		}else if(Config.getProperty("browser").equals("ie")){
			
			
			driver = new InternetExplorerDriver();
		
		}if(Config.getProperty("browser").equals("chrome")){
			
			
			driver = new ChromeDriver();
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		
		
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("seleniumwebdriver.demos@gmail.com");
		driver.findElement(By.id(OR.getProperty("nxtBtn"))).click();
		
		
	
		captureScreenshot("f:\\screenshot\\newscreenshot.jpg");
		

	}

}
