package model;

import java.sql.SQLException;
import java.sql.Types;

import dal.DAO;

public class BangDiem {

	private String masv;
	private String maLop;
	private String maMon;
	private int diem;
	private double diemTB;

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getMalop() {
		return maLop;
	}

	public void setMalop(String malop) {
		this.maLop = malop;
	}

	public String getMamon() {
		return maMon;
	}

	public void setMamon(String mamon) {
		this.maMon = mamon;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Double getDiemtb() {
		return diemTB;
	}

	public void setDiemtb(double diemtb) {
		diemTB = diemtb;
	}

	public BangDiem() {
		super();
	}

	public BangDiem(String ms, String ml, String mm, int d) {
		super();
		this.masv = ms;
		this.maLop = ml;
		this.maMon = mm;
		this.diem = d;

	}

	public static boolean updateDiem(BangDiem bangDiem) {
		String query = "UPDATE  BANGDIEM SET DIEM=? WHERE MASV=? AND MAMH=?";
		Object[] params = { bangDiem.getDiem(),Types.INTEGER,bangDiem.getMasv(),Types.CHAR, bangDiem.getMamon(),Types.CHAR};
		try {
			int kq = DAO.executeNonQuery(query, params);
			System.out.println(kq);
			return kq == 1;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(false);
			return false;
		}
	}

	public static boolean xoaDiem(String mssv ) {
		String query = "DELETE  FROM BANGDIEM WHERE MASV=?";
		Object[] params = {mssv,Types.CHAR};
		try {
			int kq = DAO.executeNonQuery(query,params);
			return kq == 1;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}

	public boolean KiemTraDiem(String d, String d1tiet, String dhk) {
		if ((Double.parseDouble(d) < 0) || (Double.parseDouble(d) > 10) | (Double.parseDouble(d1tiet) < 0)
				|| (Double.parseDouble(d1tiet) > 10) || (Double.parseDouble(dhk) < 0)
				|| (Double.parseDouble(dhk) > 10)) {
			return false;
		} else {
			return true;
		}

	}

	public static void addBD(BangDiem d1) throws ClassNotFoundException, SQLException {
		String query = "INSERT  BANGDIEM VALUES(?,?,?,?) ";
		Object[] params = { d1.getMasv(),Types.CHAR, d1.getMalop(),Types.VARCHAR, d1.getMamon(),Types.CHAR, d1.getDiem(),Types.INTEGER };
		DAO.executeNonQuery(query, params);
		
	}

}
