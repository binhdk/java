import java.io.*;
public class ShowFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		FileInputStream file;
		try {
			file=new FileInputStream("D:\\text.txt");
		}
		catch(FileNotFoundException exc){
			System.out.println("File Not Found");
			return;
		}
		catch(ArrayIndexOutOfBoundsException exc){
			System.out.println("Usage: ShowFile File");
			return;
		}
		do{
			i=file.read();
			if(i!=-1) System.out.print((char)i);
		}while(i!=-1);
		file.close();
	}

}
