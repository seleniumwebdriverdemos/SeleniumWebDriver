
public class TestStaticandNonStatic {

	
	public String calc="Calling non static calculator";
	public static String NewCal="Calling static new calculator";
	
	public void add(){
		
		System.out.println("Calling non static add");
		
	}
	
	public static void sub(){
		
		
		System.out.println("Calling static sub");
	}
	
	public static void main(String[] args) {

		TestStaticandNonStatic t = new TestStaticandNonStatic();
		

		NewCal="abcd";
		System.out.println(NewCal);
		sub();
		t.add();

	}

}
