import java.io.*;
public class ReadChars {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		char c;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nhap chuoi ky tu, gioi han dau cham.");
		do{
			c=(char)br.read();
			System.out.println(c);
		}while(c!='.');
	}

}
