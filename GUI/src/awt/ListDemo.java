package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ListDemo extends Frame implements ActionListener {
	 private List li;
	 private Label select;
	 public ListDemo(String title){
		 super(title);
		 li=new List();
		 li.add("Monday");
		 li.add("Tuesday");
		 li.add("Wednesday");
		 li.add("Thursday");
		 li.add("Friday");
		 li.add("Saturday");
		 li.add("Sunday");
		 select=new Label("Click on a day",Label.CENTER);
		 this.setLayout(new BorderLayout());
		 this.add(select,BorderLayout.NORTH);
		 this.add(li,BorderLayout.CENTER);
		 li.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){ 
		 Object source = e.getSource();
		 if (!(source instanceof List))
		 {
			 return;
		 }
		 else
		 {
			 List li = (List) source;
			 String selected = li.getSelectedItem();
			 select.setText(selected);
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new ListDemo("List Demo");
		f.setVisible(true);
		f.setBounds(100,100,200,200);
	}

}

