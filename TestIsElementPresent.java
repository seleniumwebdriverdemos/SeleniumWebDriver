import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestIsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(String xpath){
		
		/*try{
			
		driver.findElement(By.xpath(xpath));
		return true;
		
		}catch(Exception e){
			
			return false;
			
		}*/
		
		int size = driver.findElements(By.xpath(xpath)).size();
		
		if(size==0){
			
			return false;
		}else{
			
			return true;
		}
		
	}

	public static void main(String[] args) {


		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		System.out.println(isElementPresent(".//*[@id='Email']"));
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='Email1']")).isDisplayed());


	}

}
