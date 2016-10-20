package awt;

import java.awt.*;
import java.awt.event.*;
public class KeyDemo extends Frame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String line1="";
	private String line2="";
	private String line3="";
	private TextArea textArea;
	public KeyDemo(){
		super( "Demonstrating Keystroke Events" );
		textArea =new TextArea(10,15);
		textArea.setText("press any key on keyboard");
		textArea.setEnabled(false);
		this.add(textArea);
		addKeyListener(this);
		setSize( 350, 100 );
		//setVisible( true );
	}
	public void keyPressed(KeyEvent event){
		line1 = "Key pressed: " +KeyEvent.getKeyText( event.getKeyCode() );
		setLines2and3( event );
	}
	public void keyReleased( KeyEvent event ){
		line1 = "Key released: " +KeyEvent.getKeyText( event.getKeyCode() );
		setLines2and3( event );
	}
	public void keyTyped( KeyEvent event ){
		line1 = "Key typed: " + event.getKeyChar();
		setLines2and3( event );
	}
	private void setLines2and3( KeyEvent event ){
		line2 = "This key is " + ( event.isActionKey() ? "" : "not" ) + "an action key";
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers() );
		line3 = "Modifier keys pressed: " + ( temp.equals( "" ) ?"none" : temp );
		textArea.setText(line1+"\n"+line2+"\n"+ line3+"\n" );
	}
	public static void main( String args[] ){
		KeyDemo application;
		application = new KeyDemo();
		application.setVisible(true);
	}
}
