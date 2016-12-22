import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestMouseOver {

	
	public static void main(String[] args) {


		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.jabong.com");
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		WebElement menu = driver.findElement(By.partialLinkText("KIDS"));

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		driver.findElement(By.linkText("Shirts")).click();
		
		//thread.sleep(20000);

	}

}
