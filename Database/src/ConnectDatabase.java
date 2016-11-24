import java.sql.*;
import net.ucanaccess.jdbc.*;
public class ConnectDatabase{
   public static void main(String[] args){
	Connection connection =null;
	try { 
	  Class.forName("net.ucanaccess.jdbc.UcanloadDriver");
	  System.out.println("Loading the driver...");
	}
	catch( Exception e ) {
	  e.printStackTrace();
	  return;
	}
	try {
	String dbURL = "jdbc:ucanaccess://C:\\Users\\gia_nguyen\\Documents\\movies.accdb";
	System.out.println("Establishing connection...");
	connection =DriverManager.getConnection(dbURL);
	//System.out.println("Connect to ” + connection.getCatalog() + “ successfully!");
	Statement s=connection.createStatement();
	ResultSet rs=s.executeQuery("SELECT CATEGORY FROM Movies");
	while(rs.next()){
	  System.out.println(rs.getString(1));
	}
	}
	catch( SQLException e ) {
	e.printStackTrace( );
	}
	
   }
}