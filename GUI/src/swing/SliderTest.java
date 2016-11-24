package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
public class SliderTest{
  
  public static void main(String[] args){
	SliderFrame f=new SliderFrame();	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
  }
}
class SliderFrame extends JFrame{
  public SliderFrame(){
	setTitle("SliderTest");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);	
	textField =new JTextField();
	add(textField,BorderLayout.SOUTH);
	sliderPanel=new JPanel();
	sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	listener=new ChangeListener(){
	   public void stateChanged(ChangeEvent event){
		JSlider source =(JSlider) event.getSource();
		textField.setText(""+source.getValue());
	   }
	};
	JSlider slider=new JSlider();
	addSlider(slider,"Plain");

	slider=new JSlider();
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);
	slider.setPaintTicks(true);
	addSlider(slider, "Ticks");

	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setSnapToTicks(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);
	addSlider(slider, "Snap to ticks");

	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);
	slider.setPaintTrack(false);
	addSlider(slider, "No track");

	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);
	slider.setInverted(true);
	addSlider(slider, "Inverted");
	
	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);
	addSlider(slider, "Labels");

	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(5);

	Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
	labelTable.put(0, new JLabel("A"));
	labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));
	slider.setLabelTable(labelTable);
	addSlider(slider, "Custom labels");

	slider = new JSlider();
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	slider.setMajorTickSpacing(20);
	slider.setMinorTickSpacing(20);
	slider.setSnapToTicks(true);
	labelTable = new Hashtable<Integer, Component>();
	labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
        labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
        labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
        labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
        labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
	slider.setLabelTable(labelTable);
	addSlider(slider, "Icon labels");

	add(sliderPanel, BorderLayout.CENTER);

  }
  public void addSlider(JSlider s,String description){
	s.addChangeListener(listener);
	JPanel panel=new JPanel();
	panel.add(s);
	panel.add(new JLabel(description));
	sliderPanel.add(panel);

  }
  private static final int DEFAULT_SIZE = 12;
  public static final int DEFAULT_WIDTH = 400;
  public static final int DEFAULT_HEIGHT = 450;
  private JPanel sliderPanel;
  private JTextField textField;
  private ChangeListener listener;
}