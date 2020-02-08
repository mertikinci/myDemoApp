package com.mycompany.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest extends TestCase{
    public AppTest(String testname){
        super(testname);
        
    }
    public static Test suite(){
        return new TestSuite(AppTest.class);
    }
    

	
	public void testCrypt() {
		String test = "aaaaaa";
		int crypt = -3;
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5,6};
		
		assertEquals(null,new App().cryptoMethod(x1, x2, test, crypt));
		
		//fail("Not yet implemented");
	}
	
	public void testArrayLengths() {
		String test = "aaaaaa";
		int crypt = 3;
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5};
		
		assertEquals(null,new App().cryptoMethod(x1, x2, test, crypt));

	}
	
	public void testArrayLengthsWithString() {
		String test = "aaaa";
		int crypt = 3;
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5,6};
		
		assertEquals(null,new App().cryptoMethod(x1, x2, test, crypt));

	}
	
	public void testResult() {
		String test = "aaaaaa";
		int crypt = 5;
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5,6};
		
		assertEquals("fkpuze",new App().cryptoMethod(x1, x2, test, crypt));

	}
	
	public void testResult2() {
		String test = "aaaaaa";
		int crypt = 6;
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5,6};
		
		assertEquals("gmsyek",new App().cryptoMethod(x1, x2, test, crypt));

	}
	
	

}
