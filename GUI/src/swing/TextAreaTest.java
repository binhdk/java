package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TextAreaTest{
  public static void main(String[] args) {
	try{
	   JFrame f= new TextAreaTestFrame(); 
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   f.setVisible(true);	
	}
	catch(NullPointerException e){e.printStackTrace();}
  }
}
class TextAreaTestFrame extends JFrame {
  public TextAreaTestFrame(){
	setTitle("FormatTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	buttonPanel =new JPanel();
	JButton insertButton=new JButton("Insert");
	buttonPanel.add(insertButton);
	insertButton.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		textArea.append("The quick brown fox jumps over the lazy dog. ");
	   }
	});
	wrapButton=new JButton(" No Wrap");
	buttonPanel.add(wrapButton);
	wrapButton.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		boolean wrap = !textArea.getLineWrap();
		System.out.print(wrap);
		textArea.setLineWrap(wrap);
		scrollPane.revalidate();
		wrapButton.setText(wrap ? "No Wrap" : "Wrap");
	   }
	});
	add(buttonPanel, BorderLayout.SOUTH);
	textArea = new JTextArea(8, 40);
	scrollPane = new JScrollPane(textArea);
	add(scrollPane, BorderLayout.CENTER);

  } 
   private JTextArea textArea;
   private JScrollPane scrollPane;
   private JPanel buttonPanel;
   private JButton wrapButton;

   public static final int DEFAULT_WIDTH = 500;
   public static final int DEFAULT_HEIGHT = 200;
}