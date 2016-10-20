package awt;

import java.awt.*;
public class BorderLayoutDemo extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button north, south, east, west, center;
	public BorderLayoutDemo(String sTitles){
		super(sTitles);
		north=new Button("North");
		south = new Button("South");
		east = new Button("East");
		west = new Button("West");
		center = new Button("Center");
		this.add(north,BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
	}
	public static void main(String args[]){
		Frame fr=new BorderLayoutDemo("BorderLayout Demo");
		fr.pack();
		fr.setVisible(true);
	}
}
