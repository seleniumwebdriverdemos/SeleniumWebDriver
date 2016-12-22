import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTabandPopups {

	public static void main(String[] args) {



		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		
		System.out.println("----Generating window ids from first window---");
		
		Set<String> winids = driver.getWindowHandles(); //1 window id
		Iterator<String> itrate = winids.iterator();
		
		String first_window = itrate.next(); //first window id
		System.out.println(first_window);
		
		System.out.println("----Generating window ids from second window---");
		
	
		
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		
		winids = driver.getWindowHandles(); //2 window ids 
		itrate = winids.iterator();
		
		System.out.println(itrate.next()); //first window
		String second_window = itrate.next(); //second window
		System.out.println(second_window);
		
		driver.switchTo().window(second_window);
		
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/ul/li[3]/a")).click();
		

		System.out.println("----Generating window ids from third window---");
		
		
		
		winids = driver.getWindowHandles(); //3 window ids 
		itrate = winids.iterator();
		
		System.out.println(itrate.next()); //first window
		System.out.println(itrate.next()); //second window
		String third_window = itrate.next();
		System.out.println(third_window);
	
		
		driver.switchTo().window(third_window);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='eForm_form_applicantPlaceHolder_residenceCity_value']")));
		select.selectByVisibleText("Noida");
		
	/*	
		driver.close(); //3rd
		driver.switchTo().window(second_window);
		driver.close();//2nd
		driver.switchTo().window(first_window);
		driver.close();*/
		
		driver.quit();
		
		

	}

}
