
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebTables {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	
	
		WebElement section =driver.findElement(By.xpath("//div[1]/table/tbody/tr[1]"));

		List<WebElement> tcells = section.findElements(By.tagName("td"));

		System.out.println("Total Number of Columns in table : " + tcells.size());

		for (WebElement data : tcells)
			System.out.print(data.getText()+"  ");
		
	}

}
