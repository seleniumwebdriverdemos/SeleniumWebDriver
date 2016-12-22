import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBrowserOptions {
	
	
	public static String browser = "chrome"; //excel sheet
	public static WebDriver driver;
	

	public static void main(String[] args) {

		if(browser.equals("firefox")){
			
			
			driver = new FirefoxDriver();
			
		}else if(browser.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}else if(browser.equals("ie")){
			
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			
		}else if(browser.equals("microsoft")){
			
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
			
		}
		
		
		driver.get("http://gmail.com");
		String acutal = driver.getTitle();
		String expected = "yahoo.com";
		
		if(acutal.equals(expected)){
			
			System.out.println("Test case pass");
		}else{
			
			System.out.println("Test case fail");
		}
		
		
		
		
		driver.quit();
	}

}
