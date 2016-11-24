package awt;

import java.awt.*;
import java.awt.event.*;
public class MessageBox {
	Dialog msgBox;
	public MessageBox(Frame parentWindow,String msg,String title){
		if(parentWindow==null){
			Frame emptyWindow=new Frame();
			msgBox = new Dialog(emptyWindow, title, true);
		}
		else{
			msgBox = new Dialog(parentWindow, title, true);
		}
		Label Message = new Label(msg);
		msgBox.setLayout(new FlowLayout());
		msgBox.add(Message);
		Button okButton = new Button("OK");
		msgBox.add(okButton);
		msgBox.setBounds(150,150,150,100);
		okButton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					msgBox.setVisible(false);
				}
			});
		
	}
	public void show()
	{
		msgBox.show();
	}
	
}