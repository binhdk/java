package bt3;

public class SinhVien implements IListener {

	@Override
	public void xuLy(IGenerator from, ISuKien sk) {
		RapPhim r = (RapPhim)from;
		Phim p=(Phim)sk;
		System.out.println("sinh vien biet dia chi rap: "+r.getDiaChi());
		if (p.getDienVien().equals("Chanh Tin"))
			System.out.println("ngay lap tuc di xem");
		else
			System.out.println("di hoc");
	}

	

}
