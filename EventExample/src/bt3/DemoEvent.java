package bt3;

public class DemoEvent {
	public static void main(String[] args) {
		RapPhim rap = new RapPhim();
		SinhVien s1 = new SinhVien();
		SinhVien s2 = new SinhVien();
		SinhVien s3 = new SinhVien();
		rap.addListener(s2);
		rap.addListener(s3);
		rap.setDiaChi("Quang Trung");
		
		CongNhan cn = new CongNhan();
		rap.addListener(cn);
		rap.removeListener(s3);
		Phim p = new Phim();
		p.setDienVien("Chanh Tin");
		p.setGiaVe(105);
		rap.thongBao(p);
		//chi cong nhan cung co the
		//duoc moi di xem phim
		
	}
}
