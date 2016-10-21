package tuyendung;

import java.util.ArrayList;

public class MoiGioi implements IListener, IGenerator2 {

	private ArrayList<IListener2> ds = new ArrayList<IListener2>();

	@Override
	public void removeListener(IListener2 listener) {
		if (ds.contains(listener))
			ds.remove(listener);

	}

	@Override
	public void addListener(IListener2 listener) {
		if (!ds.contains(listener))
			ds.add(listener);

	}

	public void thongBao(ISuKien sk) {
		for (IListener2 listener : this.ds) {
			listener.xuLy(this, sk);
		}
	}

	@Override
	public void xuLy(IGenerator from, ISuKien sk) {
		System.out.println("Danh sach nhan su di phong van: ");
		for (IListener2 listener : this.ds) {
			if ((listener.xuLy(this, sk))) {
				System.out.println(" " +listener.getTen());
			} else {
				System.out.println("khong co nguoi phu hop");
			}
		}
	}

	

}
