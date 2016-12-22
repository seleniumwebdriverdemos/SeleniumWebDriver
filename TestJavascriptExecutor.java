import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestSubmitButton {
	
	public static void main(String[] args) {
		
		ProfilesIni listProfile = new ProfilesIni();
		FirefoxProfile profile = listProfile.getProfile("default");



		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		
		((JavascriptExecutor) driver).executeScript("myFunction()");
		
		//driver.findElement(By.xpath("html/body/button")).click();
		((JavascriptExecutor) driver).executeScript("document.getElementById('mySubmit').style.color = 'magenta';");

		/*

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='6px groove green'", element);

		*/
	}

}
