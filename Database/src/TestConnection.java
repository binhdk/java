import java.sql.*;
import net.ucanaccess.jdbc.*;
public class TestConnection{
public static void main(String args[]) {
Connection connection = null;
	try { 
		Class.forName("net.ucanaccess.jdbc.UcanloadDriver");
		System.out.println("Loading the driver...");
	}
	catch( Exception e ) {
		e.printStackTrace();
		return;
	}
	try {
		String dbURL = "jdbc:ucanaccess://D:\\binh\\java\\java-dev\\Database\\src\\movies.accdb";
		System.out.println("Establishing connection...");
		connection =DriverManager.getConnection(dbURL);
	}
	catch( SQLException e ) {
		e.printStackTrace( );
	}
	finally {
	if( connection != null ) {
	   try { 
		connection.close( ); }
	  catch( SQLException e ) {
		e.printStackTrace( );
	  }
     }
   }
  }
}