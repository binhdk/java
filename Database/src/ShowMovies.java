import org.hsqldb.*;
import java.sql.*;
import net.ucanaccess.jdbc.*;
  public class ShowMovies{
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
    String url = "jdbc:ucanaccess://D:\\binh\\java\\java-dev\\Database\\src\\movies.accdb";
   try{
    Class.forName("net.ucanaccess.jdbc.UcanloadDriver");
 	Connection connection =DriverManager.getConnection(url);

    MovieDatabase db = new MovieDatabase(connection);
    db.showAllMovies();
    Movie movie=new Movie(7,"Hello World","Science Fiction","CD");
    db.addMovie(movie);
    connection.close();
  }
   catch(Exception e){
      e.printStackTrace();
  }
 }
}