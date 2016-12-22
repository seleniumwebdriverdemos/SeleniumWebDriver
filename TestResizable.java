import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestResizable {


	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/resources/demos/resizable/default.html");
		driver.manage().window().maximize();
		
		WebElement resizable = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		
		
		new Actions(driver).dragAndDropBy(resizable, 300, 300).perform();
		

	}

}
