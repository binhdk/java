package awt;

import java.awt.*;
public class PanelDemo extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button next, prev, first;
	private List li;
	public PanelDemo(String sTitle){
		super(sTitle);
		next= new Button("Next >>");
		prev =new Button("<< Prev");
		first =new Button("First");
		Panel southPanel=new Panel();
		southPanel.add(next);
		southPanel.add(prev);
		southPanel.add(first);
		this.add(southPanel,BorderLayout.SOUTH);
		Panel northPanel=new Panel();
		northPanel.add(new Label("Make a Selection"));
		this.add(northPanel,BorderLayout.NORTH);
		li =new List();
		for(int i=0;i<10;i++){
			li.add("Selection"+i);
		}
		this.add(li,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container f=new PanelDemo("Panel Demo");
		f.setSize(200, 200);
		f.setVisible(true);
		
	}

}
