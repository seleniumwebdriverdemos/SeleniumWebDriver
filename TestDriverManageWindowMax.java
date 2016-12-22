import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDriverManageWindowMax{

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		/*String title = driver.getTitle();
		title.length();*/
		/*Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();*/
		
		driver.manage().window().maximize();

	}

}
