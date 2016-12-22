import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFlashPlayer {

// Add - FlashWebDriver.java

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.youtube.com/watch?v=cF0EfKPwt3k");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		FlashWebDriver flashObj = new FlashWebDriver(driver, "movie_player");
		
		flashObj.call("pauseVideo");
		Thread.sleep(5000);
		flashObj.call("playVideo");
		Thread.sleep(5000);
		flashObj.call("mute");
		Thread.sleep(5000);
		flashObj.call("unMute");


	}

}
