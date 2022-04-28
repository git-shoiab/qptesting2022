package day6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerformanceDemo1 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(4);//this is what we need to use
		es.execute(()->{
			Business bu1=Business.createBusiness();//new Business();
			bu1.i=20;
			System.out.println(bu1.i);
		});
		
		es.execute(()->{
			Business bu2=Business.createBusiness();//new Business();
			bu2.i=40;
			System.out.println(bu2.i);
		});
		
		es.shutdown();
		
	}
}

class Business implements Cloneable{
	int i=0;
	private Business() {
		System.out.println("business object created...");
	}
	private static Business business;
	synchronized public static Business createBusiness() {
		if(business==null) {
			business=new Business();
			return business;
		}
		else {
			return business.getClone();
		}
	}
	private Business getClone() {
		try {
			return (Business)super.clone();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}