import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Vui long nhap ten file de nhap du lieu: ");
		String fileInput = in.nextLine();
		System.out.println("Vui long nhap ten file de xuat ket qua: ");
		String fileOutput = in.nextLine();
		in.close();
		Scheduling fcfs = new FCFS();
		Scheduling rr = new RoundRobin();
		try {
			fcfs.readData(fileInput);
			rr.readData(fileInput);
		} catch (NumberFormatException e) {
			System.out.println("File khong hop le, kiem tra file va chay lai chuong trinh!");
			return;
		} catch (IOException e1) {
			System.out.println("Khong tim thay file, kiem tra duong dan dung va chay lai chuong trinh!");
			return;
		}

		if (fcfs.getName().toString().equals("FCFS")) {
			System.out.println("Lap lich CPU: giai thuat " + fcfs.getName());
			fcfs.run();
			try {
				fcfs.writeResult(fileOutput);
			} catch (IOException e) {
				System.out.println("File luu ket qua khong hop le, kiem tra va chay lai chuong trinh!");
				return;
			}
			System.out.println("Run success!");
		} else if (rr.getName().toString().equals("RR")) {
			System.out.println("Lap lich CPU: giai thuat " + rr.getName());
			rr.run();
			try {
				rr.writeResult(fileOutput);
			} catch (IOException e) {
				System.out.println("File luu ket qua khong hop le, kiem tra  va chay lai chuong trình!");
				return;
			}
			System.out.println("Run success!");
		} else {
			System.out.println(" File khong hop le,kiem tra va chay lai chuong trinh!");
		}

	}
}
