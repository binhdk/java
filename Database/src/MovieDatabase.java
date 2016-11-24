import java.sql.*;
  public class MovieDatabase{
  private Connection connection;
  private PreparedStatement findByNumber, updateCategory;
  private CallableStatement findByCategory;
  public MovieDatabase(Connection connection) throws SQLException{
      this.connection = connection;
  }
  public void showAllMovies(){
  try{
       Statement selectAll = connection.createStatement();
       String sql = "SELECT * FROM Movies";
       ResultSet results = selectAll.executeQuery(sql);
       while(results.next()){
          int number = results.getInt(1);
          String title = results.getString("title");
          String category = results.getString(3);
          String format = results.getString(4);
          Movie movie = new Movie(number, title, category,
          format);
          System.out.println(movie.toString());
    }
   results.close();
   selectAll.close();
  }
   catch(SQLException e){
       e.printStackTrace();
    }
  }
  public void addMovie(Movie movie){
   try{
	 Statement addMovie= connection.createStatement();
	String sql = "INSERT INTO Movies VALUES("
	+ movie.getNumber() + ", "
	+ "'" + movie.getMovieTitle() + "', "
	+ "'" + movie.getCategory() + "', "
	+ "'" + movie.getFormat() + "')";
	// String sql="INSERT INTO Movies VALUES(movie.getNumber(),movie.getTitle(),movie.getCategory(),movie.getFormat())";
   	 //String sql = "INSERT INTO Movies VALUES("+ movie.getNumber()+ "," + "'" + movie.getTitle() + "'," + "'"+ movie.getCategory() + "'," + "'" + movie.getFormat() + "')";
   	 System.out.println("Executing statement: " + sql);
   	 addMovie.executeUpdate(sql);
   	 addMovie.close();
   }
   catch(SQLException e){
     e.printStackTrace();
   }
  }
}