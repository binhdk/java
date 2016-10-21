import java.io.*;
public class RWData {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DataOutputStream dataOutput;
		DataInputStream dataInput;
		int n=65;
		double x=66;
		char c='c';
		try{
			dataOutput=new DataOutputStream(new FileOutputStream("D:\\testdata.txt"));
		}
		catch(IOException exc){
			System.out.println("Cannot open file");
			return;
		}
		try{
			System.out.println("Writing " +n);
			dataOutput.writeInt(n);
			dataOutput.writeChar(' ');
			System.out.println("Writing "+x);
			dataOutput.writeDouble(x);
			dataOutput.writeChar(' ');
			System.out.println("Writing "+c);
			dataOutput.writeChar(c);
		}
		catch(IOException exc){
			System.out.println("Cannot write on file");
		}
		dataOutput.close();
		System.out.println();
		try{
			dataInput=new DataInputStream(new FileInputStream("D:\\testdata.txt"));
		} 
		catch(IOException exc){
			System.out.println("Cannot read file");
			return;
		}
		try{
			
			n=dataInput.readInt();
			System.out.println("Reading "+n);
			dataInput.readChar();
			x=dataInput.readDouble();
			System.out.println("Reading "+x);
			dataInput.readChar();
			c=dataInput.readChar();
			System.out.println("Reading "+c);
		}
		catch(IOException exc){
			System.out.println("Read Error");
			
		}
		dataInput.close();
	}
	

}
