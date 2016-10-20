package swing;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;
public class MouseTest{
  public static void main(String[]args){
	MouseFrame frame = new MouseFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
  }
}
class MouseFrame extends JFrame{
  public MouseFrame(){
	setTitle("Mouse Test");
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	MousePanel panel = new MousePanel();
	add(panel);
  }
  public static final int DEFAULT_WIDTH = 300;
  public static final int DEFAULT_HEIGHT = 200;
} 
class MousePanel extends JPanel{
  private Rectangle2D current;
  private static final int SIDELENGTH=10;
  private ArrayList<Rectangle2D> squares;
  public MousePanel(){
	squares =new ArrayList<Rectangle2D>();
 	current =null;
	addMouseListener(new MouseHandler());
	addMouseMotionListener(new MouseMotionHandler());
  }
  public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2=(Graphics2D) g;
	for(Rectangle2D r:squares) 
	  g2.draw(r);

  }
  public Rectangle2D find(Point2D p){
	for (Rectangle2D r : squares){
	  if (r.contains(p)) return r;
	}
	return null;

  }
  public void remove(Rectangle2D s){
	if(s==null) return;
	if(s==current) current=null;
	squares.remove(s);
	repaint();  

  } 
  public void add(Point2D p){
	double x=p.getX();
	double y=p.getY();
	current =new Rectangle2D.Double( x - SIDELENGTH / 2,y - SIDELENGTH / 2,SIDELENGTH,SIDELENGTH);
	squares.add(current);
	repaint();
  }
  private class MouseHandler extends MouseAdapter{
	public void mousePressed(MouseEvent event){
	  current = find(event.getPoint());
	  if(current==null) add(event.getPoint()); 

	}
	public void mouseClicked(MouseEvent event){
	   current = find(event.getPoint());
	   if(current!=null&& event.getClickCount()>=2) remove(current);

	}
  }
  private class MouseMotionHandler implements MouseMotionListener{
	public void mouseMoved(MouseEvent event){
	   if (find(event.getPoint()) == null)
	  	 setCursor(Cursor.getDefaultCursor());
	   else
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}
	public void mouseDragged(MouseEvent event){
	  if(current!=null){
		int x = event.getX();
		int y = event.getY();
		current.setFrame(x - SIDELENGTH / 2,y - SIDELENGTH / 2,SIDELENGTH,SIDELENGTH);
		repaint();


	  }
	}
  }
}