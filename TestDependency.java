import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependency {
	
	@Test
	public void userReg(){
		
		System.out.println("Register a user");
		Assert.fail("User reg was not successful");
	}
	
	
	@Test(dependsOnMethods="userReg")
	public void loginTest(){
		
		System.out.println("Login test");
		
	}

}
