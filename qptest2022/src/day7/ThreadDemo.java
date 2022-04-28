package day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public static void main(String[] args) {
		//Thread t1=new Thread(); - this is old and not to be used...
		ExecutorService es=Executors.newFixedThreadPool(4);//this is what we need to use
		es.execute(new MyThreadJob());//this is outer class
		es.execute(new Runnable() {//this is anonymous inner class
			@Override
			public void run() {
				met2();
			}
		});
		es.execute(()->{met3();});//this is lambda
		es.execute(ThreadDemo::met3);//this is method referencing
		
		es.shutdown();
	}
	
	static void met1() {		
		System.out.println("met1 called...");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("met1 completed..");
	}
	
	static int met2() {
		System.out.println("met 2 called...");
		return 100;
	}
	
	static void met3() {
		System.out.println("met3 called....");
	}
}

class MyThreadJob implements Runnable{
	@Override
	public void run() {
		ThreadDemo.met1();	
	}
}