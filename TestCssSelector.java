import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestCssSelector {
	
	public static WebDriver driver;
	public static String mailscreenshotpath;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	
	public static Logger log = Logger.getLogger(TestCssSelector.class);
	
	public static void captureScreenshot() throws IOException{
		
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	mailscreenshotpath = "c:\\softwares1\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
		
		
		FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
	
		
	}

	public static void main(String[] args) throws IOException, AddressException, MessagingException {

		
		System.out.println(System.getProperty("user.dir"));
		
		monitoringMail mail = new monitoringMail();
		
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		OR.load(fis);
		
			log.debug("OR Properties file loaded");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		Config.load(fis);
		
			log.debug("config Properties file loaded");
		
		
			log.debug(OR.getProperty("username"));
			log.debug(Config.getProperty("browser"));
		
		
		try{
			
			if(Config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				log.debug("Firefox Launched");
				
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				driver = new ChromeDriver();
				
			}
		
		
		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(OR.getProperty("username"))).sendKeys("seleniumwebdriver.demos@gmail.com");
		driver.findElement(By.cssSelector(OR.getProperty("next1"))).click();
		
		driver.findElement(By.cssSelector(OR.getProperty("password"))).sendKeys("sdfsdfd");
		driver.findElement(By.cssSelector(OR.getProperty("signin"))).click();
		}catch(Throwable t){
			
			t.printStackTrace();
			
			log.debug(t);
			captureScreenshot();
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), mailscreenshotpath, TestConfig.attachmentName);
		}
	
		
		

	}

}
