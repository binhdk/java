package swing;


import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class DrawTest{
  public static void main(String[] args){
	DrawFrame f=new DrawFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);	  
 }
} 
class DrawFrame extends JFrame{
  public static final int DEFAULT_WIDTH=400;
  public static final int DEFAULT_HEIGHT=400;
  public DrawFrame(){
	setTitle("Draw test");
	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	DrawPanel panel=new DrawPanel();
	add(panel);
  }
}
class DrawPanel extends JPanel{
  public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2=(Graphics2D) g;
	double leftX=100;
	double topY=100;
	double width=200;
	double height=150;
	Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);
	g2.setPaint(new Color(0,125,125));
	g2.fill(rect);
	//g2.draw(rect);
	Ellipse2D ellipse = new Ellipse2D.Double();
	ellipse.setFrame(rect);
	g2.setPaint(Color.BLUE);
	g2.draw(ellipse);
	g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));
	double centerX = rect.getCenterX();
	double centerY = rect.getCenterY();
	double radius = 150;
	Ellipse2D circle = new Ellipse2D.Double();
	circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
	g2.setPaint(Color.RED);
	g2.draw(circle);
	g2.setPaint(Color.RED);
	String s= "Nguyen Van Binh";
	Font font =new Font("Serif",Font.BOLD,30);
	g2.setFont(font);
	g2.drawString(s,50,50);
        Image image=null;
	try{
	String url="D:\\binh\\java\\java-dev\\GUI\\src\\swing\\Desert.jpg";
	  image =ImageIO.read(new File(url));
	}catch(IOException e){e.printStackTrace();}
	if (image == null) return;
	g2.drawImage(image,0,0,null);
	int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
	for (int i = 0; i * imageWidth <= getWidth(); i++)
          for (int j = 0; j * imageHeight <= getHeight(); j++)
            if (i + j > 0)
               g.copyArea(0, 0, imageWidth, imageHeight,
                   i * imageWidth, j * imageHeight);
   
	
  }
  
}
