package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
public class SpinnerTest{
  
  public static void main(String[] args){
	SpinnerFrame f=new SpinnerFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
  }
}
class SpinnerFrame extends JFrame{
  public SpinnerFrame(){
	setTitle("SpinnerTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);	

	okButton=new JButton("OK");
	JPanel buttonPanel=new JPanel();
	buttonPanel.add(okButton);
	add(buttonPanel, BorderLayout.SOUTH);
	mainPanel=new JPanel();
	mainPanel.setLayout(new GridLayout(0,3));
	add(mainPanel,BorderLayout.CENTER);
	
	JSpinner defaultSpinner=new JSpinner();
	addRow("Default",defaultSpinner);
	JSpinner boundedSpinner =new JSpinner(new SpinnerNumberModel(5, 0, 10, 0.5));
	addRow("Bounded",boundedSpinner);
	String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	JSpinner listSpinner =new JSpinner(new SpinnerListModel(fonts));
	addRow("List",listSpinner);
	JSpinner reverseListSpinner=new JSpinner(
	  new SpinnerListModel(fonts){
		public Object getNextValue(){
		   return super.getPreviousValue();
		}
		public Object getPreviousValue(){
		   return super.getNextValue();
		}
	  });
	addRow("Rreverse List",reverseListSpinner);
	JSpinner dateSpinner=new JSpinner(new SpinnerDateModel());
	addRow("Date", dateSpinner);
	JSpinner betterDateSpinner = new JSpinner(new SpinnerDateModel());
	String pattern = ((SimpleDateFormat) DateFormat.getDateInstance()).toPattern();
	betterDateSpinner.setEditor(new JSpinner.DateEditor(betterDateSpinner, pattern));
	addRow("Better Date", betterDateSpinner);
	JSpinner timeSpinner=new JSpinner(
	    new SpinnerDateModel(
		new GregorianCalendar(2000, Calendar.JANUARY, 1, 12, 0, 0).getTime(),null, null, Calendar.HOUR));
	addRow("Time",timeSpinner);
	JSpinner permSpinner = new JSpinner(new PermutationSpinnerModel("meat"));
	addRow("Word permutations", permSpinner);
  }
   public void addRow(String labelText, final JSpinner spinner){
	mainPanel.add(new JLabel(labelText));
	mainPanel.add(spinner);
	final JLabel valueLabel=new JLabel();
	mainPanel.add(valueLabel);
	okButton.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent event){
		Object value=spinner.getValue();
		valueLabel.setText(value.toString());
	  }
	
	});

  }
  private JPanel mainPanel;
  private JButton okButton;
  public static final int DEFAULT_WIDTH = 400;
  public static final int DEFAULT_HEIGHT = 300;

}
class PermutationSpinnerModel extends AbstractSpinnerModel{
  public PermutationSpinnerModel(String w){
 	word=w;
  }
  public void setValue(Object value){
	if(!(value instanceof String)) throw new IllegalArgumentException();
	word=(String) value;
	fireStateChanged();
  }  
  public Object getValue(){
	return word;
  }
  public Object getNextValue(){
	int[] codePoints = toCodePointArray(word);
	for (int i = codePoints.length - 1; i > 0; i--){
	   if (codePoints[i - 1] < codePoints[i]){
		 int j = codePoints.length - 1;
		 while (codePoints[i - 1] > codePoints[j]) j--;
		swap(codePoints, i - 1, j);
		reverse(codePoints, i, codePoints.length - 1);
		return new String(codePoints, 0, codePoints.length);
	   }
        }
	reverse(codePoints, 0, codePoints.length - 1);
	return new String(codePoints, 0, codePoints.length);
  }
   public Object getPreviousValue(){
	int[] codePoints = toCodePointArray(word);
	for (int i = codePoints.length - 1; i > 0; i--){
	   if (codePoints[i - 1] > codePoints[i]){
		 int j = codePoints.length - 1;
		 while (codePoints[i - 1] > codePoints[j]) j--;
		swap(codePoints, i - 1, j);
		reverse(codePoints, i, codePoints.length - 1);
		return new String(codePoints, 0, codePoints.length);
	   }
        }
	reverse(codePoints, 0, codePoints.length - 1);
	return new String(codePoints, 0, codePoints.length);
   }
   private static void swap(int[] a, int i, int j){
   	 int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
   }
  private static void reverse(int[] a, int i, int j){
	while (i < j) { swap(a, i, j); i++; j--; }

  }
  private static int[] toCodePointArray(String str){
	int[] codePoints = new int[str.codePointCount(0, str.length())];
	for (int i = 0, j = 0; i < str.length(); i++, j++){
	   int cp = str.codePointAt(i);
	   if (Character.isSupplementaryCodePoint(cp)) i++;
	   codePoints[j] = cp;
	}
	return codePoints;
  }
  private String word;

}