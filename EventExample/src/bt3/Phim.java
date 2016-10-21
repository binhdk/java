package bt3;

public class Phim implements ISuKien{
	private String ten;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDienVien() {
		return dienVien;
	}

	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	private String dienVien;
	private double giaVe;
}
