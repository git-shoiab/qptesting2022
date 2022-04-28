package day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadDemo3 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(4);//this is what we need to use
		Bank icici=new Bank();
		es.execute(()->{
			Thread t=Thread.currentThread();
			t.setName("ramu");
			synchronized(icici) {
			icici.credit(1000);
			icici.debit();
			}
		});
		
		es.execute(()->{
			Thread t=Thread.currentThread();
			t.setName("somu");
			synchronized(icici) {
			icici.credit(500);
			icici.debit();
			}
		});
		
		es.shutdown();
	}
}

class Bank{
	int amt;
	public void credit(int amt) {
		this.amt=amt;
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is crediting...:"+amt);
	}
	public void debit() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is debiting...:"+amt);
	}
}