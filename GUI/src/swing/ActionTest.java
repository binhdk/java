package swing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ActionTest{
  public static void main(String[]args){
	ActionFrame f=new ActionFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	f.setVisible(true);

  }
}
class ActionFrame extends JFrame{
  public ActionFrame(){
	setTitle("Action Test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGTH);
	ActionPanel panel =new ActionPanel();
	add(panel);
  }
  public static final int DEFAULT_WIDTH=300;
  public static final int DEFAULT_HEIGTH=200;

}
class ActionPanel extends JPanel{
  public ActionPanel(){
	Action yellowAction =new ColorAction("yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
	Action blueAction =new ColorAction("blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
	Action redAction =new ColorAction("red",new ImageIcon("red-ball.gif"),Color.RED);
	add(new JButton(yellowAction));
	add(new JButton(redAction));
	add(new JButton(blueAction));
	InputMap imap =getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
	imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
	imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
	ActionMap amap=getActionMap();
	amap.put("panel.yellow", yellowAction);
	amap.put("panel.blue", blueAction);
	amap.put("panel.red", redAction);
  }
  public class ColorAction extends AbstractAction{
     public ColorAction(String name,Icon icon ,Color c){
	putValue(Action.NAME,name);
	putValue(Action.SMALL_ICON,icon);
	putValue(Action.SHORT_DESCRIPTION,"Set panel color to " + name.toLowerCase());
	putValue("color", c);
     }
     public void actionPerformed(ActionEvent event){
	Color c=(Color) getValue("color");
	setBackground(c);
     }

  }
  
}