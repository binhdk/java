package tuyendung;

import java.util.*;

public class CongTy  implements IGenerator{
	private String ten;
	private String diaChi;
	private ArrayList<IListener> ds = new ArrayList<IListener>();

	@Override
	public void addListener(IListener listener){
		if(!ds.contains(listener)) ds.add(listener);
	}
	@Override
	public void removeListener( IListener listener){
		if(ds.contains(listener)) ds.remove(listener);
	}
	public void thongBao(ISuKien sk){
		for (IListener listener : this.ds) {
			listener.xuLy(this, sk);
		}
	}
	public String getDiaChi() {
		return diaChi;
		
	}
	public void setDiaChi( String dc) {
		diaChi=dc;
		
	}

	
}
