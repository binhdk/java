
	package dal;

	import java.sql.Connection;
	import java.sql.DatabaseMetaData;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public class DAO {
		static private Connection con = null;
		static String driver = "com.microsoft.sqlserver.jdbc";
		static String host = "jdbc:sqlserver://VANBINH-PC;databasename=QLSV;";
		static String uName = "sa";
		static String uPass = "root";

		static public Connection createConnection() throws SQLException, ClassNotFoundException {
			// Class.forName(driver);
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return DriverManager.getConnection(host, uName, uPass);
		}

		static public void closeConnection() throws SQLException {
			if (con != null) {
				con.close();
			}
		}

		static public ResultSet getResultSet(String query, Object... params) throws SQLException, ClassNotFoundException {
			con = createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			int j = 1;
			for (int i = 0; i < params.length - 1; i += 2) {
				pst.setObject(j, params[i], (int) params[i + 1]);
				j++;
			}
			return pst.executeQuery();
		}

		static public ArrayList<String> getTableMetadata() throws Exception {
			con = createConnection();
			DatabaseMetaData meta = con.getMetaData();
			String[] table = { "TABLE" };
			ResultSet rs = null;
			ArrayList<String> tables = new ArrayList<String>();
			rs = meta.getTables(null, null, null, table);
			while (rs.next()) {
				tables.add(rs.getString("TABLE_NAME"));
			}
			con.close();
			return tables;
		}

		static public ArrayList<String> getColumnsMetadata() throws Exception {
			con = createConnection();
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rs = null;
			ArrayList<String> tables = getTableMetadata();
			ArrayList<String> columns = new ArrayList<String>();
			for (Object t : tables) {
				rs = meta.getColumns(null, null, (String) t, null);
				while (rs.next()) {
					columns.add(rs.getString("COLUMN_NAME"));
					// columns.add(rs.getString("COLUMN_SIZE"));
					// columns.add(rs.getString("TYPE_NAME"));
				}
			}
			con.close();
			return columns;
		}

		static public int executeNonQuery(String query, Object... params) throws SQLException, ClassNotFoundException {
			con = createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			int j = 1;
			for (int i = 0; i < params.length - 1; i += 2) {
				pst.setObject(j, params[i], (int) params[i + 1]);
				j++;
			}
			int kq = pst.executeUpdate();
			con.close();
			return kq;
		}
	}



