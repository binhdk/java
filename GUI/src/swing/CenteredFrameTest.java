package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CenteredFrameTest{
  public static void main(String[] args){
	CenteredFrame f=new CenteredFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	System.out.println(f.isShowing());
  }

}
class CenteredFrame extends JFrame{
  public CenteredFrame(){
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize =kit.getScreenSize();
	int screenHeight=screenSize.height;
	int screenWidth=screenSize.width;
	setSize(screenWidth / 2, screenHeight / 2);
	setLocation(screenWidth / 4, screenHeight / 4);
	Image img = kit.getImage("icon.gif");
	setIconImage(img);
	setTitle("CenteredFrame");
  }
  

}