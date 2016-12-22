import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestRightClick {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		
		WebElement image = driver.findElement(By.xpath("//p[2]/img"));
	
		
		new Actions(driver).contextClick(image).perform();

	}

}
