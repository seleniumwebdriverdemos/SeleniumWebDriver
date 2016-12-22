import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestKeyboard {

	
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Email")).sendKeys("seleniumwebdriver.demos@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("sdfsdf");
	
		driver.findElement(By.xpath("//div[2]/img")).click();
		
		
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.chord(Keys.CONTROL,"a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
		driver.findElement(By.id("Email")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform();
		
		

	}

}
