package swing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.*;
public class EventSourceTest{
  public static void main(String[]args){
	EventSourceFrame f=new EventSourceFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	f.setVisible(true);

  }
}
class EventSourceFrame extends JFrame{
  public EventSourceFrame(){
	setTitle("EventSource Test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	final PaintCountPanel panel =new PaintCountPanel();
	add(panel);
	panel.addPropertyChangeListener( new PropertyChangeListener(){
	    public void propertyChange(PropertyChangeEvent event){
		setTitle("EventSource Test - "+event.getNewValue());	    
	    }
	});
  }
  public static final int DEFAULT_WIDTH=300;
  public static final int DEFAULT_HEIGHT=200;

}
class PaintCountPanel extends JPanel{
  public void paintComponent(Graphics g){
	int oldPaintCount =paintCount;
	paintCount++;
	firePropertyChangeEvent(new PropertyChangeEvent(this,"paintCount",oldPaintCount,paintCount));
	super.paintComponent(g);
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
  public int getPaintCount(){
	return paintCount;
  }
  private int paintCount;

}