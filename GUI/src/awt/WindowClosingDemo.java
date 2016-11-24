package awt;

import java.awt.*;
import java.awt.event.*;

public class WindowClosingDemo  implements WindowListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f= new Frame("WindowClosing Demo");
		WindowClosingDemo w=new WindowClosingDemo();
		f.addWindowListener(w);
		f.setBounds(10,10,300,200);
		f.setVisible(true);
	}
	public void windowClosing(WindowEvent e)
	{
	System.out.println("windowClosing..");
	System.exit(0);
	}
	public void windowActivated(WindowEvent e)
	{
	System.out.println("windowActivated...");
	}
	public void windowClosed(WindowEvent e)
	{
	System.out.println("windowClosed...");
	}
	public void windowDeactivated(WindowEvent e)
	{
	System.out.println("windowDeactivated...");
	}
	public void windowDeiconified(WindowEvent e)
	{
	System.out.println("windowDeiconified...");
	}
	public void windowIconified(WindowEvent e)
	{
	System.out.println("windowIconified...");
	}
	public void windowOpened(WindowEvent e)
	{
		System.out.println("windowOpened...");
	}
}



