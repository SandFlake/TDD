package rovar;

import org.junit.Test;

public class TestChars {
	
	private String lowerCase = "yxmördaren julia blomqvist på fäktning i schweiz";
	
	private String upperCase = "YXMÖRDAREN JULIA BLOMQVIST PÅ FÄKTNING I SCHWEIZ";
	
	private String mixedCase = "Yxmördaren Julia Blomqvist, åt 29(!) pannkakor & 50% all nutella @ täVling i Köpenham/Sverge ";
	
	private String numberCase = "123456789019";
	
	private String symbolCase = "!#¤&/()=?^<";
	
	@Test
	public void testFilledString() {
		String findFault = rovar.enrov(mixedCase);
		System.out.println(findFault);
		
		rovar.derov(findFault);
		System.out.println(rovar.derov(findFault));
		
	}
	
}
