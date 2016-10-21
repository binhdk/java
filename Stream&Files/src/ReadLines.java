import java.io.*;
public class ReadLines {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nhap chuoi.");
		System.out.println("Nhap 'stop' ket thuc chuong trinh.");
		do{
		s=(String)br.readLine();
		System.out.println(s);
		}while(!s.equals("stop"));
	}

}
