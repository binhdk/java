package swing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class BorderTest{
  
  public static void main(String[] args){
	BorderFrame f=new BorderFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
  }
}
//frame set label and radio buttons to select font sizes
class BorderFrame extends JFrame{
  public BorderFrame(){
	setTitle("BorderTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);	
	buttonPanel=new JPanel();
	demoPanel=new JPanel();
	group = new ButtonGroup();
	addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
	addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
	addRadioButton("Etched", BorderFactory.createEtchedBorder());
	addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
	addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
	addRadioButton("Empty", BorderFactory.createEmptyBorder());

  	setLayout(new GridLayout(2, 1));
	add(demoPanel);
	add(buttonPanel);
  }
  public  void addRadioButton(String name, final Border b){
	JRadioButton button = new JRadioButton(name);	
	group.add(button);
	buttonPanel.add(button);
	button.addActionListener( new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		demoPanel.setBorder(b);
		validate();
	   }
	});
  }
  private JPanel buttonPanel;
  private JPanel demoPanel;
  private ButtonGroup group; 
  public static final int DEFAULT_WIDTH = 600;
  public static final int DEFAULT_HEIGHT = 200;

}