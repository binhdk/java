package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxTest{
  
  public static void main(String[] args){
	CheckBoxFrame f=new CheckBoxFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
  }
}
class CheckBoxFrame extends JFrame{
  public CheckBoxFrame(){
	setTitle("CheckboxTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);	
	label=new JLabel("The quick brown fox jumps over the lazy dog.");
	label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
	add(label,BorderLayout.CENTER);
	ActionListener listener =new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		int mode=0;
		if(bold.isSelected()) mode+=Font.BOLD;
		if(italic.isSelected()) mode+=Font.ITALIC;
		label.setFont(new Font("Serif",mode,FONTSIZE));
	   }
	};
	JPanel southPanel=new JPanel();
	bold=new JCheckBox("Bold");
	bold.addActionListener(listener);
	southPanel.add(bold);
	italic =new JCheckBox("Italic");
	italic.addActionListener(listener);
	southPanel.add(italic);
	add(southPanel,BorderLayout.SOUTH);
	
  }
  
  private JLabel label ;
  private JCheckBox bold;
  private JCheckBox italic;
  public static final int DEFAULT_WIDTH = 300;
  public static final int DEFAULT_HEIGHT = 200;
  public static final int FONTSIZE=14;
}