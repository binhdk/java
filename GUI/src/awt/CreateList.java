package awt;


import java.awt.*;
import java.awt.event.*;
public class CreateList implements ActionListener{
	private TextField source;
	private TextArea destination;
	private int counter;
	public CreateList(TextField s,TextArea d){
		source=s;
		destination =d;
	}
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		if (action.equalsIgnoreCase("Enter"))
		{
			String text = source.getText();
			counter++;
			destination.append(counter + "." + text + "\n");
			source.setText("");
		}
		else
			if (action.equalsIgnoreCase("Clear")){
				destination.setText("");
				counter = 0;
			}
		}
}
