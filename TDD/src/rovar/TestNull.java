package rovar;

import org.junit.Test; 


public class TestNull {
	
	private static String nada = null; 
	

	@Test
	public void testEmpty() {
		rovar.enrov(nada);
		rovar.derov(nada);
		
	}
}


