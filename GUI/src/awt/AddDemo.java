package awt;

import java.awt.*;
import java.awt.event.*;
public class AddDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame fr =new Frame("AddDemo App");
		Button buttOk=new Button("OK");
		fr.add(buttOk);
		fr.setSize(100,100);
		fr.setVisible(true);
		fr.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			});
	}

}
