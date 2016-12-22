import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestExcelParameterization extends TestCase1 {
	
	@DataProvider
	public static Object[][] getData(){
		
		 if(excel == null){
				// load the Excel sheet
				excel = new ExcelReader("c://selenium//testData.xlsx");
					
			}
		 
			String sheetName="loginTest";
			int rows = excel.getRowCount(sheetName);  // Get Row Count
			int cols = excel.getColumnCount(sheetName);  // Get Col Count
			Object data[][] = new Object[rows-1][cols]; //-1
		
			
			for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
				
				for(int colNum=0 ; colNum< cols; colNum++){
					
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
				}
			}
		
		return data;
		
		
	}
	
	@Test(dataProvider="getData")
	public void testData(String username,String password,String is_correct){

		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Passwd")).sendKeys(password);
	}

}
