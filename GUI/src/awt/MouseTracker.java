package awt;

import java.awt.*;
import java.awt.event.*;
public class MouseTracker extends Frame
implements MouseListener,MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label statusBar;
	public MouseTracker(){
		super("Demonstrating Mouse Events");
		statusBar=new Label();
		this.add(statusBar,BorderLayout.SOUTH);
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize( 275, 100 );
		setVisible( true );
	}
	public void mouseClicked(MouseEvent event){
		statusBar.setText("Clicked at [" + event.getX() +", " + event.getY() + "]");
	}
	public void mousePressed( MouseEvent event ){
		statusBar.setText( "Pressed at [" + event.getX() +", " + event.getY() + "]" );
	}
	public void mouseReleased( MouseEvent event ){
		statusBar.setText( "Released at [" + event.getX() +", " + event.getY() + "]" );
	}
	public void mouseEntered( MouseEvent event ){
		statusBar.setText( "Mouse in window" );
	}
	public void mouseExited( MouseEvent event ){
		statusBar.setText( "Mouse outside window" );
	}
	public void mouseDragged( MouseEvent event ){
		statusBar.setText( "Dragged at [" + event.getX() +", " + event.getY() + "]" );
	}
	public void mouseMoved( MouseEvent event ){
		statusBar.setText( "Moved at [" + event.getX() +", " + event.getY() + "]" );
	}
	public static void main( String args[] ){
		MouseTracker application = new MouseTracker();
	}
}
