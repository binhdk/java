package awt;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createMenu();
	}
	public static void createMenu(){
		final Frame fr =new Frame();
		fr.setLayout(new BorderLayout());
		MenuBar menu=new MenuBar();
		Menu menuFile =new Menu("Edit");
		MenuItem copyItem=new MenuItem("Ctrl+C");
		MenuItem pasteItem=new MenuItem("Ctr+V");
		menuFile.add(copyItem);
		menuFile.add(pasteItem);
		Menu menuHelp=new Menu("Help");
		MenuItem hTopicItem=new MenuItem("Help Topics");
		MenuItem hAboutitem=new MenuItem("About");
		menuHelp.add(hTopicItem);
		menuHelp.addSeparator();
		menuHelp.add(hAboutitem);
		menu.add(menuFile);
		menu.add(menuHelp);
		fr.setMenuBar(menu);
		fr.setBounds(100,100, 300, 200);
		fr.setTitle("Calculator");
		fr.setVisible(true);
		fr.addWindowListener(
		new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
}
