package bt3;

public class CongNhan implements IListener {

	@Override
	public void xuLy(IGenerator from, ISuKien sk) {
		Phim p=(Phim)sk;
		if (p.getGiaVe() < 100)
			System.out.println("di xem!");
		else
			System.out.println("chi ban di lam!");
	}

}
