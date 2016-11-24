package awt;

import java.awt.*;
import java.lang.Integer;
class FlowLayoutDemo
{
public static void main(String args[])
{
Frame fr = new Frame("FlowLayout Demo");
fr.setLayout(new FlowLayout());
fr.add(new Button("Red"));
fr.add(new Button("Green"));
fr.add(new Button("Blue"));
List li = new List();
for (int i=0; i<5; i++)
{
li.add(Integer.toString(i));
}
fr.add(li);
fr.add(new Checkbox("Pick me", true));
fr.add(new Label("Enter your name:"));
fr.add(new TextField(20));
fr.pack();
fr.setVisible(true);		
	}

}
