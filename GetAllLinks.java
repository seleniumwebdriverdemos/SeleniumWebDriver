import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class GetAllLinks {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://www.wikipedia.org/");

		
		
	WebElement block = driver.findElement(By.xpath("html/body/div[12]"));
	List<WebElement> Links = block.findElements(By.tagName("a"));

	
	for(int i=0;i<Links.size();i++)
	{
		System.out.println(Links.get(i).getAttribute("href"));
	}
	
	System.out.println("Total Links: " + Links.size());
	
	}

}