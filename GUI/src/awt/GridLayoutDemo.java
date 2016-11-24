package awt;

import java.awt.*;
public class GridLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame fr=new Frame("GridLayout Demo");
		fr.setLayout(new GridLayout(3,2));
		fr.add(new Button("Red"));
		fr.add(new Button("Green"));
		fr.add(new Button("Blue"));
		fr.add(new Checkbox("Pick me",true));
		fr.add(new Label("Enter name here:"));
		fr.add(new TextField());
		fr.pack();
		fr.setVisible(true);
	}

}
