package swing;


import java.awt.*;
import java.util.EventObject;
import java.awt.event.*;
import javax.swing.*;
public class Calculator{
  public static void main(String[] args){
	CalculatorFrame f=new CalculatorFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);

  }
}
class CalculatorFrame extends JFrame{
  public CalculatorFrame(){
	setTitle("Calculator");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	CalculatorPanel panel=new CalculatorPanel();
	add(panel);
  }
   public static final int DEFAULT_WIDTH = 200;
   public static final int DEFAULT_HEIGHT = 200;

}

class CalculatorPanel extends JPanel{
  public CalculatorPanel(){
	setLayout(new BorderLayout());
	result=0;
	lastCommand = "=";
	start=true;
	display=new JButton("0");
	display.setEnabled(false);
	add(display,BorderLayout.NORTH);
	ActionListener command =new CommandAction();
	ActionListener insert =new InsertAction();
	panel=new JPanel();
	panel.setLayout(new GridLayout(4,4));
	addButton("7",insert);	
	addButton("8",insert);
	addButton("9",insert);
	addButton("/",command);
	addButton("4",insert);
	addButton("5",insert);	
	addButton("6",insert);
	addButton("*",command);
	addButton("1",insert);
	addButton("2",insert);
	addButton("3",insert);	
	addButton("-",command);
	addButton("0",insert);
	addButton(".",command);
	addButton("=",insert);
	addButton("+",command);	
	add(panel, BorderLayout.CENTER);

  }
  public void addButton(String label, ActionListener listener){
	JButton button =new JButton(label);
	button.addActionListener(listener);
	panel.add(button);
  }
  private class InsertAction implements ActionListener    {
       public void actionPerformed(ActionEvent event)
       {
          String input = event.getActionCommand();
          if (start){
             display.setText("");
             start = false;
          }
          display.setText(display.getText() + input);
       }
  }

  private class CommandAction implements ActionListener
    {
       public void actionPerformed(ActionEvent event)
       {
           String command =event.getActionCommand();
	  
	   if(start){
		if(command.equals("-")){
	   	    display.setText(command);
		    start =false;
		}
		else lastCommand=command;
	   }
	   else{
		calculate(Double.parseDouble(display.getText()));
		lastCommand=command;
		start=true;
	   } 
       }
	public void calculate(double x){
	    if(lastCommand.equals("+"))result+=x;
	    else if (lastCommand.equals("-")) result -= x;
	    else if (lastCommand.equals("*")) result *= x;
	    else if (lastCommand.equals("/")) result /= x;
	    else if (lastCommand.equals("=")) result = x;
	    display.setText("" + result);
	}
    }
 
  private double result;
  private JPanel panel;
  private boolean start;
  private String lastCommand;
  private JButton display;
}