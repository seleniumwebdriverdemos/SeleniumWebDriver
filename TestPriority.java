import org.testng.annotations.Test;

public class TestPriority {
	
	@Test(priority=1)
	public void one(){
		
		System.out.println("Executing Test One");
	}
	
	@Test(priority=2)
	public void two(){
		
		System.out.println("Executing Test Two");
	}
	
	
	@Test(priority=3)
	public void three(){
		
		System.out.println("Executing Test Three");
	}
	
	
	@Test(priority=4)
	public void four(){
		
		System.out.println("Executing Test Four");
	}

}
