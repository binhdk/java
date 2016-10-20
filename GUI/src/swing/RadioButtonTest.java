package swing;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class RadioButtonTest{
  
  public static void main(String[] args){
	RadioButtonFrame f=new RadioButtonFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
  }
}
//frame set label and radio buttons to select font sizes
class RadioButtonFrame extends JFrame{
  public RadioButtonFrame(){
	setTitle("RadioButtonTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);	
	label=new JLabel("The quick brown fox jumps over the lazy dog.");
	label.setFont(new Font("Serif",Font.BOLD,DEFAULT_SIZE));
	add(label,BorderLayout.CENTER);
	southPanel=new JPanel();
	group = new ButtonGroup();
	addRadioButton("Small",8);
	addRadioButton("Medium", 12);
	addRadioButton("Large", 18);
	addRadioButton("Extra large", 36);
  
	add(southPanel, BorderLayout.SOUTH);
  }
  public  void addRadioButton(String name, final int size){
	boolean selected = size == DEFAULT_SIZE;
	JRadioButton button = new JRadioButton(name, selected);	
	group.add(button);
	southPanel.add(button);
	button.addActionListener( new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		label.setFont(new Font("Serif",Font.PLAIN,size));
	   }
	});
  }
  private JPanel southPanel;
  private JLabel label ;
  private ButtonGroup group; 
  public static final int DEFAULT_WIDTH = 400;
  public static final int DEFAULT_HEIGHT = 200;
  private static final int DEFAULT_SIZE = 12;

}