
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	//singleton pattern
	public  static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeTest
	public void openBrowser(){
		
		driver = new FirefoxDriver();
		
		log.debug("Firefox launched");
	}
	
	@AfterTest
	public void quitBrowser(){
		
		driver.quit();
		log.debug("Browser quit");
	}
	
	public static ExcelReader excel = null;
	
	@Test(dataProvider="getData")
	public void testData(String username,String password){
		
		driver.get("http://gmail.com");
		log.debug("Navigated to Gmail");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		
	}
	
	
	

	
	@DataProvider
	public static Object[][] getData(){
		
		//Apache POI API
		
		
		if(excel==null){
			
			excel = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//properties//testdata.xlsx");
			
		}
		
		String sheetName="LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
			
			for(int colNum=0 ; colNum< cols; colNum++){
	
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
			}
		}
		
		
		return data;
		
		
	}
	
	
	
}
