package model;

import gui.Listener;
import gui.MainWindowns;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dal.DAO;
public class SinhVien {

	private String mssv;
	private String name;
	private Date ngaySinh;
	private String diaChi;
	private String maLop;

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNgaysinh() {
		return ngaySinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaySinh = ngaysinh;
	}

	public String getDiachi() {
		return diaChi;
	}

	public void setDiachi(String diachi) {
		this.diaChi = diachi;
	}

	public String getMalop() {
		return maLop;
	}

	public void setMalop(String malop) {
		this.maLop = malop;
	}

	public SinhVien() {
		super();
	}

	public SinhVien(String ms, String ten, String ml, Date ns, String dc) {
		super();
		this.mssv = ms;
		this.name = ten;
		this.ngaySinh = ns;
		this.diaChi = dc;
		this.maLop = ml;

	}

	public static void add(SinhVien sv) throws SQLException, ClassNotFoundException {

		String query = "INSERT  SV VALUES(?,?,?,?,?) ";
		Object[] params = { sv.getMssv(),Types.CHAR, sv.getName(),Types.VARCHAR, sv.getMalop(),Types.VARCHAR, sv.getNgaysinh(),Types.DATE, sv.getDiachi(),Types.VARCHAR };
		DAO.executeNonQuery(query, params);
	}

	public static boolean remove(String mssv) {
		String query = "DELETE FROM SV WHERE MASV='" + mssv + "'";
		try {
			int kq=DAO.executeNonQuery(query);
			return kq==1;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}

	}

	public static boolean update(SinhVien sv) {
		String query = "UPDATE  SV SET TENSV=?,TENLP=?,NGAY=?,DIACHI=? WHERE MASV=?";
		Object[] params = { sv.getName(),Types.VARCHAR, sv.getMalop(),Types.VARCHAR,sv.getNgaysinh(),Types.DATE, sv.getDiachi(),Types.VARCHAR, sv.getMssv(),Types.CHAR};
		try {
			int kq = DAO.executeNonQuery(query, params);
			return kq == 1;

		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}

	public static SinhVien search(String mssv) {
		String query = "SELECT * FROM SV WHERE MASV='" + mssv + "'";
		ResultSet rs = null;
		try {
			rs = DAO.getResultSet(query);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		SinhVien sv = null;
		try {
			while (rs.next()) {
				sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
			}
		} catch (SQLException e) {
			return null;
		}

		return sv;
	}
	public static void Reset() throws SQLException {
		try {
			Listener.loadDulieu(MainWindowns.getTable(), true);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Lỗi kết nối");
			e1.printStackTrace();
		} 

	}
	public static ArrayList<SinhVien> searchtenSV(String ten) {
		String query = "SELECT * FROM SV WHERE TENSV='" + ten + "'";
		ResultSet rs = null;
		try {
			rs = DAO.getResultSet(query);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		
		ArrayList<SinhVien> list = new ArrayList<>();
//		SinhVien sv=new SinhVien();
		try {
			while (rs.next()) {
//				SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
				list.add( new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));	
			}
		} catch (SQLException e) {
			return null;
		}
		return list;
	}

	public static ArrayList<SinhVien> searchtenLP(String tenLP) {
		String query = "SELECT * FROM SV WHERE TENLP='" + tenLP + "'";
		ResultSet rs = null;
		try {
			rs = DAO.getResultSet(query);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		
		ArrayList<SinhVien> list = new ArrayList<>();
//		SinhVien sv=new SinhVien();
		try {
			while (rs.next()) {
//				SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
				list.add( new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));	
			}
		} catch (SQLException e) {
			return null;
		}
		return list;
	}

	

}
