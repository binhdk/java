import java.io.*;
public class RandomAccessDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double data[]={19.4, 10.1, 123.54, 33.0, 87.9, 74.25};
		double d;
		RandomAccessFile rad;
		try{
			rad=new RandomAccessFile("D:\\random.dat","rw");
		}
		catch(IOException exc){
			System.out.println("Cannot open file");
			return;
		}
		for(int i=0;i<data.length;i++){
			try{
				rad.writeDouble(data[i]);
			}
			catch(IOException exc){
				System.out.println("Error writing to file.");
				return ;
			}
		}
		try{
			rad.seek(0);
			d=rad.readDouble();
			System.out.println("First value is "+d);
			rad.seek(8);
			d=rad.readDouble();
			System.out.println("Second value is "+d);
			rad.seek(8 * 3);
			d = rad.readDouble();
			System.out.println("Fourth value is " + d);
			System.out.println();
			System.out.println("Here is every other value: ");
			for(int i=0; i < data.length; i+=2){
				rad.seek(8 * i); 
				d = rad.readDouble();
				System.out.print(d + " ");
			}
			System.out.println("\n");
		}
		catch(IOException exc){
			System.out.println("Error seeking or reading.");
		}
		rad.close();
	}

}
