import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		FileInputStream fin;
		FileOutputStream fout;
		try{
			try{
				fin=new FileInputStream("D:\\source.txt");
			}
			catch(FileNotFoundException exc){
				System.out.print("File not found");
				return;
			}
			try{
				fout=new FileOutputStream("D:\\dest.txt");
			}
			catch(FileNotFoundException exc){
				System.out.print("Can not open input file");
				return;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException exc){
			System.out.println("Usage: CopyFile From To");
			return;
		}
		try{
			do{
				i = fin.read();
				if(i != -1) fout.write(i);
			}while(i!=-1);
		}
		catch(IOException exc){
			System.out.println("File Error");
		}
		fin.close();
		fout.close();
	}
}
