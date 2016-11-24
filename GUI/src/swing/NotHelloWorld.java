package swing;

import javax.swing.*;
import java.awt.*;
public class NotHelloWorld extends JFrame{
  public static void main(String[]args){
	JFrame f=new NotHelloWorld("Not Hello World Program");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	f.setVisible(true);
  }
  public NotHelloWorld(String title){
	super(title);
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	//NoPanel panel = new NoPanel();
	JPanel panel=new JPanel();
	Label label=new Label("Not Hello,World Program");
	panel.add(label);
	add(panel);
  }
  public static final int DEFAULT_WIDTH = 300;
  public static final int DEFAULT_HEIGHT = 200;
}
//class NoPanel extends JPanel{
//  public void paintComponent(Graphics g){
//	super.paintComponent(g);
//	g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
//
//  }
//   public static final int MESSAGE_X = 75;
//   public static final int MESSAGE_Y = 100;
//
//}