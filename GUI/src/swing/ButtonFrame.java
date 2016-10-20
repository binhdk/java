package swing;


import java.awt.*;
import java.util.EventObject;
import java.awt.event.*;
import javax.swing.*;
public class ButtonFrame extends JFrame{
  public ButtonFrame(){
	setTitle("Button Test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	ButtonPanel panel=new ButtonPanel();
	add(panel);
	
  }
  public static void main(String[] args){
	ButtonFrame f=new ButtonFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);

  }
   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;

}
class ButtonPanel extends JPanel{
  public ButtonPanel(){	
	//setLayout(new FlowLayout(FlowLayout.RIGHT));
	makeButton("yellow", Color.YELLOW);
   	makeButton("blue", Color.BLUE);
   	makeButton("red", Color.RED);

  }
  public void makeButton(String name,Color backgroundColor){
	JButton button=new JButton(name);
	setLayout(new BorderLayout());
	southPanel.add(button);
	add(southPanel,BorderLayout.SOUTH);
	button.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setBackground(backgroundColor);
            }
         });

  } 
  private JPanel southPanel =new JPanel();
}
/*class ButtonPanel extends JPanel implements ActionListener{
  public ButtonPanel(){
	JButton yellowButton=new JButton("yellow");
	JButton redButton=new JButton("red");
	JButton blueButton=new JButton("blue");
	add(yellowButton);
	add(redButton);
	add(blueButton);
	yellowButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);

  }
 public void actionPerformed(ActionEvent e){
 	source =event.getSource();
	if (source == yellow) setBackground(Color.YELLOW);
	else if (source == blue) setBackground(Color.BLUE);
	else if (source == red) setBackground(Color.RED);
  }
Object source;
}*/
/*class ButtonPanel extends JPanel{
  public ButtonPanel(){
	JButton yellowButton=new JButton("yellow");
	JButton redButton=new JButton("red");
	JButton blueButton=new JButton("blue");
	add(yellowButton);
	add(redButton);
	add(blueButton);
	ColorAction yellowAction = new ColorAction(Color.YELLOW);
	ColorAction blueAction = new ColorAction(Color.BLUE);
	ColorAction redAction = new ColorAction(Color.RED);
	yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

  }
  private class ColorAction implements ActionListener
    {
       public ColorAction(Color c)
       {
          backgroundColor = c;
       }

       public void actionPerformed(ActionEvent event)
       {
          setBackground(backgroundColor);
       }

       private Color backgroundColor;
    }
 

}*/