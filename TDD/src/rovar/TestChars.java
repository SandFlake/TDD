package rovar;

import org.junit.Test;

public class TestChars {
	
	private String lowerCase = "yxm�rdaren julia blomqvist p� f�ktning i schweiz";
	
	private String upperCase = "YXM�RDAREN JULIA BLOMQVIST P� F�KTNING I SCHWEIZ";
	
	private String mixedCase = "Yxm�rdaren Julia Blomqvist, �t 29(!) pannkakor & 50% all nutella @ t�Vling i K�penham/Sverge ";
	
	private String numberCase = "123456789019";
	
	private String symbolCase = "!#�&/()=?^<";
	
	@Test
	public void testFilledString() {
		String findFault = rovar.enrov(mixedCase);
		System.out.println(findFault);
		
		rovar.derov(findFault);
		System.out.println(rovar.derov(findFault));
		
	}
	
}
