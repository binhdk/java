
package bt3;

import java.util.*;

public class RapPhim implements IGenerator {
	private String diaChi;
	
	private ArrayList<IListener> ds = new ArrayList<IListener>();

	@Override
	public void addListener(IListener listener) {
		if (!this.ds.contains(listener)) {
			this.ds.add(listener);
		}
	}

	@Override
	public void removeListener(IListener listener) {
		this.ds.remove(listener);
	}

	@Override
	public void thongBao(ISuKien sk) {
		for (IListener listener : this.ds) {
			listener.xuLy(this, sk);
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
