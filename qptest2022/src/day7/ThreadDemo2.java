package day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadDemo2 {
	public static void main(String[] args) {
		Toilet t1=new Toilet();//new Business();
		Toilet t2=new Toilet();
		ExecutorService es=Executors.newFixedThreadPool(4);//this is what we need to use
		es.execute(()->{
			synchronized(Toilet.class) {
			Thread t=Thread.currentThread();
			t.setName("ramu");
			t1.rr.useRestRoom();
			}
		});
		
		es.execute(()->{
			synchronized(Toilet.class) {
			Thread t=Thread.currentThread();
			t.setName("somu");
			t2.rr.useRestRoom();
			}
		});
		
		es.shutdown();
	}
}

class Toilet{
	static RestRoom rr=new RestRoom();
}

class RestRoom{
	public RestRoom() {
		System.out.println("rest room object created..");
	}

	public void useRestRoom() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is using the rest room...");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println(name+" has come out of rest room...");
	}
}