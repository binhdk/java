
package swing;
import javax.swing.*;
public class SimpleFrameTest{
 public static void main(String[] args){
 	SimpleFrame f=new SimpleFrame("Nguyen Van Binh");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	//f.show();

 }

}
class SimpleFrame extends JFrame{
 public SimpleFrame(String title){
	super(title);
	this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

 }
  public static final int DEFAULT_WIDTH = 300;
  public static final int DEFAULT_HEIGHT = 200;


}