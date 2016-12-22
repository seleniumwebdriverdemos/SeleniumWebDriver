import org.openqa.selenium.edge.EdgeDriver;

public class TestEdge {

	public static void main(String[] args) {


		System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://gmail.com");
		System.out.println(driver.getTitle());
		

	}

}
