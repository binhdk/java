package awt;

import java.awt.*;
public class CheckboxDemo {
	public static void main(String[] args){
	Checkbox blue,red,green;
	Frame ff=new Frame("Checkbox Demo");
	Panel f=new Panel();
	red=new Checkbox("red",false);
	blue=new Checkbox("blue",true);
	green=new Checkbox("green",true);
	f.add(green);
	f.add(red);
	f.add(blue);
	ff.add(f, BorderLayout.NORTH);
	ff.pack();
	ff.setVisible(true);
	}
}