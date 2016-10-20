package awt;

import java.awt.*;
public class NullLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("NullLayout Demo");
		f.setLayout(null);
		Button buttYes=new Button("Yes");
		buttYes.setBounds(100, 150, 50, 30);
		Button buttCancel=new Button("Cancel");
		buttCancel.setBounds(200, 150, 50, 30);
		Checkbox chekBut=new Checkbox("Check Box",false);
		chekBut.setBounds(100, 50, 100, 20);
		List li = new List();
		for (int i=0; i<5; i++){
			li.add(Integer.toString(i));
		}
		li.setBounds(200, 50, 50, 50);
		f.add(buttYes);
		f.add(buttCancel);
		f.add(chekBut);
		f.add(li);
		f.setBounds(0, 10, 500, 300);
		f.setVisible(true);
	}

}
