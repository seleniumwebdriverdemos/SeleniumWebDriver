import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFluentWait {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		/*String title = driver.getTitle();
		title.length();*/
		/*Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();*/
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
	/*	
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("seleniumwebdriver.demos@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.name("Passwd")).sendKeys("sdfsdfsf");
		driver.findElement(By.cssSelector("#signIn")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']")).getText());
		
		*/
		//implict, explicit wait (WebDriveWait), FluentWait
		//WebDriverWait wait = new WebDriverWait(driver, 30L);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(10, TimeUnit.SECONDS)
			       .pollingEvery(2, TimeUnit.SECONDS)
			       .withMessage("User defined timed out message")
			       .ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email1']")));
		
		
		driver.close(); //current browser window
		driver.quit(); //current browser + all related windows
		
		/*
		WebElement email = driver.findElement(By.xpath(".//*[@id='Email']"));
		email.sendKeys("seleniumwebdriver.demos@gmail.com");
		
		
		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.click();
		*/
		//Thread.sleep(3000);
		
	/*	WebDriverWait wait = new WebDriverWait(driver, 10L);
		WebElement errMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='errormsg_0_Email']")));
		
		System.out.println(errMsg.getText());
		*/
		/*
		WebElement errMsg = driver.findElement(By.xpath("//*[@id='errormsg_0_Email']"));
		System.out.println(errMsg.getText());*/
		
		
	/*	
		WebElement pass = driver.findElement(By.name("Passwd"));
		pass.sendKeys("sdlfjsdof");
		
		WebElement signIn = driver.findElement(By.cssSelector("#signIn"));
		signIn.click();
		
		WebElement errText = driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']"));
		System.out.println(errText.getText());
		*/
		
	}

}
