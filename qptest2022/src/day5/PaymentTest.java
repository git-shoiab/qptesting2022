package day5;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.junit.Test;

import junit.framework.Assert;

public class PaymentTest {

	@Test
	public void test() {
		org.jmock.Mockery TestInterfaceMock= new Mockery();

		final Payment testInterface=TestInterfaceMock.mock(Payment.class);

		TestInterfaceMock.checking(new org.jmock.Expectations()

		{{

		oneOf(testInterface).makePayment(102,1000);

		will(returnValue((false)));

		}});
		boolean result=testInterface.makePayment(102,1000);

		System.out.println(result);

		Assert.assertEquals(result, true);

		}
	

}
