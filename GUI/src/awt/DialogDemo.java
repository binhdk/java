package awt;

import java.awt.*;
import java.awt.event.*;
public class DialogDemo {
	public static void main(String[] args){
		createMenu();
	}
	private static void createMenu(){
		final Frame f=new Frame();
		f.setLayout(new BorderLayout());
		MenuBar menuBar =new MenuBar();
		Menu test=new Menu("Test");
		MenuItem testDialog=new MenuItem("Test Dialog");
		testDialog.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MessageBox msgBox=new MessageBox(f,"Here it is ","T/ba Dialog");
				msgBox.show();
			}
			
		});
		test.add(testDialog);
		menuBar.add(test);
		f.setMenuBar(menuBar);
		f.setBounds(100,100,300,200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
}
