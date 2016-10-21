package tuyendung;

public class NhanSu implements IListener2 {
	private String ten;

	@Override
	public boolean xuLy(IGenerator2 from, ISuKien sk) {
		CongViec cv = (CongViec) sk;
		if (cv.getViTri().equals("Manager")) {
			return true;
		} else {
			return false;
		}
	}


	public void xuLy(IGenerator from, ISuKien sk) {
		CongViec cv = (CongViec) sk;
		if (cv.getViTri().equals("Manager")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}

	@Override
	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}

}
