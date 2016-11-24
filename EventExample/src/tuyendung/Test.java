package tuyendung;

public class Test {
	public static void main(String[] args){
		CongTy ct =new CongTy();
		ct.setDiaChi("Ho Chi Minh");
		System.out.println(ct.getDiaChi());
		NhanSu nhanSu=new NhanSu();
		nhanSu.setTen("Nguyen Van Binh");
		NhanSu nhanSu2=new NhanSu();
		nhanSu2.setTen("Nguyen Van Tuan");
		MoiGioi moiGioi=new MoiGioi();
		moiGioi.addListener(nhanSu);
		moiGioi.addListener(nhanSu2);
		ct.addListener(moiGioi);
		CongViec cv =new CongViec();
		cv.setViTri("Manager");
		ct.thongBao(cv );
	}
	
}
