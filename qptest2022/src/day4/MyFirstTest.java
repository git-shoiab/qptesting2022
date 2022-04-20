package day4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFirstTest {
	Calculator calc;
	@Before
	public void before() {
		System.out.println("before every test...");
		calc=new Calculator();
	}
	@After
	public void after() {
		System.out.println("after every test..");
		calc=null;
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class is called...");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("after class is called..");
	}
	@Test
	public void test() {
		//Calculator calc=new Calculator();
		int result=calc.add(10,11);
		System.out.println(result);
		assertEquals(22, result);
	}
	
	@Test
	public void test2() {
		//Calculator calc=new Calculator();
		int result=calc.mul(2,2);
		System.out.println(result);
		assertEquals(4, result);
	}

}
