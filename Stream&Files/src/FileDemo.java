import java.awt.*;
import java.io.*;
public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("File Demo");
		f.setBounds(10,10,300,200);
		f.setLayout(new BorderLayout());
		Panel p=new Panel(new GridLayout(1,2));
		List list_C= new List();
		list_C.add("C:\\");
		File drive_C=new File("C:\\");
		String[] dir_C=drive_C.list();
		for(int i=0;i<dir_C.length;i++){
			File fi=new File("D:\\"+dir_C[i]);
			if(fi.isDirectory())
				list_C.add("<DIR>"+dir_C[i]);
			else
				list_C.add(" " + dir_C[i]);
		}
		List list_D = new List();
		list_D.add("D:\\");
		File driver_D = new File ("D:\\");
		String[] dirs_D = driver_D.list();
		for (int i=0;i<dirs_D.length;i++)
		{
			File fi = new File ("D:\\" + dirs_D[i]);
			if (fi.isDirectory())
				list_D.add("<DIR>" + dirs_D[i]);
			else
				list_D.add(" " + dirs_D[i]);
		}
		p.add(list_C);
		p.add(list_D);
		f.add(p, BorderLayout.CENTER);
		f.setVisible(true);
	}

}
