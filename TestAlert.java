import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestAlert {

	
	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
		
		List<WebElement> textboxes = driver.findElements(By.xpath(".//*[@id='load_form']/fieldset[1]/input"));

		for(int i=0; i<textboxes.size();i++){
			
			textboxes.get(i).sendKeys(""+i+"");
			
		}
		
		textboxes.get(0).sendKeys("username");
	}

}
