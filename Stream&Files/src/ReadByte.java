import java.io.*;
public class ReadByte {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte data[]=new byte[100];
		System.out.println("Enter some character: ");
		System.in.read(data);
		System.out.println("Your enter:");
		for(int i=0;i<data.length;i++){
			System.out.print((char)data[i]);
		}
		
	}

}
