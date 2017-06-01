package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	private static String url = "jdbc:mysql://127.0.0.1:3306/petshopcs";
	private static String username = "root";
	private static String password = "";
	static Connection myconnection=null;
	public Conn(){
		myconnection=getConnection();

	}
	public static Connection getConnection() {
	try {
		//Class.forName(jdbc_driver);
	return DriverManager.getConnection(url,username,password);


	} catch (SQLException e) {
	e.printStackTrace();

	} //catch (Exception e){
		//e.printStackTrace();
	//}

	return null;

	}
}
