import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExplicitWaits {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
	
		//WebDriverWait wait = new WebDriverWait(driver, 30L);
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(10, TimeUnit.SECONDS)
	       .pollingEvery(2, TimeUnit.SECONDS)
	       .withMessage("User defined message timed out after 10 seconds")
	       .ignoring(NoSuchElementException.class);

		 driver.findElements(By.xpath("//*[contains(text(),'Apply')]")).get(1).click();
		
		// driver.getPageSource()
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email1"))).sendKeys("seleniumwebdriver.demos@gmail.com");

		
		//driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("seleniumwebdriver.demos@gmail.com");
		
		
	}

}
