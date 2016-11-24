import java.sql.*;
import net.ucanaccess.jdbc.*;
public class Connect{
   public static void main(String[] args)throws Exception{
	  Class.forName("net.ucanaccess.jdbc.UcanloadDriver");
	  System.out.println("Loading the driver...");
	
	String dbURL = "jdbc:ucanaccess://D:\\binh\\java\\java-dev\\Database\\src\\movies.accdb";
	System.out.println("Establishing connection...");
	Connection con =DriverManager.getConnection(dbURL);
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("SELECT CATEGORY FROM Movies");
	while(rs.next()){
	  System.out.println(rs.getString(1));
	}
	
   }
}