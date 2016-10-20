package swing;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import swing.ActionPanel.ColorAction;
public class ToolBarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToolBarFrame f=new ToolBarFrame();	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
class ToolBarFrame extends JFrame{
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	private JPanel panel;
	public ToolBarFrame(){
		setTitle("ToolBarTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		panel =new JPanel();
		Action yellowAction =new ColorAction("yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
		Action blueAction =new ColorAction("blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
		Action redAction =new ColorAction("red",new ImageIcon("red-ball.gif"),Color.RED);
		Action exitAction=new AbstractAction("Exit", new ImageIcon("exit.gif")){
			public void actionPerformed(ActionEvent event){
				 System.exit(0);
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		JToolBar bar=new JToolBar();
		bar.add(redAction);
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar, BorderLayout.NORTH);
		JMenu menu=new JMenu("Color");
		menu.add(redAction);
		menu.add(blueAction);
		menu.add(yellowAction);
		menu.add(exitAction);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		add(panel);
	}
	class ColorAction extends AbstractAction{
	    public ColorAction(String name,Icon icon ,Color c){
	    	putValue(Action.NAME,name);
	    	putValue(Action.SMALL_ICON,icon);
	    	putValue(Action.SHORT_DESCRIPTION,"Set panel color to " + name.toLowerCase());
	    	putValue("color", c);
	    }
	    public void actionPerformed(ActionEvent event){
	    	Color c=(Color) getValue("color");
	    	panel.setBackground(c);
	    }
	 }
}
