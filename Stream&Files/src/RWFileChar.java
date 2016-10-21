import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class RWFileChar {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String s;
		FileReader fr;
		FileWriter fw;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try{
			fw=new FileWriter("D:\\unicode.txt");
			
		}
		catch(IOException exc){
			System.out.println("Cannot open file");
			return;
		}
		System.out.println("Nhap ('stop' de ket thuc chuong trinh).");
		do{
			System.out.println(":");
			s=br.readLine();
			if(s.compareTo("stop")==0) break;
			else{
				s=s+"\r\n";
				fw.write(s);
			}
		}while(s.compareTo("stop")!=0);
		fw.close();
		
		fr=new FileReader("D:\\unicode.txt");
		
		BufferedReader br2 = new BufferedReader(fr);
		System.out.println("du lieu trong file da ghi: ");
		while((s=br2.readLine())!=null){
			System.out.println(s+'\n');
		}
		fr.close();
		
		
	}

}
