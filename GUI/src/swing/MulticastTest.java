package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MulticastTest{
  public static void main(String[]args){
	MulticastFrame f=new MulticastFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	f.setVisible(true);

  }
}
class MulticastFrame extends JFrame{
  public MulticastFrame(){
	setTitle("Multicast Test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	MulticastPanel panel =new MulticastPanel();
	add(panel);
  }
  public static final int DEFAULT_WIDTH=300;
  public static final int DEFAULT_HEIGHT=200;

}
class MulticastPanel extends JPanel{
  public MulticastPanel(){
	JButton newButton=new JButton("New");
	add(newButton);
	final JButton closeAllButton = new JButton("Close all");
	add(closeAllButton);
	ActionListener newlistener =new ActionListener(){
 	   public void actionPerformed(ActionEvent event){
		BlankFrame fr=new BlankFrame(closeAllButton);
		fr.setVisible(true);
	   }
	};
	newButton.addActionListener(newlistener);
  }
}
class BlankFrame extends JFrame{
  private static int counter=0;
  public static final int DEFAULT_WIDTH=200;
  public static final int DEFAULT_HEIGHT=150;
  private ActionListener closeListener;
  public static final int SPACING = 40;
  public BlankFrame(final JButton closeButton){
	counter++;
	setTitle("Frame "+counter);
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	setLocation(SPACING*counter,SPACING*counter);
	closeListener=new ActionListener(){
	  public void actionPerformed(ActionEvent event){
		closeButton.removeActionListener(closeListener);
		dispose();
	  }
	};
        closeButton.addActionListener(closeListener); 
  }
    
  
}