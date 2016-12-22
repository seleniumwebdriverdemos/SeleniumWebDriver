import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestFramesProfilesIniIterator {

	public static void main(String[] args) {
		
		
		ProfilesIni listProfile = new ProfilesIni();
		FirefoxProfile profile = listProfile.getProfile("default");


		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.firstcry.com/");
		driver.manage().window().maximize();
		
	/*System.out.println("---------Generating window ids from first window-------");
		
		Set<String> winids = driver.getWindowHandles(); //
		Iterator<String> itrate = winids.iterator();
		
		String first_window = itrate.next(); //first window id
		System.out.println(first_window);*/
		
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div[2]/span[6]")).click();
		

		driver.switchTo().frame("iframe_Login");
		
		driver.findElement(By.xpath("//*[@id='txtLUNm']")).sendKeys("raman");

		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println(frames.size());
		
		
	}

}
