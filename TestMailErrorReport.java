import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestMailErrorReport {
	
	
	@Test
	public void testLogin() throws IOException, AddressException, MessagingException{
		
		WebDriver driver = new FirefoxDriver();
		monitoringMail mail = new monitoringMail();
		
		try{
		driver.get("http://gmail.com");
		
		
		driver.findElement(By.id("Emil")).sendKeys("seleniumwebdriver.demos@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("sdfsdfsd");
		driver.findElement(By.id("signIn")).click();
		}catch(Throwable t){
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\screenshot\\error.jpg"));
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), TestConfig.attachmentPath, TestConfig.attachmentName);
			
		}
		
	}
	

}
