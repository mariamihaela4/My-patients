package ro.mypatients.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
	private static DBSingleton instance = null;
	private static Connection conn = null ;
	private static DBSingleton conexiune = null;


	private DBSingleton () {
		if(conexiune!=null)
		{
			throw new RuntimeException ("Use getInstance() method to create");
		}
	}

	public static DBSingleton getInstance() {
		if(instance==null) {
			instance=new DBSingleton();			
		}
		return instance;
	}

	public Connection getConnection() {
		String a = "ceva";
		a.intern();
		if(conn==null) {
			try {
				String dbUrl= "jdbc:sqlserver://DESKTOP-S3SK3RH;"
						+ "databaseName=MY PATIENTS.;integratedSecurity=true;";
				conn=DriverManager.getConnection(dbUrl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return conn;
	}
}

//private DBSingleton(){
//
//try {
//	DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
//} catch (SQLException e) {
//	e.printStackTrace();
//}
//if(conn!=null) {
//	throw new RuntimeException("Use getConnection() method to create");
//	}
//	if(instance!=null) {
//		throw new RuntimeException("Use getInstance() method to create");
//}
//}


////////////////////////////////////////////////////////////////////////////////////////
//public static void main(String[] args) {
//	DBSingleton instance= DBSingleton.getInstance();
//	long timeBefore=0;
//	long timeAfter=0;
//	System.out.println(instance);
//	timeBefore=System.currentTimeMillis();
//	Connection conn=instance.getConnection();
//	timeAfter=System.currentTimeMillis();
//	System.out.println(timeAfter-timeBefore);
//	
//}