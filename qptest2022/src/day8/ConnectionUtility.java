package day8;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	private static ThreadLocal<Connection> tLocal=new ThreadLocal<>();
	
	public static Connection getConnection() {
		Connection con=tLocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost/qp","root","root");
				tLocal.set(con);
				return con;
			}catch(Exception e) {e.printStackTrace();return null;}
		}
		else {
			return con;
		}
		
	}
}
