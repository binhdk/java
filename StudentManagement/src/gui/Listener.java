package gui;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dal.DAO;
import model.BangDiem;
import model.SinhVien;
import net.proteanit.sql.DbUtils;

public class Listener {
	static public void loadDulieu(JTable t, boolean tatCa)
			throws ClassNotFoundException, SQLException {
		String query = "select * from SV";
		ResultSet rs = DAO.getResultSet(query);
		t.setModel(DbUtils.resultSetToTableModel(rs));
	}

	static public void loadDulieuDiem(JTable t, boolean tatCa)
			throws ClassNotFoundException, SQLException {
		String query = "select * from BANGDIEM";
		ResultSet rs = DAO.getResultSet(query);
		t.setModel(DbUtils.resultSetToTableModel(rs));
	}

	public static void update(JTextField textMSSV, JTextField textTen,
			JTextField textLop, JTextField textDate, JTextField textDiaChi,
			JTextField textDiem1, JTextField textDiem2, JTextField textDiem3) {
		String masv = textMSSV.getText();
		String ten = textTen.getText();
		String lop = textLop.getText();
		String ngaySinh = textDate.getText();
		System.out.println(ngaySinh);
		String diaChi = textDiaChi.getText();
		Integer diem1 = !textDiem1.getText().toString().equals("") ? Integer
				.parseInt(textDiem1.getText()) : 0;
		Integer diem2 = !textDiem2.getText().toString().equals("") ? Integer
				.parseInt(textDiem2.getText()) : 0;
		Integer diem3 = !textDiem3.getText().toString().equals("") ? Integer
				.parseInt(textDiem3.getText()) : 0;
		BangDiem diem = new BangDiem(masv, lop, "M01", diem1);
		BangDiem.updateDiem(diem);
		diem = new BangDiem(masv, lop, "M02", diem2);
		BangDiem.updateDiem(diem);
		diem = new BangDiem(masv, lop, "M03", diem3);
		BangDiem.updateDiem(diem);
		SinhVien sv = new SinhVien(masv, ten, lop, Date.valueOf(ngaySinh),
				diaChi);
		SinhVien.update(sv);
	}

	public static DefaultTableModel search(String mssv) {
		SinhVien sv = SinhVien.search(mssv);
		DefaultTableModel mod = null;
		if (sv != null) {
			Object[] columnNames = { sv.getMssv(), sv.getName(), sv.getMalop(),
					sv.getNgaysinh(), sv.getDiachi() };
			Object[] title = { "MASV", "TENSV", "MALP", "NGAY", "DIACHI" };
			mod = new DefaultTableModel(title, 0);
			mod.addRow(columnNames);
		} else {
			Object[] title = { "Khong tim thay du lieu" };
			mod = new DefaultTableModel(title, 0);
		}
		return mod;
	}

	public static DefaultTableModel searchten(String Tensv) {
		ArrayList<SinhVien> sv = SinhVien.searchtenSV(Tensv);
		// DefaultTableModel mod = null;

		// mod.setRowCount(sv.size()+1);
		DefaultTableModel mod = null;
		if (!sv.isEmpty()) {
			Object[] title = { "MASV", "TENSV", "MALP", "NGAY", "DIACHI" };
			mod = new DefaultTableModel(title, 0);
			for (int i = 0; i < sv.size(); i++) {
				Object[] columnNames = { sv.get(i).getMssv(),
						sv.get(i).getName(), sv.get(i).getMalop(),
						sv.get(i).getNgaysinh(), sv.get(i).getDiachi() };
				mod.addRow(columnNames);
			}

		} else {
			Object[] title2 = { "Khong tim thay du lieu" };
			mod = new DefaultTableModel(title2, 0);
		}
		return mod;
	}

	public static DefaultTableModel searchtenlop(String TenLP) {
		ArrayList<SinhVien> sv = SinhVien.searchtenLP(TenLP);

		DefaultTableModel mod = null;
		if (!sv.isEmpty()) {
			Object[] title = { "MASV", "TENSV", "MALP", "NGAY", "DIACHI" };
			mod = new DefaultTableModel(title, 0);
			for (int i = 0; i < sv.size(); i++) {
				Object[] columnNames = { sv.get(i).getMssv(),
						sv.get(i).getName(), sv.get(i).getMalop(),
						sv.get(i).getNgaysinh(), sv.get(i).getDiachi() };
				mod.addRow(columnNames);
			}

		} else {
			Object[] title2 = { "Khong tim thay du lieu" };
			mod = new DefaultTableModel(title2, 0);
		}
		return mod;
	}

	public static boolean remove(String mssv) {
		SinhVien.remove(mssv);
		BangDiem.xoaDiem(mssv);
		return false;
	}

	public static void add(JTextField textMSSV, JTextField textTen,
			JTextField textLop, JTextField textDate, JTextField textDiaChi) {
		String masv = textMSSV.getText();
		String ten = textTen.getText();
		String lop = textLop.getText();
		String ngaySinh = textDate.getText();
		String diaChi = textDiaChi.getText();
		SinhVien sv = new SinhVien(masv, ten, lop, Date.valueOf(ngaySinh),
				diaChi);
		try {
			SinhVien.add(sv);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
