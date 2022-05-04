package day8;

import java.sql.Connection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCDemo1 {
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			Connection con=ConnectionUtility.getConnection();
			System.out.println(con);
			
			Connection con2=ConnectionUtility.getConnection();
			System.out.println(con);
		});
		
		es.execute(()->{
			Connection con=ConnectionUtility.getConnection();
			System.out.println(con);
		});
	}
}
