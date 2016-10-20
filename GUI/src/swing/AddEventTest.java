package swing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.beans.*;
import java.util.*;
public class AddEventTest{
  public static void main(String[]args){
	AddEventFrame f=new AddEventFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	f.setVisible(true);

  }
}
class AddEventFrame extends JFrame{
  public AddEventFrame(){
	setTitle("Add Event Test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	AddEventPanel panel =new AddEventPanel();
	add(panel);
	JButton but=new JButton("binh");
	panel.addPropertyChangeListener(new PropertyChangeListener(){
	   public void propertyChange(PropertyChangeEvent event){
		
		JButton but2=new JButton(but.getName()+event.getNewValue());
		
	   }
	});
	//panel.add(but2);
  }

  public static final int DEFAULT_WIDTH=300;
  public static final int DEFAULT_HEIGHT=200;
}
class AddEventPanel extends JPanel{
   public void paintComponent(Graphics g)
   {
   	String old =n;n=n+"a";
    	firePropertyChangeEvent(new PropertyChangeEvent(this,"n",old,n));
	
  	super.paintComponent(g);
   }
   public void change(JButton but){
	
	add(but);
  }
   
  public void addPropertyChangeListener(PropertyChangeListener listener){
	listenerList.add(PropertyChangeListener.class ,listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener){
  	listenerList.remove(PropertyChangeListener.class, listener);
  }
  public void firePropertyChangeEvent(PropertyChangeEvent event){
	 EventListener[] listeners = listenerList.getListeners(PropertyChangeListener.class);
	 for (EventListener l : listeners)
	     ((PropertyChangeListener) l).propertyChange(event);
  }
  public String  getn(){ return n;} 
  private String n="binh";
}