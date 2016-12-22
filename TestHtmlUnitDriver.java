import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class TestHtmlUnitDriver {

	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger"); 
	
	public static void main(String[] args) throws IOException {

		
		driver = new HtmlUnitDriver();
		log.debug("Firefox browser launched");
		System.out.println(System.getProperty("user.dir"));

		/*
		 * Reading OR and Config property file
		 * 
		 */
		Properties OR = new Properties();
		Properties Config = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\OR.properties");
		OR.load(fis);
		log.debug("OR properties file loaded");
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Config.properties");
		Config.load(fis);
		log.debug("Config properties file loaded");
		
		driver.get(Config.getProperty("testsiteurl"));
		log.debug("Launched URL : "+Config.getProperty("testsiteurl"));
		
		//System.out.println(Config.getProperty("testsiteurl"));
		driver.findElement(By.xpath(OR.getProperty("email"))).sendKeys("seleniumwebdriver.demos@gmail.com");
		log.debug("Email entered");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("asdfsdf");
		log.debug("Password entered");
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		log.debug("clicked on sign in ");
		String text = driver.findElement(By.xpath(OR.getProperty("errormsg"))).getText();
		log.debug("Got the error message as : "+text);
	
		

	}

}
