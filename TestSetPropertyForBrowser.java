import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestSetPropertyForBrowser{

	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "c:\\softwares\\chromedriver.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://google.com");

	}

}
