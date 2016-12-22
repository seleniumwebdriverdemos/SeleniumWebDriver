import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestWebDriverWait {


	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MILLISECONDS);
		driver.get("http://www.gmail.com/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.withMessage("This is my own message waited for 10 seconds");
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd1"))).sendKeys("sdfsdf");
	
		
		
		

	}

}
