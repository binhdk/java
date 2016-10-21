import java.io.*;
public class PrintWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		double x=12.22;
		PrintWriter pr=new PrintWriter(System.out,true);
		pr.println("gia tri cua i va x la: "+i+" "+x);
		pr.println();
		
		
	}

}
