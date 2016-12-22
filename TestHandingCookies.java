import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestHandingCookies {

	public static WebDriver driver;
	
	public static boolean isElementPresent(String xpath){
		
		try{
			driver.findElement(By.xpath(xpath));
			return true;
		}catch(Throwable t){
			
			return false;
		}
		
	}
	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.checkmytrip.com/cmt/apf/mcmtng/index?LANGUAGE=GB&SITE=NCMTNCMT");
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		if(isElementPresent("//*[@id='CookiePolicy']/div/div/div/div[3]/button")){
			
			driver.findElement(By.xpath("//*[@id='CookiePolicy']/div/div/div/div[3]/button")).click();
		}
		
		

	}

}
